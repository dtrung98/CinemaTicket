package com.ldt.cinematicket.ui.inout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LogUp extends SupportFragment implements View.OnClickListener{
    private static final String TAG="LogUp";
    private View root;

    public LogUp() {
        // Required empty public constructor
    }

    @BindView(R.id.edi_fullname) TextInputLayout ediFullname;
    @BindView(R.id.edi_email) TextInputLayout ediEmail;
    @BindView(R.id.edi_password) TextInputLayout ediPassword;
    @BindView(R.id.edi_retype) TextInputLayout ediRetype;
    @BindView(R.id.sign_in) View mSignIn;
    @BindView(R.id.btn_create) Button mCreate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.user_log_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);

        root = view;
        mSignIn.setOnClickListener(this);
        mCreate.setOnClickListener(this);

    }

    public static LogUp newInstance() {
        return new LogUp();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_create:
                signUp();
                ((InOutActivity)getActivity()).presentFragment(LogIn.newInstance());
                break;
            case R.id.sign_in:
                ((InOutActivity)getActivity()).presentFragment(LogIn.newInstance());
                break;
        }
    }

    private void signUp() {
        validateInfo();
        Toast.makeText(getContext(), R.string.signup_success,Toast.LENGTH_SHORT).show();
    }

    private void validateInfo() {

    }
}
