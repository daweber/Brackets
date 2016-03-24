package com.daweber.brackets.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daweber.brackets.R;
import com.daweber.brackets.view.RoundPagerAdapter;
import com.daweber.brackets.vo.Pick;

import java.util.UUID;

/**
 * Bracket Activity Class
 */
public class BracketActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "b64.BracketActivity";

    private final static Boolean LOCKED = true;
    private final static Boolean UNLOCKED = false;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private RoundPagerAdapter mRoundPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager roundPager;

    private Menu menu;
    private Boolean lockStatus;

    //TODO: convert to SharedPref.
    private int psID = 1;
    private int bId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreating...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);

        // Replace with real locked status of PickSet
        lockStatus = UNLOCKED;

        //TODO: The whole toolbar "situation" needs to be reviewed
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setElevation(0);
            mActionBar.setLogo(R.mipmap.ic_launcher);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
        }

        mRoundPagerAdapter = new RoundPagerAdapter(getFragmentManager());
        roundPager = (ViewPager) findViewById(R.id.container);
        roundPager.setAdapter(mRoundPagerAdapter);

        PagerTitleStrip weekPagerTitle =
                (PagerTitleStrip) findViewById(R.id.round_pager_title_strip);
        weekPagerTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

        Button pickBracketButton = (Button) findViewById(R.id.toolbarBracketButton);
        if (pickBracketButton != null) {
            pickBracketButton.setOnClickListener(this);
        }

        Button pickPicksButtons = (Button) findViewById(R.id.toolbarPicksButton);
        if (pickPicksButtons != null) {
            pickPicksButtons.setOnClickListener(this);
        }

        FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.toolbarCreatePicksetFab);
        if (mFab != null) {
            mFab.setOnClickListener(this);
        }

        //Log.d(TAG, "OnCreated");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbarPicksButton:
                Toast.makeText(this, "Select Picks", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbarBracketButton:
                Toast.makeText(this, "Select Bracket", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbarCreatePicksetFab:
                Toast.makeText(this, "Create Pickset", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_print:
                Toast.makeText(this, "print PDF coming soon", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_share:
                Toast.makeText(this, "share Bracket coming soon", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_lock_toggle:
                toggleActionBarLock(item);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toggleActionBarLock(MenuItem item) {
        //TODO: non-picked team grayed out when unlocked; plus, best pattern to enfore auto-lock?
        if (lockStatus) {
            item.setIcon(getResources().getDrawable(R.drawable.ic_unlocked_white));
            lockStatus = UNLOCKED;
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.ic_locked_red));
            lockStatus = LOCKED;
        }
    }

    public static void setPicked(int game, int pick) {
        //TODO: set picked team
        Log.d(TAG, "Set game " + game + " winner to number " + pick);
    }

    public static void createPickset(int bracket) {
        //TODO: create set of picks for given bracket
    }
}
