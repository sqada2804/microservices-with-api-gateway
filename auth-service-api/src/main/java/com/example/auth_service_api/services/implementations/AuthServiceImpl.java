package com.example.auth_service_api.services.implementations;

import com.example.auth_service_api.dtos.LoginRequest;
import com.example.auth_service_api.dtos.TokenResponse;
import com.example.auth_service_api.dtos.UserRequest;
import com.example.auth_service_api.repository.UserRepository;
import com.example.auth_service_api.services.interfaces.IAuthService;
import com.example.common_library.entity.UserModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtServiceImpl jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public TokenResponse loginUser(LoginRequest loginRequest) {
        return Optional.of(loginRequest.getEmail())
                .map(userRepository::findByEmail)
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword()))
                .map(user -> jwtService.generateToken(user.get().getUserId()))
                .orElseThrow(() -> new RuntimeException("Error login User"));
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .role("USER")
                .build();
    }
}
