package com.app.ms_invetario.service;

import com.app.ms_invetario.entity.Inventory;
import com.app.ms_invetario.http.response.ProductByIdProductResponse;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<Inventory> findAll();
    Optional<Inventory> findById(Long id);
    Inventory save(Inventory inventory);
    ProductByIdProductResponse findProduct();
    Long getAvailableQuantity(Long productId);
    Inventory updateQuantity(Long productId, Long amount);
}
