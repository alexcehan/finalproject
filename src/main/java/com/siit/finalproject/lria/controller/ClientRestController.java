package com.siit.finalproject.lria.controller;


import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.domain.model.ClientDtoResponse;
import com.siit.finalproject.lria.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/clients")
public class ClientRestController {
    private final ClientService clientService;

    //returns all clients
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDtoResponse> getAllClients() {
        return clientService.getAllClients();
    }

    //return client by ID
    @GetMapping(value = "/clientId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDtoResponse getClientById(@RequestParam(name = "clientId")Integer clientId) {
        return clientService.getClientById(clientId);
    }

    //return clients by last name
    @GetMapping(value = "/clientsByLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDtoResponse> getClientsByLastName(@RequestParam(name = "lastName")String lastName) {
        return clientService.getClientByLastName(lastName);
    }

    //return clients by first and last name
    @GetMapping(value = "/clientsByFirstAndLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDtoResponse> getClientsByFirstAndLastName(@RequestParam(name = "firstName")String firstName,
                                                                @RequestParam(name = "lastName")String lastName) {
        return clientService.getClientByFirstAndLastName(firstName, lastName);
    }

    //return clients by flightId
    @GetMapping(value = "/clientsByFlightId", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDtoResponse> getClientsByFlightId(@RequestParam(name = "flightId")Integer flightId) {
        return clientService.getClientByFlightId(flightId);
    }


    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDtoResponse createClient(@RequestBody @Valid ClientDtoCreateRequest clientDtoCreateRequest) {
        return clientService.createClient(clientDtoCreateRequest);
    }

    //create from previous method a method to take as argument a list of DTOCreateRequest
    @PostMapping(value = "/bulk")
    public List<ClientDtoResponse> createClients(@RequestBody @Valid List<ClientDtoCreateRequest> clientDtoCreateRequests) {
        return clientService.createClients(clientDtoCreateRequests);
    }
}
