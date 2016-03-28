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


    @PrimaryKey(autoincrement = false)
    private int pickId;
    @Column
    private int picksetId;
    @Column
    private int gameId;
    @Column
    private int pickedWinner;

    public int getPickId() {
        return pickId;
    }

    public void setPickId(int pickId) {
        this.pickId = pickId;
    }

    public int getPicksetId() {
        return picksetId;
    }

    public void setPicksetId(int picksetId) {
        this.picksetId = picksetId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPickedWinner() {
        return pickedWinner;
    }

    public void setPickedWinner(int pickedWinner) {
        this.pickedWinner = pickedWinner;
    }
}
