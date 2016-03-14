package com.daweber.brackets.vo;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Game Class
 */
@Table(databaseName = BracketsDatabase.NAME)
public class Game extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = false)
    public int gID;
    @Column
    public Boolean isFinal;
    @Column
    public String tOne;
    @Column
    public String tTwo;
    @Column
    public int tOneScore;
    @Column
    public int tTwoScore;
    @Column
    public String gSite;
    @Column
    public String gLocation;
    @Column
    public long gDate;
    @Column
    public String gTitle;

    public static final String TEAM_ONE_PREFIX = "Home State Team ";
    public static final String TEAM_TWO_PREFIX = "University of Team ";

}
