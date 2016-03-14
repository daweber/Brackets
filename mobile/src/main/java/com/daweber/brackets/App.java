package com.daweber.brackets;

import android.app.Application;
import android.util.Log;

import com.daweber.brackets.util.BracketsData;
import com.daweber.brackets.vo.Game;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Select;

/**
 * Application Class
 */
public class App extends Application {
    private static final String TAG = "b64.Application";

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        Log.d(TAG, "OnCreated");
        BracketsData create = new BracketsData();
        Log.d(TAG, create.toString() + " created with " + new Select().from(Game.class).querySingle().tOne);
    }
}
