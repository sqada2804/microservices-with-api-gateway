package com.example.games_service_api.controllers.gameControllersImplementation;

import com.example.games_service_api.common.entities.models.GameModel;
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
    public ResponseEntity<GameModel> createGame(GameModel gameRequest) {
        return ResponseEntity.ok(gameService.createGame(gameRequest));
    }

    @Override
    public ResponseEntity<GameModel> getGame(Long gameId) {
        return ResponseEntity.ok(gameService.getGame(gameId));
    }

    @Override
    public ResponseEntity<Void> updateGame(GameModel gameRequest, Long gameId) {
        gameService.updateGame(gameRequest, gameId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteGame(Long gameId) {
        gameService.deleteGame(gameId);
        return ResponseEntity.noContent().build();
    }


}
