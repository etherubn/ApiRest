package com.falabella.store.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

    private Long idProduct;
    @Size(min = 3,message = "El producto debe tener mínimo 4 caracteres")
    private String name;

    @Positive(message = "Debe ser mayor a 0")
    @Digits(integer = 4,fraction = 2,message = "Debe tener 2 decimales")
    private Double price;

    public ProductDto() {
    }

    public ProductDto(Long idProduct, String name, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
