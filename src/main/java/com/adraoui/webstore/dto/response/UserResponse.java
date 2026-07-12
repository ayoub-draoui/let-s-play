package com.adraoui.webstore.dto.response;

public record UserResponse (
    String id,
    String username,
    String fullName,
    String email
) 
{}
