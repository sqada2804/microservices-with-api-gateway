package com.example.games_service_api.common.entities.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "games")

public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String name;
    private String userId;
}
