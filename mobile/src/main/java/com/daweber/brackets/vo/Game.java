package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Game Table class
 */
@Table(database = BracketsDatabase.class, useIsForPrivateBooleans = true)
public class Game extends BaseModel {

    public static String REGION[] = {"finals", "south", "west", "east", "midwest"};

    @PrimaryKey(autoincrement = true)
    private int gameId;
    @Column
    private int bracketId;
    @Column
    private int bracketRound;
    @Column
    private int bracketRegion;
    @Column
    private boolean gameOver;

    @Column
    private String teamOne;
    @Column
    private int teamOneScore;
    @Column
    private String teamTwo;
    @Column
    private int teamTwoScore;
    @Column
    private String gameDetails;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getBracketId() {
        return bracketId;
    }

    public void setBracketId(int bracketId) {
        this.bracketId = bracketId;
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

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(int teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public String getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(String gameDetails) {
        this.gameDetails = gameDetails;
    }

}
