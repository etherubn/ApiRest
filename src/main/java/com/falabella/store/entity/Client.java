package com.falabella.store.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Orden> order;

    public Client() {
    }

    public Client(Long idClient, String name, String email, String phoneNumber) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
