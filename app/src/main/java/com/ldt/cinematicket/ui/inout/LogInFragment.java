package com.ldt.cinematicket.ui.inout;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.main.book.BookingFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment implements View.OnClickListener {
    private static final String TAG="LogInFragment";

    public LogInFragment() {
        // Required empty public constructor
    }

    private View view;
    private View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root  = inflater.inflate(R.layout.log_in, container, false);
        view = root.findViewById(R.id.btn_sign_in);
        view.setOnClickListener(this);
        return root;
    }
    public static LogInFragment newInstance() {
        return new LogInFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                ((LogInOutActivity)getActivity()).goToHomeScreen();
                break;
            case R.id.sign_up:
                break;
        }

    }
}
