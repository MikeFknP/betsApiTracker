package com.miguelApi.tracker.services;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class MainService {

    @Autowired
    ApiFetcher apiFetcher;
    @Autowired
    PrinterService printerService;
    @Autowired
    public BetsService betsService;
    @Autowired MatchService matchService;

    private String region = "uk";
    private String mkt = "totals";

    JsonNode dataJson;

    public void printUpComingBets(String sport) {
        {
            try {
                dataJson = apiFetcher.getApiResults(sport, region, mkt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Print
        printerService.printNodes(dataJson,sport);
        //Persist
        betsService.saveBets(dataJson);
        matchService.saveMatches(dataJson);
    }


}
