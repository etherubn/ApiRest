package com.falabella.store.dto;

import jakarta.validation.constraints.Digits;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class IdClientDto {
    @NotNull(message = "No debe ser nulo")
    @Positive(message = "El id debe ser positivo")
    @Digits(integer = 100000,message = "Debe ser valor numérico", fraction = 0)
    private Long idClientDto;


    public IdClientDto() {
    }

    public IdClientDto(Long idClientDto) {
        this.idClientDto = idClientDto;
    }

    public Long getIdClientDto() {
        return idClientDto;
    }

    public void setIdClientDto(Long idClientDto) {
        this.idClientDto = idClientDto;
    }
}
