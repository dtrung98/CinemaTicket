package com.ldt.cinematicket.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.ldt.cinematicket.BitmapEditor;
import com.ldt.cinematicket.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;
    private View root;
    private ImageView imageView;
private View showTimeTextView,time2,time3,time4;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.main_fragment, container, false);
        toolbar = root.findViewById(R.id.toolbar);
        showTimeTextView = root.findViewById(R.id.show_time_textView);
        time2= root.findViewById(R.id.time_2);
        time3 = root.findViewById(R.id.time_3);
        time4 = root.findViewById(R.id.time_4);
        showTimeTextView.setOnClickListener(this);
        time2.setOnClickListener(this);
        time3.setOnClickListener(this);
        time4.setOnClickListener(this);
        imageView = root.findViewById(R.id.imageView3);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.madagasca);

        Bitmap new2 = BitmapEditor.getMyCustomRoundedBitmap(bitmap, (int)bitmap.getWidth()/16);

       // Bitmap ret =  BitmapEditor.GetRoundedBitmapWithBlurShadow(getActivity(), new2, 30, 30, 30, 30, -6, 180, 12, 2);
        //new2.recycle();

       // newBitmap =BitmapEditor.GetRoundedBitmapWithBlurShadow(bitmap,5,5,5,5);
        imageView.setImageBitmap(new2);
        return root;
    }
    Toolbar toolbar;
    private void setupToolbar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    public void ShowTimeViewOnClick(View view) {
    }

    @Override
    public void onClick(View view) {
getActivity().getSupportFragmentManager().beginTransaction()
        .add(R.id.container, ChooseSeat.createInstance((TextView) view))
        .commitNow();
    }
}
