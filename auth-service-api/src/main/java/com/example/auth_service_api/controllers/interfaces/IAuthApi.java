package com.example.auth_service_api.controllers.interfaces;

import com.example.auth_service_api.constants.apiAuthPathConstant;
import com.example.auth_service_api.dtos.LoginRequest;
import com.example.auth_service_api.dtos.TokenResponse;


import com.example.auth_service_api.dtos.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(apiAuthPathConstant.V1_ROUTE + apiAuthPathConstant.AUTH_ROUTE)
public interface IAuthApi {
    @PostMapping(value = "/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);

    @PostMapping(value = "/login")
    ResponseEntity<TokenResponse> loginUser(@RequestBody @Valid LoginRequest loginRequest);
}
