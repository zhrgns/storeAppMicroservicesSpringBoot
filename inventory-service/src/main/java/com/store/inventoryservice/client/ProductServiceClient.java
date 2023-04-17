package com.store.inventoryservice.client;

import com.store.inventoryservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/product/{productId}")
    ResponseEntity<ProductDto> findByProductId(@PathVariable String productId);

}
