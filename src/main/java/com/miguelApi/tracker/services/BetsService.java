package com.miguelApi.tracker.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.miguelApi.tracker.factory.BetFactory;
import com.miguelApi.tracker.models.Bet;
import com.miguelApi.tracker.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

import static com.miguelApi.tracker.components.UtilParser.parseOddsToFloat;

@Service
public class BetsService {

    @Autowired
    BetRepository betRepository;

    public void saveBets(JsonNode dataNode) {

        for (int i = 0; i < dataNode.size(); i++) {

            LinkedList<Bet> bets = new LinkedList<>();
            JsonNode sitesNode = dataNode.get(i).get("sites");

            for (int j = 0; j < sitesNode.size(); j++) {

                String site_key = sitesNode.get(j).get("site_key").asText();

                JsonNode oddsNode = sitesNode.get(j);

                JsonNode totals = oddsNode.get("odds");
                JsonNode tot = totals.get("totals");

                String odds = tot.get("odds").toString();
                String position = tot.get("position").toString();
                String points = tot.get("points").toString();

                String teamA = dataNode.get(i).get("teams").get(0).toString();
                String teamB = dataNode.get(i).get("teams").get(1).toString();
                String homeTeam = dataNode.get(i).get("home_team").toString();
                String gameId = dataNode.get(i).get("id").toString();

                Bet bet = BetFactory.createBet(site_key, parseOddsToFloat(odds), position, points);
                bets.add(bet);
                betRepository.save(bet);
            }
        }
    }
}
