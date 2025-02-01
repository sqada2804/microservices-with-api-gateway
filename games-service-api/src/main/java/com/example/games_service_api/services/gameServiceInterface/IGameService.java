package com.example.games_service_api.services.gameServiceInterface;

import com.example.games_service_api.common.entities.models.GameModel;
import com.example.games_service_api.common.entities.models.dtos.GameRequest;

public interface IGameService {
    GameModel createGame(GameRequest gameRequest, String userId);
    GameModel getGame(String userId, Long gameId);
    void updateGame(GameRequest gameRequest, String userId, Long gameId);
    void deleteGame(String userId, Long gameId);
}
