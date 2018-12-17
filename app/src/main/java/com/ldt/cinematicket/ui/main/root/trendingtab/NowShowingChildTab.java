package com.ldt.cinematicket.ui.main.root.trendingtab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldt.cinematicket.R;


import butterknife.BindView;
import butterknife.ButterKnife;

import com.ldt.cinematicket.data.DataFilm;

import java.util.ArrayList;
import java.util.List;

public class NowShowingChildTab extends Fragment {
    private static final String TAG ="NowShowingChildTab";


    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    public static NowShowingChildTab newInstance() {
        NowShowingChildTab fragment = new NowShowingChildTab();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.now_showing,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        initView();

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)NowShowingChildTab.this.getActivity()).presentFragment(MovieDetail.newInstance(null));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)NowShowingChildTab.this.getActivity()).presentFragment(BookingFragment.newInstance());
            }
        });*/
    }

    public void initView(){
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        List<DataFilm> arrayList = new ArrayList<>();
        arrayList.add(new DataFilm(R.drawable.despicable_3,"Despicable 3","3D","IMAX","Kyle Balba","Steve Carell/Kisten Wiig",9.8));
        arrayList.add(new DataFilm(R.drawable.a_silent_voice,"A Silent Voice","2D", "IMAX","Naoko Yamada","Miyu Irino/Saori Hayami",10.0));
        arrayList.add(new DataFilm(R.drawable.iron_man_3,"Iron Man 3","2D","IMAX","Shane Black","Robert Downey Jr.",9.5));
        arrayList.add(new DataFilm(R.drawable.zootopia,"Zootopia","3D","IMAX","Byron Howard","Ginnifer Goodwin/Jason",9.7));
        arrayList.add(new DataFilm(R.drawable.despicable_3,"Despicable 3","3D","IMAX","Nguyễn Khương Trực","Nguyễn Khương Trực",9.8));
        DataAdapter adapter = new DataAdapter(arrayList,getActivity());
        mRecyclerView.setAdapter(adapter);
    }
}
