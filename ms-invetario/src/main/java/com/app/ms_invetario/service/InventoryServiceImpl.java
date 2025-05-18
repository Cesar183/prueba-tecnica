package com.app.ms_invetario.service;

import com.app.ms_invetario.client.ProductClient;
import com.app.ms_invetario.dto.ProductDto;
import com.app.ms_invetario.entity.Inventory;
import com.app.ms_invetario.http.response.ProductByIdProductResponse;
import com.app.ms_invetario.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository repository;

    @Autowired
    private ProductClient productClient;

    @Override
    public List<Inventory> findAll() {
        return (List<Inventory>) repository.findAll();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public ProductByIdProductResponse findProduct() {
        List<ProductDto> productDtoList = productClient.allProduct();
        return ProductByIdProductResponse.builder()
                .productDtoList(productDtoList)
                .build();
    }

    @Override
    public Long getAvailableQuantity(Long productId) {
        Optional<Inventory> inventory = repository.findById(productId);
        if (inventory.isPresent()) {
            System.out.println("Producto consultado: " + productId);
            return inventory.get().getAmount();
        }
        throw new RuntimeException("Producto no encontrado en inventario.");
    }

    @Override
    public Inventory updateQuantity(Long productId, Long amount) {
        Optional<Inventory> inventoryOptional = repository.findById(productId);
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            inventory.setAmount(amount);
            Inventory updatedInventory = repository.save(inventory);
            System.out.println("Inventario actualizado para producto " + productId + ", nueva cantidad: " + amount);
            return updatedInventory;
        }
        throw new RuntimeException("Producto no encontrado en inventario.");
    }
}
