package com.siit.finalproject.lria.service;
import com.siit.finalproject.lria.domain.entity.ClientEntity;
import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import com.siit.finalproject.lria.domain.entity.FlightEntity;
import com.siit.finalproject.lria.domain.model.ClientDto;
import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.domain.model.ClientDtoResponse;
import com.siit.finalproject.lria.domain.model.ClientDtoUpdateRequest;
import com.siit.finalproject.lria.exception.ClientNotFoundException;
import com.siit.finalproject.lria.exception.FlightNotFoundException;
import com.siit.finalproject.lria.exception.TicketNotFoundException;
import com.siit.finalproject.lria.mapper.client.ClientDtoPostRequestToClientEntityMapper;
import com.siit.finalproject.lria.mapper.client.ClientDtoToClientDtoCreateRequest;
import com.siit.finalproject.lria.mapper.client.ClientEntityToClientDtoMapper;
import com.siit.finalproject.lria.repository.ClientRepository;

import com.siit.finalproject.lria.repository.DestinationRepository;
import com.siit.finalproject.lria.repository.FlightRepository;
import com.siit.finalproject.lria.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


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
    private final TicketService ticketService;
    private final ClientDtoToClientDtoCreateRequest clientDtoToClientDtoCreateRequest;
    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;
    //private final ClientDtoCreateRequest clientDtoCreateRequest;

    // get a all clients
    @Transactional(readOnly = true)
    public List<ClientDtoResponse> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientEntityToClientDtoMapper::mapEntityToDto)
                .collect(toList());
    }






    //create a new client / add a client to a flight
    @Transactional
    public ClientDtoResponse createClient(ClientDtoCreateRequest clientDtoCreateRequest) {






                updateDbAvailableTicketsDecrease(clientDtoCreateRequest);
                if (clientDtoCreateRequest.getSeat().equals("ZZ")) {
                    throw new TicketNotFoundException("No ticket available for this flight");
                }
                ClientEntity clientEntity = clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest);


                ClientEntity savedEntity = clientRepository.save(clientEntity);


                return clientEntityToClientDtoMapper.mapEntityToDto(savedEntity);



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
                .map(clientEntityToClientDtoMapper::mapEntityToDto)
                .collect(toList());

    }

    //get client by first name + last name
    @Transactional(readOnly = true)
    public List<ClientDtoResponse> getClientByFirstAndLastName(String firstName, String lastName) {

        return clientRepository.findAllByFirstNameAndLastName(firstName, lastName)
                .stream()
                .map(clientEntityToClientDtoMapper::mapEntityToDto)
                .collect(toList());

    }

    //get clients by flightID

    public List<ClientDtoResponse> getClientByFlightId(Integer flightId) {

        return clientRepository.findAllByFlightId(flightId)
                .stream()
                .map(clientEntityToClientDtoMapper::mapEntityToDto)
                .collect(toList());

    }

    //create a test stream
    @Transactional
    public List<ClientDtoResponse> createClients(List<ClientDtoCreateRequest> clientDtoCreateRequests) {
        return clientDtoCreateRequests.stream().parallel()
                .map(this::updateDbAvailableTicketsDecrease)
                .filter(clientDtoCreateRequest -> !clientDtoCreateRequest.getSeat().equals("ZZ"))
                .map(clientDtoPostRequestToClientEntityMapper::mapDtoPostRequestToEntity)
                .map(clientRepository::save)
                .map(clientEntityToClientDtoMapper::mapEntityToDto)
                .collect(toList());
    }


    //create clients from a CSV file
    @SneakyThrows
    @Transactional
    public List<ClientDtoResponse> createClientsFromFile(MultipartFile file) {
        List<ClientDtoCreateRequest> clientsToCreateList = new ArrayList<>();
        if(file.isEmpty()) {
            return createClients(clientsToCreateList);
        }

        byte[] bytes = file.getBytes();
        String fileContent = new String(bytes); //should i use new string(bytes)????!!!!
        fileContent = fileContent.replaceAll("\r", "");
        String[] rows = fileContent.split("\n");

        for(String row : rows) {
            String[] rowSplitted = row.split(",");

            if(rowSplitted.length != 0) {
                ClientDtoCreateRequest clientDtoCreateRequest = ClientDtoCreateRequest.builder()
                        .firstName(rowSplitted[0])
                        .lastName(rowSplitted[1])
                        .age(Integer.valueOf(rowSplitted[2]))
                        .flightId(Integer.valueOf(rowSplitted[3]))
                        .ticketId(Integer.valueOf(rowSplitted[4]))
                        .build();

                clientsToCreateList.add(clientDtoCreateRequest);
            }
        }

        return createClients(clientsToCreateList);


    }

    @Transactional
    public void deleteClientById(Integer id) {
        updateDbAvailableTicketsIncrease(id);
        clientRepository.deleteById(id);
    }

    public void checkIfUpdatePossible(ClientDtoUpdateRequest clientDtoUpdateRequest) {

        ClientEntity clientEntity = clientRepository.findById(clientDtoUpdateRequest.getId()).orElseThrow(() -> new ClientNotFoundException("Client not found by this id: " + clientDtoUpdateRequest.getId()));
        FlightEntity flightEntity = flightRepository.findById(clientDtoUpdateRequest.getFlightId()).orElseThrow(()-> new FlightNotFoundException("No flight found with this id: + " + clientDtoUpdateRequest.getFlightId()));


        if ((clientEntity.getFlight().getId().equals(clientDtoUpdateRequest.getFlightId()))&& (clientEntity.getTicket().getId().equals(clientDtoUpdateRequest.getTicketId()))) {
            throw new TicketNotFoundException("There is already one thicket bought for this client");
        }

        if (!clientEntity.getFlight().getDestination().getCity().equals(flightEntity.getDestination().getCity())) {
            throw new TicketNotFoundException("You can't update ticket to a different destination");
        }
    }

    @Transactional
    public ClientDtoResponse updateClient(ClientDtoUpdateRequest clientDtoUpdateRequest) {
        ClientEntity clientEntity = clientRepository.findById(clientDtoUpdateRequest.getId()).orElseThrow(() -> new ClientNotFoundException("Client not found by this id: " + clientDtoUpdateRequest.getId()));


        checkIfUpdatePossible(clientDtoUpdateRequest);



       // updateDbAvailableTicketsDecrease(clientDtoToClientDtoCreateRequest.mapDtoToDtoCreateRequest(clientEntityToClientDtoMapper.mapEntityToDto(clientEntity)));

        ClientDtoCreateRequest clientDtoCreateRequest = clientDtoToClientDtoCreateRequest.mapDtoToDtoCreateRequest(clientEntityToClientDtoMapper.mapEntityToDto(clientEntity));
        clientDtoCreateRequest.setFlightId(clientDtoUpdateRequest.getFlightId());
        clientDtoCreateRequest.setTicketId(clientDtoUpdateRequest.getTicketId());
        updateDbAvailableTicketsDecrease(clientDtoCreateRequest);

        if (clientDtoCreateRequest.getSeat().equals("ZZ")) {
            throw new TicketNotFoundException("No ticket available for this flight at this class");
        }
        updateDbAvailableTicketsIncrease(clientDtoUpdateRequest.getId());


        clientEntity.setFlight(flightRepository.findById(clientDtoUpdateRequest.getFlightId()).orElseThrow(() -> new FlightNotFoundException("No flight found for the given id: "+ clientDtoUpdateRequest.getFlightId())));
        clientEntity.setTicket(ticketRepository.findById(clientDtoUpdateRequest.getTicketId()).orElseThrow(()-> new TicketNotFoundException("No ticket found for the given Id " + clientDtoUpdateRequest.getTicketId())));
        clientEntity.setTicketPrice(clientDtoCreateRequest.getTicketPrice());
        clientEntity.setSeat(clientDtoCreateRequest.getSeat());

        ClientDtoCreateRequest clientDtoCreateRequest1 = clientDtoToClientDtoCreateRequest.mapDtoToDtoCreateRequest(clientEntityToClientDtoMapper.mapEntityToDto(clientEntity));
        return clientEntityToClientDtoMapper.mapEntityToDto(clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest1));
    }



    //this method is meant to update the available tickets columns in DB once a client is created or deleted
    public ClientDtoCreateRequest updateDbAvailableTicketsDecrease(ClientDtoCreateRequest clientDtoCreateRequest) {
        int availableTickets = 0;

        try(Connection connection = getConnection()) {

            Integer flightId = clientDtoCreateRequest.getFlightId();
            String ticketClass = getTicketClass(clientDtoCreateRequest);


            String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                availableTickets = resultSet.getInt(ticketClass);

            }


            if (availableTickets != 0) {

                ClientDtoCreateRequest clientDtoCreateRequestPriceUpdated = ticketService.getTicketPrice(clientDtoCreateRequest, availableTickets);

                String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets - 1) + " WHERE idflights = " + flightId);
                preparedStatement.executeUpdate(updateSql);
                connection.close();

                return clientDtoCreateRequestPriceUpdated;
            } else {
                ClientDtoCreateRequest clientDtoCreateRequest1 = clientDtoCreateRequest;
                clientDtoCreateRequest1.setSeat("ZZ");
                return clientDtoCreateRequest1;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        throw new TicketNotFoundException("No available ticket!");
    }


    //this method is meant to update the available tickets columns in DB once a client is created or updated
    public void updateDbAvailableTicketsIncrease(Integer clientId) {
        int availableTickets = 0;
        ClientDtoResponse clientDtoResponse = getClientById(clientId);
        int flightId = clientDtoResponse.getFlight().getId();

        try(Connection connection = getConnection()) {

            String ticketClass = getTicketClass(clientDtoToClientDtoCreateRequest.mapDtoToDtoCreateRequest(clientDtoResponse));


            String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                availableTickets = resultSet.getInt(ticketClass);

            }

            String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets + 1) + " WHERE idflights = " + flightId);
            preparedStatement.executeUpdate(updateSql);




        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public String getTicketClass(ClientDtoCreateRequest clientDtoCreateRequest) {
        Integer ticket = clientDtoCreateRequest.getTicketId();
        String ticketClass = "";

        if (ticket == 1) {
            ticketClass = "available_firstclass_seats";
        } else if (ticket == 2) {
            ticketClass = "available_bussiness_seats";
        } else if (ticket == 3) {
            ticketClass = "available_economy_seats";
        }

        return ticketClass;
    }





            @SneakyThrows
    private Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/lria";
        String uname = "root";
        String password = "root";


        return DriverManager.getConnection(url, uname, password);




    }


}
