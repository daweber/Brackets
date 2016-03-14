package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Bracket Class
 */
@Table(databaseName = BracketsDatabase.NAME)
public class Bracket extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = false)
    public int bID;
    @Column
    public String bName;
}
