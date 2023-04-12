package org.example.customers.util;

import org.example.customers.rest.dto.ClientDTO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ConvertFileXLSTest {

    private final List<ClientDTO> clientes = new ArrayList<>();

    @BeforeEach
    public void setup() {
        clientes.add(new ClientDTO(1, "Jhon da Silva", "Jhon@teste.com", "2199988-777441"));
        clientes.add(new ClientDTO(2, "Maria da Silva", "maria@teste.com.br", "2155547-3341"));
        clientes.add(new ClientDTO(3, "Paul dos Santos", "paul@teste.com.br", "55224-147523"));
    }

    @Test
    void criarArquivo() throws IOException {
        ConvertFileXLS criaArquivoExcel = new ConvertFileXLS();
        Assert.assertNotNull(criaArquivoExcel);
        criaArquivoExcel.createFile("clients.xlsx", clientes);
    }

}