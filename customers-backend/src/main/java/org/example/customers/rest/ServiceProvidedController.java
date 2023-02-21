package org.example.customers.rest;

import lombok.RequiredArgsConstructor;
import org.example.customers.model.entity.Client;
import org.example.customers.model.entity.ServiceProvided;
import org.example.customers.model.repository.ClientRepository;
import org.example.customers.model.repository.ServiceProvidedRepository;
import org.example.customers.rest.dto.SeviceProvidedDTO;
import org.example.customers.util.BigDecimalConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/services-provided")
@RequiredArgsConstructor
public class ServiceProvidedController {

    private final ClientRepository clientRepository;
    private final ServiceProvidedRepository serviceProvidedRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceProvided save(@RequestBody SeviceProvidedDTO seviceProvidedDTO) {
        LocalDate date = LocalDate.parse(seviceProvidedDTO.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idClient = seviceProvidedDTO.getIdClient();

        Client client =
                clientRepository
                        .findById(idClient)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No-existent customer."));

        ServiceProvided serviceProvided = new ServiceProvided();
        serviceProvided.setDescription(seviceProvidedDTO.getDescription());
        serviceProvided.setDate(date);
        serviceProvided.setClient(client);
        serviceProvided.setValue(bigDecimalConverter.converter(seviceProvidedDTO.getPrice()));
        return serviceProvidedRepository.save(serviceProvided);
    }

    @GetMapping
    public List<ServiceProvided> search(@RequestParam(value = "name", required = false, defaultValue = "") String name, @RequestParam(value = "month", required = false) Integer month) {
        return serviceProvidedRepository.findByNameClientAndMes("%" + name + "%", month);
    }

}
