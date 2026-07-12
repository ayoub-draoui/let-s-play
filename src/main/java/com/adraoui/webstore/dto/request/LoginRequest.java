package com.adraoui.webstore.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

    
        @NotBlank(message = "username or email is required") 
        String usernameOrEmail,

        @NotBlank(message = "password is required") 
        String password

)
{}
