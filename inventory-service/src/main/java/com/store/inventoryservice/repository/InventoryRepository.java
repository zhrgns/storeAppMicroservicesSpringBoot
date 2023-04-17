package com.store.inventoryservice.repository;

import com.store.inventoryservice.model.Inventory;
import com.store.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,String> {

    Optional<Inventory> findByInventoryId(String inventoryId);
}
