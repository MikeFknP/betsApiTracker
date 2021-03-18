package com.miguelApi.tracker.repository;

import com.miguelApi.tracker.models.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet,Long> {

    @Override
    <S extends Bet> S save(S s);

    @Override
    List<Bet> findAll();
}
