package com.daniel.ecommerce.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;

    private String nom;

    private String description;

    private double price;

    private int stock;

}
