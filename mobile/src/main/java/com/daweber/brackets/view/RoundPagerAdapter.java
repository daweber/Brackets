package com.daweber.brackets.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.daweber.brackets.view.fragment.RoundFragment;

/**
 * Round Pager Adapter class
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
        return 6;
        //TODO: Once bracket creation is added, this needs to be grabbed from Bracket Model
        //TODO: That reminds me, create Bracket Model interface
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //TODO: Can change to get gameCount (TODO: create gameCount) and/or get Bracket Details...
        switch (position) {
            case 0:
                return "ROUND OF 64";
            case 1:
                return "ROUND OF 32";
            case 2:
                return "ROUND OF 16";
            case 3:
                return "ROUND OF 8";
            case 4:
                return "ROUND OF 4";
            case 5:
                return "CHAMPIONSHIP";
        }
        return null;
    }
}