package com.store.inventoryservice.controller;


import com.store.inventoryservice.dto.AddProductReq;
import com.store.inventoryservice.dto.InventoryDto;
import com.store.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<InventoryDto> getAllProductsInInventoryById(@PathVariable String id) {
        return ResponseEntity.ok(inventoryService.getAllProductsInInventoryById(id));
    }


    //create new empty inventory
    @PostMapping("/inventory/newInventory")
    public ResponseEntity<InventoryDto> createNewInventory() {
        return  ResponseEntity.ok(inventoryService.createNewInventory());
    }

    @PutMapping("/inventory/newProduct")
    public ResponseEntity<Void> addProductToInventory(@RequestBody AddProductReq request){
        inventoryService.addProductToInventory(request);
        return ResponseEntity.ok().build();
    }
}
