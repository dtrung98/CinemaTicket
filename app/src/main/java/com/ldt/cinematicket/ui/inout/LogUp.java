package com.ldt.cinematicket.ui.inout;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;

public class LogUp extends SupportFragment {
    public static LogUp newInstance() {

        return new LogUp();
    }

    @Nullable
    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.user_log_up,container,false);
    }
}
