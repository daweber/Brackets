package com.daweber.brackets.vo;

import android.location.Address;

import java.util.Date;

/**
 * Created by moweber on 2/8/2016.
 */
public class Game {
    public Boolean isFinal;
    public String tOne;
    public String tTwo;
    int tOneScore;
    int tTwoScore;
    String gSite;
    Address gLocation;
    Date gDate;
    String gTitle;

    public static final String TEAM_ONE_PREFIX = "Home State Team ";
    public static final String TEAM_TWO_PREFIX = "University of Team ";
}
