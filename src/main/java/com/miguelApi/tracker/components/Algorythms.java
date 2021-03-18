package com.miguelApi.tracker.components;

import com.miguelApi.tracker.models.Bet;

import java.util.Arrays;
import java.util.LinkedList;

public class Algorythms {

    public static LinkedList<Bet> findPairBooker(LinkedList<Bet> bets) {

        LinkedList<Bet> betPair = new LinkedList<>();

        for (int i = 0; i < bets.size(); i++) {

            if (i + 1 == bets.size()) {
                if (!betPair.isEmpty()) {
                    return betPair;
                } else {
                    return null;
                }
            }

            String a = bets.get(i).getPoints();
            String b = bets.get(i + 1).getPoints();

            if (a.equals(b)) {
                betPair.add(bets.get(i));
                betPair.add(bets.get(i + 1));
                return betPair;
            }
        }
        return betPair;
    }


    public static boolean isSureBet(LinkedList<Bet> pairBet) {

        float a1 = pairBet.get(0).getOdds()[0];
        float a2 = pairBet.get(0).getOdds()[1];
        float b1 = pairBet.get(1).getOdds()[0];
        float b2 = pairBet.get(1).getOdds()[1];

        float[] arr = {a1, a2, b1, b2};
        boolean isSureBet = false;


        Arrays.sort(arr);

        if (a1 == arr[3]) {
            isSureBet = findSureBet(a1, b2);

        }

        if (a2 == arr[3]) {
            isSureBet = findSureBet(b1, a2);

        }

        if (b1 == arr[3]) {
            isSureBet = findSureBet(b1, a2);

        }

        if (b2 == arr[3]) {
            isSureBet = findSureBet(a1, b2);

        }

       return isSureBet;


    }

    public static boolean findSureBet(float oddsA, float oddsB) {
        float sum_odds = (1 / oddsA) + (1 / oddsB);

        boolean isSureBet;

        if (sum_odds < 1) {
            isSureBet = true;
        } else {
            isSureBet = false;
        }

        return isSureBet;

    }


}
