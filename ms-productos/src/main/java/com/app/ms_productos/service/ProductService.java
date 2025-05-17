package com.app.ms_productos.service;

import com.app.ms_productos.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> ListAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
