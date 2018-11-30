package com.ldt.cinematicket.ui.inout;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogIn extends SupportFragment implements View.OnClickListener {
    private static final String TAG="LogIn";

    public LogIn() {
        // Required empty public constructor
    }

    @BindView(R.id.btn_sign_in) View mSignIn;
    private View root;
    @BindView(R.id.sign_up) View mSignUp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.log_in, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);

        root = view;
        mSignIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);
    }

    public static LogIn newInstance() {
        return new LogIn();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                ((InOutActivity)getActivity()).goToHomeScreen();
                break;
            case R.id.sign_up:
                ((InOutActivity)getActivity()).presentFragment(LogUp.newInstance());
                break;
        }

    }
}
