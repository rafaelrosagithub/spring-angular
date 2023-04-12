package org.example.customers.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientDTO {

    private Integer id;
    private String name;
    private String email;
    private String phone;
}
