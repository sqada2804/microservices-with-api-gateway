package com.example.games_service_api.controllers.gameControllersInterface;

import com.example.games_service_api.common.entities.models.GameModel;
import com.example.games_service_api.common.entities.models.dtos.GameRequest;
import com.example.games_service_api.common.entities.models.constants.apiGamePathConstant;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(apiGamePathConstant.V1_ROUTE + apiGamePathConstant.GAME_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IGameApi{
    @PostMapping(value = "/create")
    ResponseEntity<GameModel> createGame(
        @RequestBody GameRequest gameRequest,
        @RequestHeader("X-User-Id") String userId
    );

    @GetMapping(value = "/get/{gameId}")
    ResponseEntity<GameModel> getGame(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable Long gameId
    );

    @PutMapping(value = "/update/{gameId}")
    ResponseEntity<Void> updateGame(@RequestBody GameRequest gameRequest,
                                    @RequestHeader("X-User-Id") String userId,
                                    @PathVariable Long gameId);

    @DeleteMapping(value = "/delete/{gameId}")
    ResponseEntity<Void> deleteGame(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable Long gameId
    );
}
