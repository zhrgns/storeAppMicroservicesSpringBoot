package com.store.inventoryservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInfoDto {
    private String productId;

    public static ProductInfoDto convertEntity(String productId) {
        return ProductInfoDto.builder()
                .productId(productId)
                .build();
    }
}
