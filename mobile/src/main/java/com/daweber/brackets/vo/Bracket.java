package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Bracket Table class
 */
@Table(database = BracketsDatabase.class)
public class Bracket extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = false)
    public int bracketId;
    @Column
    public String bracketName;
}
