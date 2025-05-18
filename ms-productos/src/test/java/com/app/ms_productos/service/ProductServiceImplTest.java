package com.app.ms_productos.service;

import com.app.ms_productos.entity.Product;
import com.app.ms_productos.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class ProductServiceImplTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl service;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("Torre");
        product.setPrice(new BigDecimal(800));
    }

    @Test
    void testListAll() {
        List<Product> products = Collections.singletonList(product);
        when(repository.findAll()).thenReturn(products);

        List<Product> result = service.ListAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(product, result.get(0));
    }

    @Test
    void testFindProduct() {
        List<Product> products = Collections.singletonList(product);
        when(repository.findAllProduct()).thenReturn(products);

        List<Product> result = service.findProduct();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(product, result.get(0));
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(product, result.get());
    }

    @Test
    void testSave() {
        when(repository.save(product)).thenReturn(product);

        Product result = service.save(product);

        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    void testDelete() {
        doNothing().when(repository).deleteById(1L);

        assertDoesNotThrow(() -> service.delete(1L));

        verify(repository, times(1)).deleteById(1L);
    }
}