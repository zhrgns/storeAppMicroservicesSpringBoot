package com.store.productservice.dto;


import com.store.productservice.model.Product;
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

    public static ProductDto convertEntity(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .brand(product.getBrand())
                .category(product.getCategory())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
