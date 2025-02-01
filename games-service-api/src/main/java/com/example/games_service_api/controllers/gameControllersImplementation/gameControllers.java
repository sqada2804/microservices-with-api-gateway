package com.example.games_service_api.controllers.gameControllersImplementation;

import com.example.games_service_api.common.entities.models.GameModel;
import com.example.games_service_api.common.entities.models.dtos.GameRequest;
import com.example.games_service_api.controllers.gameControllersInterface.IGameApi;
import com.example.games_service_api.services.gameServiceInterface.IGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gameControllers implements IGameApi {
    private final IGameService gameService;

    public gameControllers(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<GameModel> createGame(GameRequest gameRequest, String userId) {
        return ResponseEntity.ok(gameService.createGame(gameRequest, userId));
    }

    @Override
    public ResponseEntity<GameModel> getGame(String userId, Long gameId) {
        return ResponseEntity.ok(gameService.getGame(userId, gameId));
    }


    @Override
    public ResponseEntity<Void> updateGame(GameRequest gameRequest, String userId, Long gameId) {
        gameService.updateGame(gameRequest, userId, gameId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteGame(String userId, Long gameId) {
        gameService.deleteGame(userId, gameId);
        return ResponseEntity.noContent().build();
    }


}
