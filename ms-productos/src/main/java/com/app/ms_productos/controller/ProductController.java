package com.app.ms_productos.controller;

import com.app.ms_productos.entity.Product;
import com.app.ms_productos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/productos")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.ListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> byId(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        if (productOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(productOptional);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> productOptional = service.findById(id);
        if (productOptional.isPresent()){
            Product productDb = productOptional.get();
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        if (productOptional.isPresent()){
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findByIdProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findProduct());
    }
}
