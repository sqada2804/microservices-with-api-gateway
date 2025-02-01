package com.example.games_service_api.common.entities.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameRequest {
    @NotNull
    private String name;
}
