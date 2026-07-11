package com.adraoui.webstore.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String username;

    private String fullName;

    private String email;

    private String password;

    private Role role;

    private Instant createdAt;

    private Instant updatedAt;
}
