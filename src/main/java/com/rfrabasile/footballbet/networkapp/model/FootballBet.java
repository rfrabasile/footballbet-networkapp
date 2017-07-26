/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rfrabasile.footballbet.networkapp.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rfrabasile.footballbet.networkapp.serializer.FootballBetSerializer;

/**
 *
 * @author rfrabasile@gmail.com
 */
@JsonSerialize(using = FootballBetSerializer.class)
public class FootballBet {
    
    private int idClient;
    private String timestamp;
    private int homeTeamId;
    private int awayTeamId;
    private short homeTeamScore;
    private short awayTeamScore;
    private byte currency;

    public FootballBet(int idClient, String timestamp, int homeTeamId, int awayTeamId, short homeTeamScore, short awayTeamScore, byte currency) {
        this.idClient = idClient;
        this.timestamp = timestamp;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.currency = currency;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public short getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(short homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public short getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(short awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public byte getCurrency() {
        return currency;
    }

    public void setCurrency(byte currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "FootballBet{" + "idClient=" + idClient + ", timestamp=" + timestamp + ", homeTeamId=" + homeTeamId + ", awayTeamId=" + awayTeamId + ", homeTeamScore=" + homeTeamScore + ", awayTeamScore=" + awayTeamScore + ", currency=" + currency + '}';
    }
    
}
