package com.example.users_service_api.commons.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateInfoRequest {
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String password;
}

