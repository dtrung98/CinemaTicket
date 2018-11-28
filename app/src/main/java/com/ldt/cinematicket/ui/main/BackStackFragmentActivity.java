package com.ldt.cinematicket.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.inout.AccountOptionFragment;
import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;

public abstract class BackStackFragmentActivity extends AppCompatActivity {
    private FragNavController mFNController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFNController = new FragNavController(getSupportFragmentManager(),R.id.container);
        ArrayList<Fragment> rootFragments = new ArrayList<>();
        rootFragments.add(AccountOptionFragment.newInstance());
        mFNController.setRootFragments(rootFragments);
        mFNController.initialize(0,savedInstanceState);
    }

}
