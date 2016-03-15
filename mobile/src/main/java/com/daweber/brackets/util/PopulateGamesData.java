package com.daweber.brackets.util;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.daweber.brackets.model.BracketsDatabase;
import com.daweber.brackets.vo.Game;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;

/**
 * Migration Class
 */
@Migration(version = 0, databaseName = BracketsDatabase.NAME)
public class PopulateGamesData extends BaseMigration {
    private static final String TAG = "b64.BracketsData";

    @Override
    public void migrate(SQLiteDatabase database) {
        Log.d(TAG, "Init Data...");
        populateGames(database);
        Log.d(TAG, "Data Initialized");
    }

    public void populateGames(SQLiteDatabase database) {
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