package com.ldt.cinematicket.ui.inout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.main.HomeActivity;
import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;

public class LogInOutActivity extends AppCompatActivity {
    private FragNavController mFNController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_out_activity);

        mFNController = new FragNavController(getSupportFragmentManager(),R.id.container);

        ArrayList<Fragment> rootFragments = new ArrayList<>();
        rootFragments.add(AccountOptionFragment.newInstance());
        mFNController.setRootFragments(rootFragments);
        mFNController.initialize(0,savedInstanceState);
        mFNController.pushFragment(LogInFragment.newInstance());

    }

    @Override
    public void onBackPressed() {
        if(!mFNController.isRootFragment()) mFNController.popFragment();
        else
        super.onBackPressed();
    }
    public void goToHomeScreen() {
        Intent intent = new Intent(this,HomeActivity.class);
        finish();
        startActivity(intent);
    }
}
