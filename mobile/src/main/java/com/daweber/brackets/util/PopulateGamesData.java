package com.daweber.brackets.util;

import android.util.Log;

import com.daweber.brackets.model.BracketsDatabase;
import com.daweber.brackets.vo.Game;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/**
 * Migration Class
 */
@Migration(version = 0, database = BracketsDatabase.class)
public class PopulateGamesData extends BaseMigration {
    private static final String TAG = "b64.BracketsData";
    private String TEAMS_ONE[] = {"Kansas [1]", "Colorado [8]", "Maryland [5]",
            "California [4]", "Arizona [6]", "Miami (Fla.) [3]", "Iowa [7]",
            "Villanova [2]", "Oregon [1]", "Saint Joseph's [8]", "Baylor [5]", "Duke [4]",
            "Texas [6]", "Texas A&M [3]", "Oregon State [7]", "Oklahoma [2]",
            "North Carolina [1]", "USC [8]", "Indiana [5]", "Kentucky [4]",
            "Notre Dame [6]", "West Virginia [3]", "Wisconsin [7]", "Xavier [2]",
            "Virginia [1]", "Texas Tech [8]", "Purdue [5]", "Iowa State [4]",
            "Seton Hall [6]", "Utah [3]", "Dayton [7]", "Michigan State [2]",
            "Winner of game: 1", "Winner of game: 3", "Winner of game: 5",
            "Winner of game: 7", "Winner of game: 9", "Winner of game: 11",
            "Winner of game: 13", "Winner of game: 15", "Winner of game: 17",
            "Winner of game: 19", "Winner of game: 21", "Winner of game: 23",
            "Winner of game: 25", "Winner of game: 27", "Winner of game: 29",
            "Winner of game: 31", "Winner of game: 33", "Winner of game: 35",
            "Winner of game: 37", "Winner of game: 39", "Winner of game: 41",
            "Winner of game: 43", "Winner of game: 45", "Winner of game: 47",
            "Winner of game: 49", "Winner of game: 51", "Winner of game: 53",
            "Winner of game: 55", "Winner of game: 57", "Winner of game: 59",
            "Winner of game: 61"};
    private String TEAMS_TWO[] = {"Austin Peay [16]", "Connecticut [9]",
            "South Dakota St. [12]", "Hawaii [13]", "Wichita State [11]", "Buffalo [14]",
            "Temple [10]", "UNC-Asheville [15]", "Holy Cross [16]", "Cincinnati [9]",
            "Yale [12]", "UNC-Wilmington [13]", "Northern Iowa [11]",
            "Green Bay [14]", "VCU [10]", "CSU Bakersfield [15]",
            "Florida Gulf Coast [16]", "Providence [9]", "Chattanooga [12]",
            "Stony Brook [13]", "Michigan [11]", "Steph. F. Austin [14]",
            "Pittsburgh [10]", "Weber State [15]", "Hampton [16]", "Butler [9]",
            "Little Rock [12]", "Iona [13]", "Gonzaga [11]", "Fresno State [14]",
            "Syracuse [10]", "Middle Tennessee [15]",
            "Winner of game: 2", "Winner of game: 4", "Winner of game: 6",
            "Winner of game: 8", "Winner of game: 10", "Winner of game: 12",
            "Winner of game: 14", "Winner of game: 16", "Winner of game: 18",
            "Winner of game: 20", "Winner of game: 22", "Winner of game: 24",
            "Winner of game: 26", "Winner of game: 28", "Winner of game: 30",
            "Winner of game: 32", "Winner of game: 34", "Winner of game: 36",
            "Winner of game: 38", "Winner of game: 40", "Winner of game: 42",
            "Winner of game: 44", "Winner of game: 46", "Winner of game: 48",
            "Winner of game: 50", "Winner of game: 52", "Winner of game: 54",
            "Winner of game: 56", "Winner of game: 58", "Winner of game: 60",
            "Winner of game: 62"};
    private String GAMES_DETAIL[] = {"(MAR.17) Des Moines, IA [TNT 4:00 PM]",
            "(MAR.17) Des Moines, IA [TNT 1:30 PM]", "(MAR.18) Spokane, WA [TBS 4:30 PM]",
            "(MAR.18) Spokane, WA [TBS 2:00 PM]", "(MAR.17) Providence, RI [TNT 9:20 PM]",
            "(MAR.17) Providence, RI [TNT 6:50 PM]",
            "(MAR.18) Brooklyn, NY [TRU 3:10 PM]",
            "(MAR.18) Brooklyn, NY [TRU 12:40 PM]", "(MAR.18) Spokane, WA [TRU 7:27 PM]",
            "(MAR.18) Spokane, WA [TRU 9:57 PM]", "(MAR.17) Providence, RI [CBS 2:45 PM]",
            "(MAR.17) Providence, RI [CBS 12:15 PM]",
            "(MAR.18) Oklahoma City, OK [TBS 9:50 PM]",
            "(MAR.18) Oklahoma City, OK [TBS 7:20 PM]",
            "(MAR.18) Oklahoma City, OK [TNT 1:30 PM]",
            "(MAR.18) Oklahoma City, OK [TNT 4:00 PM]",
            "(MAR.17) Raleigh, NC [TBS 7:20 PM]",
            "(MAR.17) Raleigh, NC [TBS 9:50 PM]", "(MAR.17) Des Moines, IA [CBS 7:10 PM]",
            "(MAR.17) Des Moines, IA [CBS 9:40 PM]",
            "(MAR.18) Brooklyn, NY [CBS 9:40 PM]", "(MAR.18) Brooklyn, NY [CBS 7:10 PM]",
            "(MAR.18) St. Louis, MO [TNT 6:50 PM]",
            "(MAR.18) St. Louis, MO [TNT 9:20 PM]", "(MAR.17) Raleigh, NC [TRU 3:10 PM]",
            "(MAR.17) Raleigh, NC [TRU 12:40 PM]", "(MAR.17) Denver, CO [TBS 4:30 PM]",
            "(MAR.17) Denver, CO [TBS 2:00 PM]", "(MAR.17) Denver, CO [TRU 9:57 PM]",
            "(MAR.17) Denver, CO [TRU 7:27 PM]", "(MAR.18) St. Louis, MO [CBS 12:15 PM]",
            "(MAR.18) St. Louis, MO [CBS 2:45 PM]", "(MAR.19) Des Moines, IA [TBD]",
            "(MAR.20) Spokane, WA [TBD]", "(MAR.19) Providence, RI [TBD]",
            "(MAR.20) Brooklyn, NY [TBD]", "(MAR.20) Spokane, WA [TBD]",
            "(MAR.19) Providence, RI [TBD]", "(MAR.20) Oklahoma City, OK [TBD]",
            "(MAR.20) Oklahoma City, OK [TBD]", "(MAR.19) Raleigh, NC [TBD]",
            "(MAR.19) Des Moines, IA [TBD]", "(MAR.20) Brooklyn, NY [TBD]",
            "(MAR.20) St. Louis, MO [TBD]", "(MAR.19) Raleigh, NC [TBD]",
            "(MAR.19) Denver, CO [TBD]", "(MAR.19) Denver, CO [TBD]",
            "(MAR.20) St. Louis, MO [TBD]", "(MAR.24) Louisville, KY [TBD]",
            "(MAR.24) Louisville, KY [TBD]", "(MAR.24) Anaheim, CA [TBD]",
            "(MAR.24) Anaheim, CA [TBD]", "(MAR.25) Philadelphia, PA [TBD]",
            "(MAR.25) Philadelphia, PA [TBD]", "(MAR.25) Chicago, IL [TBD]",
            "(MAR.25) Chicago, IL [TBD]", "(MAR.26) Louisville, KY [TBD]",
            "(MAR.26) Anaheim, CA [TBD]", "(MAR.27) Philadelphia, PA [TBD]",
            "(MAR.27) Chicago, IL [TBD]", "(APR.2) Houston, TX [TBD]",
            "(APR.2) Houston, TX [TBD]", "(APR.4) Houston, TX [TBD]"};

    @Override
    public void migrate(DatabaseWrapper database) {
        Log.d(TAG, "Init Data...");
        populateGames();
        Log.d(TAG, "Data Initialized");
    }

    public void populateGames() {
        for (int i = 1; i <= 63; i++) {
            Game g = new Game();
            g.setGameId(i);
            g.setBracketId(1);
            g.setBracketRound(getRound(i));
            g.setBracketRegion(getRegion(i));
            g.setFinal(false);
            g.setTeamOne(TEAMS_ONE[(i - 1)]);
            g.setTeamOneScore(0);
            g.setTeamTwo(TEAMS_TWO[(i - 1)]);
            g.setTeamTwoScore(0);
            g.setGameDetails(GAMES_DETAIL[(i - 1)]);
            TransactionManager.getInstance().saveOnSaveQueue(g);
        }
    }

    private boolean isBetween(int gId, int low, int hi) {
        return low <= gId && gId <= hi;
    }

    private int getRegion(int gId) {

        int re;

        if (isBetween(gId, 1, 8) || isBetween(gId, 33, 36)
                || isBetween(gId, 49, 50) || gId == 57)
            re = 1; // 1 = south
        else if (isBetween(gId, 9, 16) || isBetween(gId, 37, 40)
                || isBetween(gId, 51, 52) || gId == 58)
            re = 2; // 2 = west
        else if (isBetween(gId, 17, 24) || isBetween(gId, 41, 44)
                || isBetween(gId, 53, 54) || gId == 59)
            re = 3; // 3 = east
        else if (isBetween(gId, 25, 32) || isBetween(gId, 45, 48)
                || isBetween(gId, 55, 56) || gId == 60)
            re = 4; // 4 = midwest
        else
            re = 0; // 5 = final four

        return re;
    }

    private int getRound(int gId) {

        int ro;

        if (isBetween(gId, 1, 32))
            ro = 1;
        else if (isBetween(gId, 33, 48))
            ro = 2;
        else if (isBetween(gId, 49, 56))
            ro = 3;
        else if (isBetween(gId, 57, 60))
            ro = 4;
        else if (isBetween(gId, 61, 62))
            ro = 5;
        else if (gId == 63)
            ro = 6;
        else
            ro = -1;

        return ro;
    }

}