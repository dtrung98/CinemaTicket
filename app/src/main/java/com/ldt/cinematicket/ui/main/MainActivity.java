package com.ldt.cinematicket.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.inout.AccountOptionFragment;
import com.ldt.cinematicket.ui.main.root.BottomPagerAdapter;
import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FragNavController mFNController;

    private TextView mTextMessage;
    BottomPagerAdapter mBottomAdapter;
    ViewPager mBottomPager;


    @Override
    public void onBackPressed() {
        if(!mFNController.isRootFragment()) mFNController.popFragment();
        else
            super.onBackPressed();
    }
    public void pushFragment(Fragment fragment) {
        if(mFNController!=null) mFNController.pushFragment(fragment);
    }

    public void popFragment() {
        if(mFNController!=null) mFNController.popFragment();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_trending:
                    mBottomPager.setCurrentItem(0);
                    mTextMessage.setText(R.string.trending);
                    return true;
                case R.id.navigation_cinema:
                    mBottomPager.setCurrentItem(1);
                    mTextMessage.setText(R.string.cinema);
                    return true;
                case R.id.navigation_profile:
                    mBottomPager.setCurrentItem(2);
                    mTextMessage.setText(R.string.my_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mBottomPager = findViewById(R.id.bottom_view_pager);
        mTextMessage = findViewById(R.id.message);
        mBottomAdapter = new BottomPagerAdapter(this,getSupportFragmentManager());
        mBottomPager.setAdapter(mBottomAdapter);

        BottomNavigationView navigation =  findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initBackStack(savedInstanceState);
    }
    private void initBackStack(Bundle savedInstanceState) {
        mFNController = new FragNavController(getSupportFragmentManager(),R.id.container);
        ArrayList<Fragment> rootFragments = new ArrayList<>();
        rootFragments.add(AccountOptionFragment.newInstance());
        mFNController.setRootFragments(rootFragments);
        mFNController.initialize(0,savedInstanceState);
    }

}
