package com.app.ms_invetario.http.response;

import com.app.ms_invetario.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductByIdProductResponse {
    private List<ProductDto> productDtoList;
}
