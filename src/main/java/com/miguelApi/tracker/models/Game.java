package com.miguelApi.tracker.models;

import javax.persistence.*;


@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;


    @Column(name = "MatchId")
    private String matchId;
    @Column(name = "TeamA")
    private String teamA;
    @Column(name = "TeamB")
    private String teamB;
    @Column(name = "HomeTeam")
    private String homeTeam;

    public Game() {
    }

    public Game(String matchId, String teamA, String teamB, String homeTeam) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.homeTeam = homeTeam;

    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
}
