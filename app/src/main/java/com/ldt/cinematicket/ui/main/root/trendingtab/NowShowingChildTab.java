package com.ldt.cinematicket.ui.main.root.trendingtab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ldt.cinematicket.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import com.ldt.cinematicket.data.LoadStringFromUrlAsyncTask;
import com.ldt.cinematicket.ui.main.MainActivity;
import com.ldt.cinematicket.ui.main.book.BookingFragment;
import com.ldt.cinematicket.ui.main.book.MovieDetail;

public class NowShowingChildTab extends Fragment implements LoadStringFromUrlAsyncTask.OnLoadStringUrlListener {
    @BindView(R.id.edit_text)
    EditText mEditText;

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

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
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        new LoadStringFromUrlAsyncTask(this).execute("https://www.imdb.com/movies-in-theaters/?ref_=cs_inth");

        button.setOnClickListener(new View.OnClickListener() {
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
        });
    }

    @Override
    public void onLoadComplete(String url, String content) {
        if(mEditText==null) return;
        mEditText.setText(content);
    }
}
