package com.daniel.ecommerce.mapper;

import com.daniel.ecommerce.dto.ProductDTO;
import com.daniel.ecommerce.model.Product;

public class ProductMapper {

    // Transformer l'entité en DTO
    public static ProductDTO toDTO(Product produit) {
        ProductDTO dto = new ProductDTO();

        dto.setNom(produit.getNom());
        dto.setDescription(produit.getDescription());
        dto.setPrice(produit.getPrice());
        dto.setStock(produit.getStock());

        return dto;
    }

    // Transformer le DTO en Entité
    public static Product toEntity(ProductDTO productDto) {
        Product prod = new Product();

        prod.setNom(productDto.getNom());
        prod.setDescription(productDto.getDescription());
        prod.setPrice(productDto.getPrice());
        prod.setStock(productDto.getStock());

        return prod;
    }
}