package com.daweber.brackets.model;

import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;

/**
 * PicksetGames Query Model class
 */
@QueryModel(database = BracketsDatabase.class, allFields = true)
public class PicksetGames extends BaseQueryModel {
    private int gameId;
    private int bracketRound;
    private int bracketRegion;
    private boolean gameOver;
    private String teamOne;
    private String teamOneScore;
    private String teamTwo;
    private String teamTwoScore;
    private String gameDetails;
    private int pickedWinner;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getBracketRound() {
        return bracketRound;
    }

    public void setBracketRound(int bracketRound) {
        this.bracketRound = bracketRound;
    }

    public int getBracketRegion() {
        return bracketRegion;
    }

    public void setBracketRegion(int bracketRegion) {
        this.bracketRegion = bracketRegion;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(String teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(String teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public String getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(String gameDetails) {
        this.gameDetails = gameDetails;
    }

    public int getPickedWinner() {
        return pickedWinner;
    }

    public void setPickedWinner(int pickedWinner) {
        this.pickedWinner = pickedWinner;
    }
}
