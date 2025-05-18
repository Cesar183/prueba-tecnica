package com.app.ms_invetario.client;

import com.app.ms_invetario.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ms-productos", url = "localhost:8001/app/productos")
public interface ProductClient {

    @GetMapping("/allProducts")
    List<ProductDto> allProduct();
}
