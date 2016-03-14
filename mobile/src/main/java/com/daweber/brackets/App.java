package com.daweber.brackets;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Application Class
 */
public class App extends Application {
    private static final String TAG = "b64.Application";

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
