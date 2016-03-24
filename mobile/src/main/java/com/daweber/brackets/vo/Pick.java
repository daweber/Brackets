package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Pick Table class
 */
@Table(database = BracketsDatabase.class)
public class Pick extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = false)
    public int pickId;
    @Column
    public int bracketId;
    @Column
    public int gameId;
    @Column
    public int pickedWinner;

    public int getBracketId() {
        return bracketId;
    }

    public void setBracketId(int bracketId) {
        this.bracketId = bracketId;
    }

    public int getPickedWinner() {
        return pickedWinner;
    }

    public void setPickedWinner(int pickedWinner) {
        this.pickedWinner = pickedWinner;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPickId() {
        return pickId;
    }

    public void setPickId(int pickId) {
        this.pickId = pickId;
    }
}
