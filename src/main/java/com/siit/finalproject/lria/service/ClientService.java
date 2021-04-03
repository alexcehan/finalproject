package com.siit.finalproject.lria.service;

import com.siit.finalproject.lria.domain.entity.ClientEntity;
import com.siit.finalproject.lria.domain.model.ClientDto;
import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.domain.model.ClientDtoResponse;
import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.exception.ClientNotFoundException;
import com.siit.finalproject.lria.exception.FlightNotFoundException;
import com.siit.finalproject.lria.mapper.client.ClientDtoPostRequestToClientEntityMapper;
import com.siit.finalproject.lria.mapper.client.ClientEntityToClientDtoMapper;
import com.siit.finalproject.lria.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoPostRequestToClientEntityMapper clientDtoPostRequestToClientEntityMapper;
    private final ClientEntityToClientDtoMapper clientEntityToClientDtoMapper;


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


}
