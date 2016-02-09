package com.daweber.brackets;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class Bracket extends AppCompatActivity {
    private final static String TAG = "b64.ListActivity";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreated");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle("NCAA 64");
            mActionBar.setLogo(R.mipmap.ic_launcher);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
        }
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        PagerTitleStrip weekPagerTitle =
                (PagerTitleStrip) findViewById(R.id.round_pager_title_strip);
        weekPagerTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class RoundListFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_ROUND_NUMBER = "round_number";
        private static int ROUND_NUMBER;

        public RoundListFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static RoundListFragment newInstance(int round) {
            ROUND_NUMBER = round;
            RoundListFragment fragment = new RoundListFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_ROUND_NUMBER, round);
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

            GameListAdapter ga = new GameListAdapter(createList(ROUND_NUMBER));
            roundList.setAdapter(ga);

            return rootView;
        }

        private List<Game> createList(int round) {
            List<Game> result = new ArrayList<Game>();

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
                    size = 0;
                    break;
            }

            for (int i = 1; i <= size; i++) {
                Game g = new Game();
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
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return RoundListFragment.newInstance(position + 1);
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
}
