package com.example.games_service_api.controllers.gameControllersInterface;

import com.example.games_service_api.common.entities.models.GameModel;
import com.example.games_service_api.constants.apiGamePathConstant;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(apiGamePathConstant.V1_ROUTE + apiGamePathConstant.GAME_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IGameApi{

    @PostMapping(value = "/createGame")
    ResponseEntity<GameModel> createGame(
        @RequestBody GameModel gameRequest
    );

    @GetMapping(value = "/getGame/{gameId}")
    ResponseEntity<GameModel> getGame(
            @RequestHeader("X-User-Id") Long gameId
    );

    @PutMapping(value = "/updateGame/{gameId}")
    ResponseEntity<Void> updateGame(@RequestBody GameModel gameRequest, @RequestHeader("X-User-Id") Long gameId);

    @DeleteMapping(value = "/deleteGame/{gameId}")
    ResponseEntity<Void> deleteGame(@RequestHeader("X-User-Id") Long gameId);
}
