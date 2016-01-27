package com.daweber.brackets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GameAlert extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_alert);
        mTextView = (TextView) findViewById(R.id.text);
    }
}
