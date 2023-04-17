package com.store.productservice.repository;

import com.store.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    Optional<Product> findProductByProductId(String productId);
}
