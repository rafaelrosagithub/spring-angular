package org.example.customers.rest;

import org.example.customers.model.entity.Client;
import org.example.customers.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return repository.save(client);
    }
}
