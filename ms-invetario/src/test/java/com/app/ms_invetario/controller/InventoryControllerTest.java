package com.app.ms_invetario.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.app.ms_invetario.entity.Inventory;
import com.app.ms_invetario.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

@WebMvcTest(InventoryController.class)
@ExtendWith(MockitoExtension.class)
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService service;

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        inventory.setProductId(1L);
        inventory.setAmount(100L);
    }

    @Test
    void testGetAvailableQuantityFound() throws Exception {
        when(service.findById(1L)).thenReturn(Optional.of(inventory));

        mockMvc.perform(get("/app/inventario/available/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(1L))
                .andExpect(jsonPath("$.amount").value(100L));
    }

    @Test
    void testGetAvailableQuantityNotFound() throws Exception {
        when(service.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/app/inventario/available/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateQuantity() throws Exception {
        when(service.updateQuantity(1L, 150L)).thenReturn(inventory);

        mockMvc.perform(put("/app/inventario/updateQuantity/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\":150}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(100L));
    }
}