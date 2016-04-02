package com.daweber.brackets.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daweber.brackets.App;
import com.daweber.brackets.R;
import com.daweber.brackets.view.PromptDialog;
import com.daweber.brackets.view.RoundPagerAdapter;
import com.daweber.brackets.vo.Bracket;
import com.daweber.brackets.vo.Bracket_Table;
import com.daweber.brackets.vo.Pick;
import com.daweber.brackets.vo.Pickset;
import com.daweber.brackets.vo.Pickset_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

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

    private int cPickset, cBracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreating...");

        setContentView(R.layout.activity_bracket);

        App mApp = (App) getApplication();

        cPickset = mApp.getDefaultPickset();

        cBracket = mApp.getDefaultBracket();

        Pickset ps = SQLite
                .select().from(Pickset.class)
                .where(Pickset_Table.picksetId.eq(cPickset))
                .querySingle();

        if (ps != null)
            lockStatus = ps.isLocked();
        else
            lockStatus = UNLOCKED;

        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setElevation(0);
            mActionBar.setLogo(R.mipmap.ic_launcher);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
        }//TODO: The whole toolbar "situation" needs to be reviewed, Add Base Activity

        mRoundPagerAdapter = new RoundPagerAdapter(getFragmentManager());
        roundPager = (ViewPager) findViewById(R.id.container);
        roundPager.setAdapter(mRoundPagerAdapter);

        PagerTitleStrip weekPagerTitle =
                (PagerTitleStrip) findViewById(R.id.round_pager_title_strip);
        weekPagerTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

        Button pickBracketButton = (Button) findViewById(R.id.toolbarBracketButton);
        if (pickBracketButton != null) {
            Bracket b = SQLite.select()
                    .from(Bracket.class)
                    .where(Bracket_Table.bracketId.eq(cBracket)).querySingle();
            if (b != null)
                pickBracketButton.setText(b.getBracketName());
            else
                pickBracketButton.setText("DNE");
            pickBracketButton.setOnClickListener(this);
        }

        Button pickPicksetButton = (Button) findViewById(R.id.toolbarPicksButton);
        if (pickPicksetButton != null) {
            if (ps != null)
                pickPicksetButton.setText(ps.getPicksetName());
            else
                pickPicksetButton.setText("DNE");
            pickPicksetButton.setOnClickListener(this);
        }

        FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.toolbarCreatePicksetFab);
        if (mFab != null) {
            mFab.setOnClickListener(this);
        }

        Log.d(TAG, "OnCreated");
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
                PromptDialog dlg = new PromptDialog(this, R.string.title, R.string.enter_comment) {
                    @Override
                    public boolean onOkClicked(String input) {
                        createPickset(1, input);
                        return true; // true = close dialog
                    }
                };
                dlg.show();
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
                getTest();
                //Toast.makeText(this, "share Bracket coming soon", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_lock_toggle:
                toggleActionBarLock(item);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getTest() {
        RelativeLayout linearLayout = new RelativeLayout(this);
        final NumberPicker aNumberPicker = new NumberPicker(this);
        aNumberPicker.setMaxValue(1);
        aNumberPicker.setMinValue(1);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
        RelativeLayout.LayoutParams numPicerParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        numPicerParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        linearLayout.setLayoutParams(params);
        linearLayout.addView(aNumberPicker, numPicerParams);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Run Test...");
        alertDialogBuilder.setView(linearLayout);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                runTest(aNumberPicker.getValue());
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void runTest(int test) {
        switch (test) {
            case 1:
                Log.d(TAG, "Print Current Pickset:\n\n");

                break;
            default:
                break;
        }
    }

    private void toggleActionBarLock(MenuItem item) {
        //TODO: non-picked team grayed out when unlocked.
        if (lockStatus) {
            item.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_unlocked_white));
            lockStatus = UNLOCKED;
        } else {
            item.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_locked_red));
            lockStatus = LOCKED;
        }
    }

    public static void updatePicked(int pick, int pickset, int game, int winner) {
        Pick p = new Pick();
        p.setPickId(pick);
        p.setPicksetId(pickset);
        p.setGameId(game);
        p.setPickedWinner(winner);
        p.save();

        Log.d(TAG, "Pick " + pick + " | Game " + game + " | Pickset " + pickset + " set to " + winner);
    }

    public static void createPickset(int bracket, String name) {
        //TODO: create set of picks for given bracket
    }

    public int getcPickset() {
        return cPickset;
    }

    public void setcPickset(int cPickset) {
        this.cPickset = cPickset;
    }

    public int getcBracket() {
        return cBracket;
    }

    public void setcBracket(int cBracket) {
        this.cBracket = cBracket;
    }
}
