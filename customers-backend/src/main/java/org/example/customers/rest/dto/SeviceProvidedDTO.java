package org.example.customers.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeviceProvidedDTO {

    private String description;
    private String price;
    private String date;
    private Integer idClient;
}
