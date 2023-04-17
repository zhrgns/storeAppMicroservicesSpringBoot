package com.store.inventoryservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String productId;
    private String brand;
    private String category;
    private String productName;
    private String description;
    private Double price;
}
