package com.adraoui.webstore.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;




public record CreateProductRequest (

@NotBlank(message = "product name is required")
String name,
@NotBlank(message = "product description is required")
String description,
@NotNull(message = "product price is required")
@Positive(message = "product price must be a positive value")
BigDecimal price,
String imageUrl
) 

{}
