package com.ldt.cinematicket.ui.main.root;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.main.root.trendingtab.TrendingTab;

public class BottomPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private Context mContext;

    public BottomPagerAdapter(Context context,FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show Trending Fragment
                return TrendingTab.newInstance();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return CinemaTab.newInstance();
            case 2: // Fragment # 1 - This will show SecondFragment
                return ProfileTab.newInstance();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return mContext.getResources().getString(R.string.trending);
            case 1: return mContext.getResources().getString(R.string.cinema);
            case 2: return mContext.getResources().getString(R.string.my_profile);
            default:return null;
        }

}
}
