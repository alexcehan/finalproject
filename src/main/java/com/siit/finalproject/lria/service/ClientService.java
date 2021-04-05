package com.siit.finalproject.lria.service;

import com.siit.finalproject.lria.domain.entity.ClientEntity;
import com.siit.finalproject.lria.domain.entity.FlightEntity;
import com.siit.finalproject.lria.domain.model.ClientDto;
import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.domain.model.ClientDtoResponse;
import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.exception.ClientNotFoundException;
import com.siit.finalproject.lria.exception.FlightNotFoundException;
import com.siit.finalproject.lria.exception.TicketNotFoundException;
import com.siit.finalproject.lria.mapper.client.ClientDtoPostRequestToClientEntityMapper;
import com.siit.finalproject.lria.mapper.client.ClientEntityToClientDtoMapper;
import com.siit.finalproject.lria.repository.ClientRepository;
import com.siit.finalproject.lria.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoPostRequestToClientEntityMapper clientDtoPostRequestToClientEntityMapper;
    private final ClientEntityToClientDtoMapper clientEntityToClientDtoMapper;
    private final FlightRepository flightRepository;
    private final TicketService ticketService;

    // get a all clients
    @Transactional(readOnly = true)
    public List<ClientDtoResponse> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientEntity -> clientEntityToClientDtoMapper.mapEntityToDto(clientEntity))
                .collect(toList());
    }




    //create a new client / add a client to a flight
    @Transactional(readOnly = false)
    public ClientDtoResponse createClient(ClientDtoCreateRequest clientDtoCreateRequest) {


        int availableTickets = 0;

        try(Connection connection = getConnection()) {
            Integer ticket = clientDtoCreateRequest.getTicketId();
            Integer flightId = clientDtoCreateRequest.getFlightId();
            String ticketClass = "";

            if (ticket == 1) {
                ticketClass = "available_firstclass_seats";
            } else if (ticket == 2) {
                ticketClass = "available_bussiness_seats";
            } else if (ticket == 3) {
                ticketClass = "available_economy_seats";
            }

            String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                 availableTickets = resultSet.getInt(ticketClass);

            }


            if(availableTickets == 0) {
                throw new TicketNotFoundException("This ticket not available for this flight");
            } else {
                double ticketPrice = ticketService.getTicketPrice(clientDtoCreateRequest, availableTickets);
                String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets-1) + " WHERE idflights = " + flightId);
                preparedStatement.executeUpdate(updateSql);
                connection.close();

                ClientEntity clientEntity = clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest);

                ClientEntity savedEntity = clientRepository.save(clientEntity);


                return clientEntityToClientDtoMapper.mapEntityToDto(savedEntity);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;




    }

    //create a test stream
    @Transactional(readOnly = false)
    public List<ClientDtoResponse> createClients2(List<ClientDtoCreateRequest> clientDtoCreateRequests) {
        return clientDtoCreateRequests.stream()
                                    .map(clientDtoCreateRequest -> clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest))
                                    .map(clientEntity -> clientRepository.save(clientEntity))
                                    .map(clientEntitySaved -> clientEntityToClientDtoMapper.mapEntityToDto(clientEntitySaved))
                                    .collect(toList());
    }

    //create a new list of clients / add a client to a flight
    @Transactional(readOnly = false)
    public List<ClientDtoResponse> createClients(List<ClientDtoCreateRequest> dtoCreateRequestList) {

        List<ClientDtoCreateRequest> listToReturn= new ArrayList<>();

        for (ClientDtoCreateRequest clientDtoCreateRequest : dtoCreateRequestList) {
            int availableTickets = 0;

            try(Connection connection = getConnection()) {
                Integer ticket = clientDtoCreateRequest.getTicketId();
                Integer flightId = clientDtoCreateRequest.getFlightId();
                String ticketClass = "";

                if (ticket == 1) {
                    ticketClass = "available_firstclass_seats";
                } else if (ticket == 2) {
                    ticketClass = "available_bussiness_seats";
                } else if (ticket == 3) {
                    ticketClass = "available_economy_seats";
                }

                String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    availableTickets = resultSet.getInt(ticketClass);

                }


                if(availableTickets == 0) {
                  //  throw new TicketNotFoundException("This ticket not available for this flight");
                } else {
                    double ticketPrice = ticketService.getTicketPrice(clientDtoCreateRequest, availableTickets);


                    String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets-1) + " WHERE idflights = " + flightId);
                    preparedStatement.executeUpdate(updateSql);
                    connection.close();

//                    ClientEntity clientEntity = clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest);
//
//                    ClientEntity savedEntity = clientRepository.save(clientEntity);
//
//
                    listToReturn.add(clientDtoCreateRequest);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return createClients2(listToReturn);




    }


    //get client by ID
    @Transactional(readOnly = true)
    public ClientDtoResponse getClientById(Integer id) {
        return clientEntityToClientDtoMapper.mapEntityToDto(clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("No client found with this id!")));

    }



    //get client by last name
    @Transactional(readOnly = true)
    public List<ClientDtoResponse> getClientByLastName(String lastName) {

        return clientRepository.findAllByLastName(lastName)
                .stream()
                .map(clientEntity -> clientEntityToClientDtoMapper.mapEntityToDto(clientEntity))
                .collect(toList());

    }

    //get client by first name + last name
    @Transactional(readOnly = true)
    public List<ClientDtoResponse> getClientByFirstAndLastName(String firstName, String lastName) {

        return clientRepository.findAllByFirstNameAndLastName(firstName, lastName)
                .stream()
                .map(clientEntity -> clientEntityToClientDtoMapper.mapEntityToDto(clientEntity))
                .collect(toList());

    }

    //get clients by flightID

    public List<ClientDtoResponse> getClientByFlightId(Integer flightId) {
        FlightEntity flightEntity = flightRepository.findById(flightId).orElseThrow();

        return clientRepository.findAllByFlightId(flightId)
                .stream()
                .map(clientEntity -> clientEntityToClientDtoMapper.mapEntityToDto(clientEntity))
                .collect(toList());

    }



    private Connection getConnection() throws SQLException{

        String url = "jdbc:mysql://localhost:3306/lria";
        String uname = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, uname, password);

        return connection;




    }


}
