package com.adraoui.webstore.dto.response;

public record LoginResponse (
    String accessToken,

    String tokenType
) 
{}
