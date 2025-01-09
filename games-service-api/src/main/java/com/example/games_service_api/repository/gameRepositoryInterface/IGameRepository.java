package com.example.games_service_api.repository.gameRepositoryInterface;

import com.example.games_service_api.common.entities.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameRepository extends JpaRepository<GameModel, Long> {
}
