package com.example.games_service_api.services.gameServiceInterface;

import com.example.games_service_api.common.entities.models.GameModel;

public interface IGameService {
    GameModel createGame(GameModel gameRequest);
    GameModel getGame(Long gameId);
    void updateGame(GameModel gameRequest, Long gameId);
    void deleteGame(Long gameId);
}
