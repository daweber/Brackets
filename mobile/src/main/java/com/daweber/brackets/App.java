package com.daweber.brackets;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.daweber.brackets.model.BracketsDatabase;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Application class
 */
public class App extends Application {
    private static final String TAG = "b64.Application";
    private static final String KEY_DEFAULT_BRACKET = "default_bracket";
    private static final String KEY_DEFAULT_PICKSET = "default_pickset";

    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "OnCreating...");

        mSharedPreferences = getSharedPreferences("beta_cfg", MODE_PRIVATE);

        if (!mSharedPreferences.contains(KEY_DEFAULT_BRACKET)) {
            Log.d(TAG, "Setting Default Bracket pref");
            setDefaultBracket(1);
        }

        if (!mSharedPreferences.contains(KEY_DEFAULT_PICKSET)) {
            Log.d(TAG, "Setting Default Pickset pref");
            setDefaultPickset(1);
        }

        FlowManager.init(this);
        FlowManager.getDatabase(BracketsDatabase.NAME).getWritableDatabase();


        Log.d(TAG, "OnCreated!");
    }

    public int getDefaultBracket() {
        return mSharedPreferences.getInt(KEY_DEFAULT_BRACKET, 1);
    }

    public int getDefaultPickset() {
        return mSharedPreferences.getInt(KEY_DEFAULT_PICKSET, 1);
    }

    public void setDefaultBracket(int bracketId) {
        mSharedPreferences.edit().putInt(KEY_DEFAULT_BRACKET, bracketId).apply();
    }

    public void setDefaultPickset(int picksetId) {
        mSharedPreferences.edit().putInt(KEY_DEFAULT_PICKSET, picksetId).apply();
    }
}
