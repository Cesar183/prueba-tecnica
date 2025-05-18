package com.app.ms_invetario.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.app.ms_invetario.client.ProductClient;
import com.app.ms_invetario.dto.ProductDto;
import com.app.ms_invetario.entity.Inventory;
import com.app.ms_invetario.http.response.ProductByIdProductResponse;
import com.app.ms_invetario.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {

    @Mock
    private InventoryRepository repository;

    @Mock
    private ProductClient productClient;

    @InjectMocks
    private InventoryServiceImpl service;

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        inventory.setProductId(1L);
        inventory.setAmount(100L);
    }

    @Test
    void testFindAll() {
        List<Inventory> inventories = Collections.singletonList(inventory);
        when(repository.findAll()).thenReturn(inventories);

        List<Inventory> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(inventory, result.get(0));
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(inventory));

        Optional<Inventory> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(inventory, result.get());
    }

    @Test
    void testSave() {
        when(repository.save(inventory)).thenReturn(inventory);

        Inventory result = service.save(inventory);

        assertNotNull(result);
        assertEquals(inventory, result);
    }

    @Test
    void testFindProduct() {
        List<ProductDto> products = Collections.singletonList(new ProductDto("Product_test", new BigDecimal(100)));
        when(productClient.allProduct()).thenReturn(products);

        ProductByIdProductResponse response = service.findProduct();

        assertNotNull(response);
        assertEquals(1, response.getProductDtoList().size());
    }

    @Test
    void testGetAvailableQuantity() {
        when(repository.findById(1L)).thenReturn(Optional.of(inventory));

        Long result = service.getAvailableQuantity(1L);

        assertEquals(100L, result);
    }

    @Test
    void testUpdateQuantity() {
        when(repository.findById(1L)).thenReturn(Optional.of(inventory));
        when(repository.save(any(Inventory.class))).thenReturn(inventory);

        Inventory result = service.updateQuantity(1L, 150L);

        assertEquals(150L, result.getAmount());
    }
}