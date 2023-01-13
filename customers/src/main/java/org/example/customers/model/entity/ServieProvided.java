package org.example.customers.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class ServieProvide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column
    private BigDecimal value;
}
