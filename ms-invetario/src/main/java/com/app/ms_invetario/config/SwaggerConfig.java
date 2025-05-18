package com.app.ms_invetario.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Microservicio Inventario",
                description = "Microservicio encargado de la gestión del inventario de productos.",
                version = "1.0.0"
        )
)
public class SwaggerConfig {
}
