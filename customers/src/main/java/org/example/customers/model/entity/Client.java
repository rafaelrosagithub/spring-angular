package org.example.customers.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column
    private LocalDate dateRegister;
}
