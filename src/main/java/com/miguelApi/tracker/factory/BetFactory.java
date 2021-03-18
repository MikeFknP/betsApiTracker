package com.miguelApi.tracker.factory;

import com.miguelApi.tracker.models.Bet;

public class BetFactory {

    public static Bet createBet(String site_key, float[] odds, String position, String points) {
        Bet bet = new Bet(site_key, odds, position, points);
        return bet;
    }

}
