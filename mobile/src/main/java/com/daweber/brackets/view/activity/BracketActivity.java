package com.daweber.brackets.view.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daweber.brackets.R;
import com.daweber.brackets.view.GameListAdapter;
import com.daweber.brackets.vo.Game;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreating");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);

        // Testing DB Migration/Init
//        Insert.into(Game.class).columns(
//                Game$Table.GID,
//                Game$Table.BID,
//                Game$Table.BROUND,
//                Game$Table.ISFINAL,
//                Game$Table.TONE,
//                Game$Table.TONESCORE,
//                Game$Table.TTWO,
//                Game$Table.TTWOSCORE,
//                Game$Table.GDETAILS)
//                .values(1, 1, 1, false,
//                        "University of Illinois", 78,
//                        "Marquette University", 81,
//                        "Bradley Center (Milwaukee, WI)").query();
//        Log.d(TAG, "Data says: " +
//                new Select().from(Game.class).querySingle().tOne + " will win!");

        // Replace with real locked status of PickSet
        lockStatus = UNLOCKED;

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
                Toast.makeText(this, "Create Pickset", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class RoundFragment extends Fragment {
        private static final String TAG = "b64.RoundFragment";

        private static final String ARG_ROUND_NUMBER = "round_number";
        private int roundNumber;

        public RoundFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static RoundFragment newInstance(int round) {
            RoundFragment fragment = new RoundFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_ROUND_NUMBER, round);
            fragment.roundNumber = round;
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_list, container, false);

            RecyclerView roundList = (RecyclerView) rootView.findViewById(R.id.games_list);
            roundList.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(rootView.getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            roundList.setLayoutManager(llm);

            GameListAdapter ga = new GameListAdapter(container.getContext(), getRoundList(roundNumber));
            roundList.setAdapter(ga);

            return rootView;
        }

        //TODO: This should go get the real gamesList from local database
        private List<Game> getRoundList(int round) {

            List<Game> result = new ArrayList<>();

            int size;

            switch (round) {
                case 1:
                    size = 4;
                    break;
                case 2:
                    size = 32;
                    break;
                case 3:
                    size = 16;
                    break;
                case 4:
                    size = 8;
                    break;
                case 5:
                    size = 4;
                    break;
                case 6:
                    size = 2;
                    break;
                case 7:
                    size = 1;
                    break;
                default:
                    size = 3;
                    break;
            }

            for (int i = 1; i <= size; i++) {
                Game g = new Game();
                g.isFinal = (i % 2) == 0;
                g.tOne = Game.TEAM_ONE_PREFIX + i;
                g.tTwo = Game.TEAM_TWO_PREFIX + i;
                result.add(g);
            }
            return result;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class RoundPagerAdapter extends FragmentPagerAdapter {
        private final static String TAG = "b64.RoundPagerAdapter";

        public RoundPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return RoundFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PLAY IN";
                case 1:
                    return "ROUND OF 64";
                case 2:
                    return "ROUND OF 32";
                case 3:
                    return "ROUND OF 16";
                case 4:
                    return "ROUND OF 8";
                case 5:
                    return "ROUND OF 4";
                case 6:
                    return "CHAMPIONSHIP";
            }
            return null;
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
        if (lockStatus) {
            item.setIcon(getResources().getDrawable(R.drawable.ic_unlocked_white));
            lockStatus = UNLOCKED;
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.ic_locked_red));
            lockStatus = LOCKED;
        }
    }
}
