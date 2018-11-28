package com.ldt.cinematicket.ui.main.root.trendingtab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldt.cinematicket.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeChildTab extends Fragment{

    public static HomeChildTab newInstance() {
        HomeChildTab hct = new HomeChildTab();
        return hct;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_child_tab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  ButterKnife.bind(this,view);
    }
}
