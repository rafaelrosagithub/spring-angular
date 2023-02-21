package org.example.customers.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class SeviceProvidedDTO {

    @NotEmpty(message = "{field.description.required}")
    private String description;
    @NotEmpty(message = "{field.price.required}")
    private String price;
    @NotEmpty(message = "{field.date.required}")
    private String date;
    private Integer idClient;
}
