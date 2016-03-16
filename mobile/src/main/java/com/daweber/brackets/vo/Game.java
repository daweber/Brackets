package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Game Class
 */
@Table(database = BracketsDatabase.class)
public class Game extends BaseModel {

    // Administrative Fields
    @Column
    @PrimaryKey(autoincrement = false)
    public int gID;
    @Column
    public int bID;
    @Column
    public int bRound;
    @Column
    public Boolean isFinal;

    // Game Card Fields
    @Column
    public String tOne;
    @Column
    public int tOneScore;
    @Column
    public String tTwo;
    @Column
    public int tTwoScore;
    @Column
    public String gDetails;

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public int getbRound() {
        return bRound;
    }

    public void setbRound(int bRound) {
        this.bRound = bRound;
    }

    public Boolean getFinal() {
        return isFinal;
    }

    public void setFinal(Boolean aFinal) {
        isFinal = aFinal;
    }

    public String gettOne() {
        return tOne;
    }

    public void settOne(String tOne) {
        this.tOne = tOne;
    }

    public int gettOneScore() {
        return tOneScore;
    }

    public void settOneScore(int tOneScore) {
        this.tOneScore = tOneScore;
    }

    public String gettTwo() {
        return tTwo;
    }

    public void settTwo(String tTwo) {
        this.tTwo = tTwo;
    }

    public int gettTwoScore() {
        return tTwoScore;
    }

    public void settTwoScore(int tTwoScore) {
        this.tTwoScore = tTwoScore;
    }

    public String getgDetails() {
        return gDetails;
    }

    public void setgDetails(String gDetails) {
        this.gDetails = gDetails;
    }

}
