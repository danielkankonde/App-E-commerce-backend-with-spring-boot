package com.daniel.ecommerce.repository;

import com.daniel.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}