package com.mg_devjoint.auth_service.dto.response;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {
}
