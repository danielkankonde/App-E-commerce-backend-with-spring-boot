package com.daniel.ecommerce.service;

import com.daniel.ecommerce.dto.ProductDTO;
import com.daniel.ecommerce.mapper.ProductMapper;
import com.daniel.ecommerce.model.Product;
import com.daniel.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository produitRepository;

    public ProductService(ProductRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    // fonction pour récuperer tous les produits
    public List<ProductDTO> getAllProducts() {
        return produitRepository.findAll()
                    .stream()
                    .map(ProductMapper::toDTO)
                    .collect(Collectors.toList());
    }

    // fonction pour ajouter un produit
    public ProductDTO saveProduct(ProductDTO productDto) {
        Product product = ProductMapper.toEntity(productDto);
        Product saved = produitRepository.save(product);
        return ProductMapper.toDTO(saved);
    }

    // Fonction pour récuperer un produit spécifique
    public ProductDTO detailProduct(Long id) {
        Product product = produitRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit non trouvé "));
        
        return ProductMapper.toDTO(product);
    }

}