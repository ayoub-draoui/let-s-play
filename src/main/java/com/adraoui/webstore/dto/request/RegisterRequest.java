package com.adraoui.webstore.dto.request;

import jakarta.validation.constraints.*;

public record RegisterRequest(

        @NotBlank(message = "username is required") 
        @Size(min = 3, max = 30, message = "username should be between 3 and 30 char ") 
        String username,
        @NotBlank(message = "full name is required")
        @Size(min = 5, max = 100, message = "full name should be between 5 and 100 char ") 
        String fullName,
        @NotBlank(message = "email is required") 
        @Email(message = "the email format should be like : blog@example.com") 
        String email,
        @NotBlank(message = "Password is required") 
        @Size(min = 6, max = 30, message = "Password should be between 6 and 30 char ") 
        String password
    )

{}
