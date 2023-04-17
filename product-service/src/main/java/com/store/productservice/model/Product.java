package com.store.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String productId;

    private String brand;
    private String category;
    private String productName;
    private String description;

    private Double price;
    private int stockNumber;

    public Product(String productId, String brand, String category, String productName, String description, Double price) {
        this.productId = productId;
        this.brand = brand;
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Product(String productId, String brand, String category, String productName, String description, Double price, int stockNumber) {
        this.productId = productId;
        this.brand = brand;
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockNumber = stockNumber;
    }
}
