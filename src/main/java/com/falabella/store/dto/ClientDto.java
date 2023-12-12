package com.falabella.store.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ClientDto {

    @Size(min = 3,message = "Debe tener como mínimo 3 caracteres")
    private String name;
    @Email(message = "Debe ingresar formato de correo")
    private String email;
    @Size(min = 9,max = 9,message = "Debe tener 9 dígitos el número")
    private String phoneNumber;

    public ClientDto() {
    }

    public ClientDto( String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
