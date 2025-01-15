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
            @PathVariable("gameId") Long gameId,
            @RequestHeader("X-User-Id") Long userId
    );

    @PutMapping(value = "/updateGame/{gameId}")
    ResponseEntity<Void> updateGame(@RequestBody GameModel gameRequest,
                                    @PathVariable("gameId") Long gameId,
                                    @RequestHeader("X-User-Id") Long userId);

    @DeleteMapping(value = "/deleteGame/{gameId}")
    ResponseEntity<Void> deleteGame(
            @PathVariable("gameId") Long gameId,
            @RequestHeader("X-User-Id") Long userId);
}
