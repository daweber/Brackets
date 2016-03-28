package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Pickset Table class
 */
@Table(database = BracketsDatabase.class, useIsForPrivateBooleans = true)
public class Pickset extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private int picksetId;
    @Column
    private int bracketId;
    @Column
    private String picksetName;
    @Column
    private boolean locked;

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getPicksetId() {
        return picksetId;
    }

    public void setPicksetId(int picksetId) {
        this.picksetId = picksetId;
    }

    public int getBracketId() {
        return bracketId;
    }

    public void setBracketId(int bracketId) {
        this.bracketId = bracketId;
    }

    public String getPicksetName() {
        return picksetName;
    }

    public void setPicksetName(String picksetName) {
        this.picksetName = picksetName;
    }

}
