package com.siit.finalproject.lria.service;
import com.siit.finalproject.lria.domain.entity.ClientEntity;
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


//        int availableTickets = 0;
//
//        try(Connection connection = getConnection()) {
//            Integer ticket = clientDtoCreateRequest.getTicketId();
//            Integer flightId = clientDtoCreateRequest.getFlightId();
//            String ticketClass = "";
//
//            if (ticket == 1) {
//                ticketClass = "available_firstclass_seats";
//            } else if (ticket == 2) {
//                ticketClass = "available_bussiness_seats";
//            } else if (ticket == 3) {
//                ticketClass = "available_economy_seats";
//            }
//
//            String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()) {
//                 availableTickets = resultSet.getInt(ticketClass);
//
//            }
//
//
//            if(availableTickets == 0) {
//                throw new TicketNotFoundException("This ticket not available for this flight");
//            } else {
//                ClientDtoCreateRequest clientDtoCreateRequestPriceUpdated = ticketService.getTicketPrice(clientDtoCreateRequest, availableTickets);
//
//                String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets-1) + " WHERE idflights = " + flightId);
//                preparedStatement.executeUpdate(updateSql);
//                connection.close();
//
//                ClientEntity clientEntity = clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequestPriceUpdated);
//
//                ClientEntity savedEntity = clientRepository.save(clientEntity);
//
//
//                return clientEntityToClientDtoMapper.mapEntityToDto(savedEntity);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;



                updateDbAvailableTicketsDecrease(clientDtoCreateRequest);
                ClientEntity clientEntity = clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest);


                ClientEntity savedEntity = clientRepository.save(clientEntity);


                return clientEntityToClientDtoMapper.mapEntityToDto(savedEntity);



    }


    //create a new list of clients / add a client to a flight
//    @Transactional
//    public List<ClientDtoResponse> createClients(List<ClientDtoCreateRequest> dtoCreateRequestList) {
//
//        List<ClientDtoCreateRequest> listToReturn= new ArrayList<>();
//
//        for (ClientDtoCreateRequest clientDtoCreateRequest : dtoCreateRequestList) {
//            int availableTickets = 0;
//
//            try(Connection connection = getConnection()) {
//                Integer ticket = clientDtoCreateRequest.getTicketId();
//                Integer flightId = clientDtoCreateRequest.getFlightId();
//                String ticketClass = "";
//
//                if (ticket == 1) {
//                    ticketClass = "available_firstclass_seats";
//                } else if (ticket == 2) {
//                    ticketClass = "available_bussiness_seats";
//                } else if (ticket == 3) {
//                    ticketClass = "available_economy_seats";
//                }
//
//                String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
//                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while(resultSet.next()) {
//                    availableTickets = resultSet.getInt(ticketClass);
//
//                }
//
//
//                if(availableTickets != 0) {
//
//                    String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets-1) + " WHERE idflights = " + flightId);
//                    preparedStatement.executeUpdate(updateSql);
//                    connection.close();
//
//
//                    listToReturn.add(clientDtoCreateRequest);
//
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return createClients2(listToReturn);
//
//    }


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

//        return clientsToCreateList.stream().parallel()
//                .map(this::updateDbAvailableTicketsDecrease)
//                .map(clientDtoPostRequestToClientEntityMapper::mapDtoPostRequestToEntity)
//                .map(clientRepository::save)
//                .map(clientEntityToClientDtoMapper::mapEntityToDto)
//                .collect(toList());
      //  return list;
    }

    @Transactional
    public void deleteClientById(Integer id) {
        updateDbAvailableTicketsIncrease(id);
        clientRepository.deleteById(id);
    }

    @Transactional
    public ClientDtoResponse updateClient(ClientDtoUpdateRequest clientDtoUpdateRequest) {
        ClientEntity clientEntity = clientRepository.findById(clientDtoUpdateRequest.getId()).orElseThrow(() -> new ClientNotFoundException("Client not found by this id: " + clientDtoUpdateRequest.getId()));



        clientEntity.setFlight(flightRepository.findById(clientDtoUpdateRequest.getFlightId()).orElseThrow(() -> new FlightNotFoundException("No flight found for the given id: "+ clientDtoUpdateRequest.getFlightId())));
        clientEntity.setTicket(ticketRepository.findById(clientDtoUpdateRequest.getTicketId()).orElseThrow(()-> new TicketNotFoundException("No ticket found for the given Id " + clientDtoUpdateRequest.getTicketId())));
        updateDbAvailableTicketsIncrease(clientDtoUpdateRequest.getId());

        ClientDtoCreateRequest clientDtoCreateRequest = clientDtoToClientDtoCreateRequest.mapDtoToDtoCreateRequest(clientEntityToClientDtoMapper.mapEntityToDto(clientEntity));
        return clientEntityToClientDtoMapper.mapEntityToDto(clientDtoPostRequestToClientEntityMapper.mapDtoPostRequestToEntity(clientDtoCreateRequest));
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
           // Integer flightId = clientDtoCreateRequest.getFlightId();
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

//    @Transactional
//    public void deleteClientById(Integer id) throws SQLException{
//       if(clientRepository.existsById(id)) {
//           Connection connection = getConnection();
//           ClientDtoResponse clientDtoResponse = getClientById(id);
//           int flightId = clientDtoResponse.getFlight().getId();
//           int ticketId = clientDtoResponse.getTicket().getId();
//           String ticketClass = "";
//           int availableTickets = 0;
//
//           if (ticketId == 1) {
//               ticketClass = "available_firstclass_seats";
//           } else if (ticketId == 2) {
//               ticketClass = "available_bussiness_seats";
//           } else if (ticketId == 3) {
//               ticketClass = "available_economy_seats";
//           }
//
//           String sqlQuery = ("SELECT " + ticketClass + " FROM flights WHERE idflights = " + flightId);
//           PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//           ResultSet resultSet = preparedStatement.executeQuery();
//           while(resultSet.next()) {
//               availableTickets = resultSet.getInt(ticketClass);
//
//           }
//
//           if ( availableTickets != 0) {
//
//               String updateSql = ("UPDATE flights SET " + ticketClass + "=" + (availableTickets+1) + " WHERE idflights = " + flightId);
//               preparedStatement.executeUpdate(updateSql);
//               connection.close();
//
//           }
//           clientRepository.deleteById(id);
//       }
//
//    }



            @SneakyThrows
    private Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/lria";
        String uname = "alex";
        String password = "password";


        return DriverManager.getConnection(url, uname, password);




    }


}
