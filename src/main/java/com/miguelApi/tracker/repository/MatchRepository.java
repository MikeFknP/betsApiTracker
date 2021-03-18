package com.miguelApi.tracker.repository;



import com.miguelApi.tracker.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Game,Long> {

    @Override
    <S extends Game> S save(S s);

    @Override
    List<Game> findAll();

}
