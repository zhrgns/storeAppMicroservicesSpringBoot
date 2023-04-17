package com.store.productservice.service;

import com.store.productservice.dto.ProductDto;
import com.store.productservice.dto.ProductInfoDto;
import com.store.productservice.exception.ProductNotFoundException;
import com.store.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDto::convertEntity)
                .collect(Collectors.toList());
    }

    //find product by id from repository and returns the object as a productNameDto object
    public ProductDto findByProductId(String productId) {
        return productRepository.findProductByProductId(productId)
                .map(ProductDto::convertEntity)
                .orElseThrow(() -> new ProductNotFoundException("No such product!"));
    }



}
