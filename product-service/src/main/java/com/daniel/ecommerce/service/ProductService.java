package com.daniel.ecommerce.service;

import com.daniel.ecommerce.model.Product;
import com.daniel.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository produitRepository;

    public ProductService(ProductRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    // fonction pour récuperer tous les produits
    public List<Product> getAllProducts() {
        return produitRepository.findAll();
    }

    // fonction pour ajouter un produit
    public Product saveProduct(Product product) {
        return produitRepository.save(product);
    }

    // Fonction pour récuperer un produit spécifique
    public Product detailProduct(Long id) {
        return produitRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit non trouvé "));
    }

}