package com.daweber.brackets;

import android.app.Application;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Application Class
 */
public class App extends Application {
    private static final String TAG = "b64.Application";

    @Override
    public void onCreate() {
        Log.d(TAG, "OnCreating");
        super.onCreate();
        FlowManager.init(this);
        Log.d(TAG, "OnCreated");
    }
}
