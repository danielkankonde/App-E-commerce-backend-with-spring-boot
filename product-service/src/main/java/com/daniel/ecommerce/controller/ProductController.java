package com.daniel.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.ecommerce.dto.ProductDTO;
import com.daniel.ecommerce.service.ProductService;

@RestController()
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Request GET
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    // Request GET By Id
    @GetMapping("{id}/")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.detailProduct(id), HttpStatus.OK); 
    }
    // Request POST
    @PostMapping()
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDto){
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED); 
    }
}
