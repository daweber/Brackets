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


    public static final String TEAM_ONE_PREFIX = "Home State Team ";
    public static final String TEAM_TWO_PREFIX = "University of Team ";

}
