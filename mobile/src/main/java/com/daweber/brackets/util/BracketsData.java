package com.daweber.brackets.util;

import android.util.Log;

import com.daweber.brackets.vo.Game;
import com.daweber.brackets.vo.Game$Table;
import com.raizlabs.android.dbflow.sql.language.Insert;

/**
 * Hard-coded Data (eventually data will be gotten from network call
 */
public class BracketsData {
    private static final String TAG = "b64.BracketsData";

    public BracketsData() {
        Log.d(TAG, "Constructed");
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
