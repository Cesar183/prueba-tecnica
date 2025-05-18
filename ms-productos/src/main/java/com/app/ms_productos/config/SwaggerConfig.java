package com.app.ms_productos.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Microservicio Productos",
                description = "Microservicio responsable de la gestión de productos.",
                version = "1.0.0"
        )
)
public class SwaggerConfig {
}
