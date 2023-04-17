package com.store.inventoryservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String inventoryId;

    @ElementCollection
    private List<String> customerProductList = new ArrayList<>();

    public Inventory(String inventoryId) {
        this.inventoryId = inventoryId;
    }

}
