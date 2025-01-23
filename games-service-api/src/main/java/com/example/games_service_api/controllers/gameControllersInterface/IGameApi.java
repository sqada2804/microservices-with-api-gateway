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

    @PostMapping(value = "/createGame")
    ResponseEntity<GameModel> createGame(
        @RequestBody GameRequest gameRequest,
        @RequestHeader("X-User-Id") String userId
    );

    @GetMapping(value = "/getGame/{gameId}")
    ResponseEntity<GameModel> getGame(
            @PathVariable("gameId") Long gameId,
            @RequestHeader("X-User-Id") String userId
    );

    @PutMapping(value = "/updateGame/{gameId}")
    ResponseEntity<Void> updateGame(@RequestBody GameRequest gameRequest,
                                    @PathVariable("gameId") Long gameId,
                                    @RequestHeader("X-User-Id") String userId);


    @DeleteMapping(value = "/deleteGame/{gameId}")
    ResponseEntity<Void> deleteGame(
            @PathVariable("gameId") Long gameId,
            @RequestHeader("X-User-Id") String userId);
}
