package com.example.games_service_api.services.gameServiceImplementation;


import com.example.games_service_api.common.entities.models.GameModel;
import com.example.games_service_api.common.entities.models.dtos.GameRequest;
import com.example.games_service_api.repository.gameRepositoryInterface.IGameRepository;
import com.example.games_service_api.services.gameServiceInterface.IGameService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class gameServiceImplementation implements IGameService {

    private final IGameRepository gameRepository;

    public gameServiceImplementation(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameModel createGame(GameRequest gameRequest, String userId) {
        return Optional.of(gameRequest).
                map(game -> mapToEntity(game, userId)).
                map(gameRepository::save).
                orElseThrow(() -> new RuntimeException("Error creating game"));
    }


    @Override
    public GameModel getGame(String userId, Long gameId) {
        return Optional.of(userId).flatMap(userId1 -> gameRepository.findGameByUserIdAndGameId(userId1, gameId))
                .orElseThrow(() -> new RuntimeException("Error finding game by id"));
    }


    @Override
    public void updateGame(GameRequest gameRequest, String userId, Long gameId) {
        gameRepository.findGameByUserIdAndGameId(userId, gameId)
                .map(gameExists -> updateFieldsGame(gameExists, gameRequest))
                .map(gameRepository::save)
                .orElseThrow(() -> new RuntimeException("Error updating Game Fields"));
    }

    private GameModel updateFieldsGame(GameModel existingGame, GameRequest gameRequest) {
        existingGame.setName(gameRequest.getName());
        return existingGame;
    }

    @Override
    public void deleteGame(String userId, Long gameId) {
        gameRepository.findGameByUserIdAndGameId(userId, gameId)
                .ifPresentOrElse(gameRepository::delete, () -> {
                    throw new RuntimeException("Error deleting game");
                });
    }

    private GameModel mapToEntity(GameRequest gameRequest, String userId) {
        return GameModel.builder().name(gameRequest.getName())
                .userId(userId)
                .build();
    }
}
