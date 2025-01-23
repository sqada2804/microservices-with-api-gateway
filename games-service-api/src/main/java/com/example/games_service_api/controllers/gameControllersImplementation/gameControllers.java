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
        return ResponseEntity.ok(gameService.createGame(gameRequest));
    }

    @Override
    public ResponseEntity<GameModel> getGame(Long gameId, String userId) {
        return ResponseEntity.ok(gameService.getGame(gameId));
    }

    @Override
    public ResponseEntity<Void> updateGame(GameRequest gameRequest, Long gameId, String userId) {
        gameService.updateGame(gameRequest, gameId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteGame(Long gameId, String userId) {
        gameService.deleteGame(gameId);
        return ResponseEntity.noContent().build();
    }


}
