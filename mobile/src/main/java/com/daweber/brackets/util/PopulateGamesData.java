package com.daweber.brackets.util;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.daweber.brackets.model.BracketsDatabase;
import com.daweber.brackets.vo.Game;
import com.daweber.brackets.vo.Game$Table;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.language.Insert;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;

/**
 * Migration Class
 */
@Migration(version = 0, databaseName = BracketsDatabase.NAME)
public class PopulateGamesData extends BaseMigration {
    private static final String TAG = "b64.BracketsData";

    @Override
    public void migrate(SQLiteDatabase database) {
        Log.d(TAG, "Migrating Data...");
        //populateGames();
    }

    public void populateGames() {

        Insert.into(Game.class).columns(
                Game$Table.GID,
                Game$Table.BID,
                Game$Table.BROUND,
                Game$Table.ISFINAL,
                Game$Table.TONE,
                Game$Table.TONESCORE,
                Game$Table.TTWO,
                Game$Table.TTWOSCORE,
                Game$Table.GDETAILS)
                .values(1, 1, 1, false,
                        "University of Illinois", 78,
                        "Marquette University", 81,
                        "Bradley Center (Milwaukee, WI)").query();

    }
}