package com.adraoui.webstore.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "products")

public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private String ownerId;

    private String imageUrl;

    private Instant createdAt;

    private Instant updatedAt;

    private int stock;
}