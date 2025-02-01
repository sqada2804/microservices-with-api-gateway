package com.example.games_service_api.repository.gameRepositoryInterface;

import com.example.games_service_api.common.entities.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGameRepository extends JpaRepository<GameModel, Long> {
    Optional<GameModel> findGameByUserIdAndGameId(@Param("userId") String userId, @Param("{gameId}") Long gameId);
}
