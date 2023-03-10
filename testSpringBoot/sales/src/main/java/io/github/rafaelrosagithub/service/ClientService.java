package io.github.rafaelrosagithub.service;

import io.github.rafaelrosagithub.model.Client;
import io.github.rafaelrosagithub.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void saveClient(Client client) {
        validateClient(client);
        this.repository.save(client);
    }

    public void validateClient(Client client) {

    }
}
