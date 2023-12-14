package com.falabella.store.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
}
