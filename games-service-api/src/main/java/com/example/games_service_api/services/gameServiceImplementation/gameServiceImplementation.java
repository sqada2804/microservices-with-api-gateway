package com.example.games_service_api.services.gameServiceImplementation;


import com.example.games_service_api.common.entities.models.GameModel;
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

    public GameModel createGame(GameModel gameRequest) {
        return Optional.ofNullable(gameRequest).
                map(this::mapToEntity).
                map(gameRepository::save).
                orElseThrow(() -> new RuntimeException("Error creating game"));
    }

    @Override
    public GameModel getGame(Long gameId) {
        return Optional.of(gameId).flatMap(gameRepository::findById)
                .orElseThrow(() -> new RuntimeException("Error finding game by id"));
    }

    @Override
    public void updateGame(GameModel gameRequest, Long gameId) {
            Optional.of(gameId)
                .map(this::getGame)
                .map(existingGame -> updateFieldsGame(existingGame, gameRequest))
                .map(gameRepository::save)
                .orElseThrow(() -> new RuntimeException("Error couldn´t update game"));
    }

    private GameModel updateFieldsGame(GameModel existingGame, GameModel gameRequest){
        existingGame.setName(gameRequest.getName());
        return existingGame;
    }

    @Override
    public void deleteGame(Long gameId) {
        Optional.of(gameId)
                .map(this::getGame)
                .ifPresent(gameRepository::delete);
    }

    private GameModel mapToEntity(GameModel gameRequest) {
        return GameModel.builder().name(gameRequest.getName()).build();
    }
}
