package com.app.ms_invetario.controller;

import com.app.ms_invetario.entity.Inventory;
import com.app.ms_invetario.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/app/inventario")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/available/{productId}")
    public ResponseEntity<Optional<Inventory>> getAvailableQuantity(@PathVariable Long productId) {
        Optional<Inventory> inventoryOptional = service.findById(productId);
        if (inventoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(inventoryOptional);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/updateQuantity/{productId}")
    public ResponseEntity<Inventory> updateQuantity(@PathVariable Long productId, @RequestBody Inventory inventory) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateQuantity(productId, inventory.getAmount()));
    }
}
