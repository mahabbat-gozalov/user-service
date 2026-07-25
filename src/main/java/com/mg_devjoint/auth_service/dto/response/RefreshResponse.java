package com.mg_devjoint.auth_service.dto.response;

public record RefreshResponse(
        String accessToken,
        String refreshToken
) {
}
