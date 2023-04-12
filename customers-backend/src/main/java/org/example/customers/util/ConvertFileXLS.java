package org.example.customers.util;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.customers.rest.dto.ClientDTO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
public class ConvertFileXLS {

    public void createFile(final String nameFile, final List<ClientDTO> clients) {
        System.out.println("Generating File: " + nameFile);

        try (var workbook = new XSSFWorkbook();
             var outputStream = new FileOutputStream(nameFile)) {
            var planilha = workbook.createSheet("Customer list");
            int numeroDaLinha = 0;

            addHeader(planilha, numeroDaLinha++);

            for (ClientDTO cliente : clients) {
                var linha = planilha.createRow(numeroDaLinha++);
                addCellWithIntParameter(linha, 0, cliente.getId());
                addCellWithStringParameter(linha, 1, cliente.getName());
                addCellWithStringParameter(linha, 2, cliente.getEmail());
                addCellWithStringParameter(linha, 3, cliente.getPhone());
            }

            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            log.error("File not found: {}", nameFile);
        } catch (IOException e) {
            log.error("Error processing file: {} ", nameFile);
        }
        log.info("File generated successfully!");
    }

    private void addHeader(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        addCellWithStringParameter(linha, 0, "Id");
        addCellWithStringParameter(linha, 1, "Name");
        addCellWithStringParameter(linha, 2, "Email");
        addCellWithStringParameter(linha, 3, "Telephone");
    }


    private void addCellWithStringParameter(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void addCellWithIntParameter(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }
}
