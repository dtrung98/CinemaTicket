package com.ldt.cinematicket.ui.main;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.ldt.cinematicket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment implements View.OnClickListener {


    public SignIn() {
        // Required empty public constructor
    }

    private View view;
    private View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root  = inflater.inflate(R.layout.fragment_sign_in, container, false);
        view = root.findViewById(R.id.btn_sign_in);
        view.setOnClickListener(this);
        return root;
    }
    public static SignIn newInstance() {
        return new SignIn();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sign_in) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
