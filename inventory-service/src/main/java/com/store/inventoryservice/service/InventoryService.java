package com.store.inventoryservice.service;

import com.store.inventoryservice.client.ProductServiceClient;
import com.store.inventoryservice.dto.AddProductReq;
import com.store.inventoryservice.dto.InventoryDto;
import com.store.inventoryservice.dto.ProductDto;
import com.store.inventoryservice.dto.ProductInfoDto;
import com.store.inventoryservice.exception.InventoryNotFoundException;
import com.store.inventoryservice.model.Inventory;
import com.store.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductServiceClient productServiceClient;

    public InventoryService(InventoryRepository inventoryRepository, ProductServiceClient productServiceClient) {
        this.inventoryRepository = inventoryRepository;
        this.productServiceClient = productServiceClient;
    }

    public InventoryDto getAllProductsInInventoryById(String id){

        Inventory inventory = inventoryRepository.findByInventoryId(id)
                .orElseThrow(() -> new InventoryNotFoundException("No such inventory !"));

        return InventoryDto.builder()
                .inventoryId(UUID.randomUUID().toString())
                .productList(inventory.getCustomerProductList()
                        .stream()
                        .map(product -> productServiceClient.findByProductId(product).getBody())
                        .collect(Collectors.toList())).build();
    }


    public InventoryDto createNewInventory() {
        Inventory inventory = inventoryRepository.save(new Inventory(UUID.randomUUID().toString()));
        return InventoryDto.builder()
                .inventoryId(inventory.getInventoryId())
                .build();
    }

    public void addProductToInventory(AddProductReq request) {
        String productId = productServiceClient.findByProductId(request.getProductId()).getBody().getProductId();

        Inventory inventory = inventoryRepository.findByInventoryId(request.getInventoryId())
                .orElseThrow(() -> new InventoryNotFoundException("No such Inventory !"));

        inventory.getCustomerProductList().add(productId);

        inventoryRepository.save(inventory);
    }
}

