package com.example.games_service_api.services.gameServiceInterface;

import com.example.games_service_api.common.entities.models.GameModel;
import com.example.games_service_api.common.entities.models.dtos.GameRequest;

public interface IGameService {
    GameModel createGame(GameRequest gameRequest);
    GameModel getGame(Long gameId);
    void updateGame(GameRequest gameRequest, Long gameId);
    void deleteGame(Long gameId);
}
