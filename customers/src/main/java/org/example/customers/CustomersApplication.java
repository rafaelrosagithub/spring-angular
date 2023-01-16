package org.example.customers;

import org.example.customers.model.entity.Client;
import org.example.customers.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomersApplication {

//    @Bean
//    public CommandLineRunner run(@Autowired ClientRepository repository) {
//        return args -> {
//            Client client = Client.builder().cpf("00000000000").name("João").build();
//            repository.save(client);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }
}
