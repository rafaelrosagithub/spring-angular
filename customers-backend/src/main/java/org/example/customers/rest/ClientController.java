package org.example.customers.rest;

import org.example.customers.model.entity.Client;
import org.example.customers.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid Client client) {
        System.out.println("teste");
        return repository.save(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @GetMapping
    public List<Client> findAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        repository.findById(id).map(client -> {
            repository.delete(client);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Client updatedClient) {
        repository.findById(id).map(client -> {
            client.setName(updatedClient.getName());
            client.setCpf(updatedClient.getCpf());
            return repository.save(client);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

}
