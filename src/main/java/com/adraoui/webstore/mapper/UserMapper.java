package com.adraoui.webstore.mapper;
import com.adraoui.webstore.dto.request.RegisterRequest;
import com.adraoui.webstore.dto.response.UserResponse;
import com.adraoui.webstore.model.User;

public final class UserMapper {

    private UserMapper() {}

    public static User toEntity(RegisterRequest request) {
        return User.builder()
                .username(request.username())
                .fullName(request.fullName())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getEmail()
        );
    }
}
