package com.daweber.brackets;

import android.location.Address;

import java.util.Date;

/**
 * Created by moweber on 2/8/2016.
 */
public class Game {
    protected Boolean isFinal;
    protected String tOne;
    protected String tTwo;
    protected int tOneScore;
    protected int tTwoScore;
    protected String gSite;
    protected Address gLocation;
    protected Date gDate;
    protected String gTitle;

    protected static final String TEAM_ONE_PREFIX = "Home State Team ";
    protected static final String TEAM_TWO_PREFIX = "University of Team ";
}
