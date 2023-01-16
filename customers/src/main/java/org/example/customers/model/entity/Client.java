package org.example.customers.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(name = "date_register")
    private LocalDate dateRegister;

    @PrePersist
    public void prePersist() {
        setDateRegister(LocalDate.now());
    }
}

