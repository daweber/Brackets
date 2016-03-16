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

    @Override
    public void migrate(DatabaseWrapper database) {
        Log.d(TAG, "Init Data...");
        populateGames();
        Log.d(TAG, "Data Initialized");
    }

    public void populateGames() {
        Game g = new Game();
        g.setgID(1);
        g.setbID(1);
        g.setbRound(1);
        g.setFinal(false);
        g.settOne("University of Illinois");
        g.settOneScore(78);
        g.settTwo("Marquette University");
        g.settTwoScore(81);
        g.setgDetails("Bradley Center (Milwaukee, WI)");

        TransactionManager.getInstance().saveOnSaveQueue(g);
    }


}