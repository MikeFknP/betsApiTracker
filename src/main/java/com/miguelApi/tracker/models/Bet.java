package com.miguelApi.tracker.models;

import javax.persistence.*;

@Entity
@Table(name = "Bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="booker")
    private String site_key;
    @Transient
    private float[] odds;
    @Column(name="position")
    private String position;
    @Column(name="points")
    private String points;
    @Column(name="finalPosition")
    private String finalPosition;

    public Bet(){}

    public Bet(String site_key,float[] odds,String position,String points){
        this.site_key = site_key;
        this.odds = odds;
        this.position = position;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSite_key(String site_key) {
        this.site_key = site_key;
    }

    public void setOdds(float[] odds) {
        this.odds = odds;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public float[] getOdds() {
        return odds;
    }

    public String getPoints() {
        return points;
    }

    public String getPosition() {
        return position;
    }

    public String getSite_key() {
        return site_key;
    }

    public String getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(String finalPosition) {
        this.finalPosition = finalPosition;
    }
}
