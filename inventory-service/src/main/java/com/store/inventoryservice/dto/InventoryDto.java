package com.store.inventoryservice.dto;


import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class InventoryDto {
    private String inventoryId;
    private List<ProductDto> productList = new ArrayList<>();
}
