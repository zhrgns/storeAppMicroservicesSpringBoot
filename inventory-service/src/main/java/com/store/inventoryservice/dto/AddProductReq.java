package com.store.inventoryservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddProductReq {
    private String inventoryId;
    private String productId;
}
