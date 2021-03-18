package com.miguelApi.tracker.controllers;


import com.miguelApi.tracker.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    public MainService mainService;


    @GetMapping("/upcoming")
    public ResponseEntity getUpcomingGames() throws IOException {
        String sport = "upcoming";
        mainService.printUpComingBets(sport);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/spain")
    public ResponseEntity getSpanishLeague() throws IOException {
        String sport = "soccer_spain_la_liga";
        mainService.printUpComingBets(sport);
        return new ResponseEntity(HttpStatus.OK);
    }

}
