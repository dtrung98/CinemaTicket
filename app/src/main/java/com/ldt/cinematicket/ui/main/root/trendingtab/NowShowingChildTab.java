package com.ldt.cinematicket.ui.main.root.trendingtab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.ldt.cinematicket.R;


import butterknife.BindView;
import butterknife.ButterKnife;

import com.ldt.cinematicket.data.DataFilm;
import com.ldt.cinematicket.data.LoadStringFromUrlAsyncTask;
import com.ldt.cinematicket.ui.main.MainActivity;
import com.ldt.cinematicket.ui.main.book.MovieDetail;
import com.ldt.cinematicket.ui.main.root.DataAdapter;

import java.util.ArrayList;
import java.util.List;

public class NowShowingChildTab extends Fragment implements LoadStringFromUrlAsyncTask.OnLoadStringUrlListener{
    View view;

    //@BindView(R.id.edit_text)
    EditText mEditText;
    RecyclerView recyclerView;

    //@BindView(R.id.button)
    Button button;

    public static NowShowingChildTab newInstance() {
        NowShowingChildTab fragment = new NowShowingChildTab();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.now_showing,container,false);
        initView();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        new LoadStringFromUrlAsyncTask(this).execute("https://www.imdb.com/movies-in-theaters/?ref_=cs_inth");

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)NowShowingChildTab.this.getActivity()).getSupportFragmentManager().beginTransaction().add(R.id.container,MovieDetail.newInstance(null)).commit();
            }
        });*/
    }

    @Override
    public void onLoadComplete(String url, String content) {
        if(mEditText==null) return;
        mEditText.setText(content);
    }

    public void initView(){
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        List<DataFilm> arrayList = new ArrayList<>();
        arrayList.add(new DataFilm(R.drawable.despicable_3,"Despicable 3","3D","IMAX","Kyle Balba","Steve Carell/Kisten Wiig",9.8));
        arrayList.add(new DataFilm(R.drawable.a_silent_voice,"A Silent Voice","2D", "IMAX","Naoko Yamada","Miyu Irino/Saori Hayami",10.0));
        arrayList.add(new DataFilm(R.drawable.iron_man_3,"Iron Man 3","2D","IMAX","Shane Black","Robert Downey Jr.",9.5));
        arrayList.add(new DataFilm(R.drawable.zootopia,"Zootopia","3D","IMAX","Byron Howard","Ginnifer Goodwin/Jason",9.7));
        arrayList.add(new DataFilm(R.drawable.despicable_3,"Despicable 3","3D","IMAX","Nguyễn Khương Trực","Nguyễn Khương Trực",9.8));
        DataAdapter adapter = new DataAdapter(arrayList,getContext());
        recyclerView.setAdapter(adapter);
    }
}
