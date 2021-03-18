package com.miguelApi.tracker.services;

import com.fasterxml.jackson.databind.JsonNode;

import com.miguelApi.tracker.models.Game;
import com.miguelApi.tracker.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import static com.miguelApi.tracker.factory.MatchFactory.createMatch;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public void saveMatches(JsonNode dataNode){

        for (int i = 0; i < dataNode.size(); i++) {

            String id = dataNode.get(i).get("id").toString();
            String teamA = dataNode.get(i).get("teams").get(0).toString();
            String teamB = dataNode.get(i).get("teams").get(1).toString();
            String homeTeam = dataNode.get(i).get("home_team").toString();
            Game game = createMatch(id, teamA, teamB, homeTeam);
            matchRepository.save(game);


        }
    }



}
