package com.app.ms_productos.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.app.ms_productos.entity.Product;
import com.app.ms_productos.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.*;

@WebMvcTest(ProductController.class)
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("Torre");
        product.setPrice(new BigDecimal(800));
    }

    @Test
    void testListAll() throws Exception {
        List<Product> products = Collections.singletonList(product);
        when(service.ListAll()).thenReturn(products);

        mockMvc.perform(get("/app/productos/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Torre"));
    }

    @Test
    void testByIdFound() throws Exception {
        when(service.findById(1L)).thenReturn(Optional.of(product));

        mockMvc.perform(get("/app/productos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Torre"));
    }

    @Test
    void testByIdNotFound() throws Exception {
        when(service.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/app/productos/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testSave() throws Exception {
        when(service.save(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/app/productos/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Product\", \"price\":100.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Torre"));
    }
}