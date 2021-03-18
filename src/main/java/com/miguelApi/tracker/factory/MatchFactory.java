package com.miguelApi.tracker.factory;

import com.miguelApi.tracker.models.Game;

public class MatchFactory {

    public static Game createMatch(String id, String teamA, String teamB, String homeTeam){
        return new Game(id,teamA,teamB,homeTeam);
    }

}
