package com.store.productservice.controller;


import com.store.productservice.dto.ProductDto;
import com.store.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> findByProductId(@PathVariable @NotEmpty String productId) {
        return ResponseEntity.ok(productService.findByProductId(productId));
    }

}
