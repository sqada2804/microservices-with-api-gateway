package com.example.auth_service_api.services.interfaces;

import com.example.auth_service_api.dtos.LoginRequest;
import com.example.auth_service_api.dtos.TokenResponse;
import com.example.users_service_api.dtos.UserRequest;

public interface IAuthService {
    TokenResponse createUser(UserRequest userRequest);
    TokenResponse loginUser(LoginRequest loginRequest);
}
