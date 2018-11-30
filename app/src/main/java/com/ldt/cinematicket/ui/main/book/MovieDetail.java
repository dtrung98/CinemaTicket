package com.ldt.cinematicket.ui.main.book;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.model.Movie;
import com.ldt.cinematicket.ui.main.MainActivity;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetail extends SupportFragment {
    private static final String TAG = "MovieDetail";
    /** Phim nguồn cần xem chi tiết */
    Movie mMovie;

    @BindView(R.id.back_button) View mBackButton;
    @BindView(R.id.rentButton) FloatingActionButton mBookNowButton;

    /**
     * Tạo Fragment Movie Detail để xem chi tiết một phim
     * @param movie Phim cần xem chi tiết
     * @return  Đối tượng MovieDetail
     */
    public static MovieDetail newInstance(Movie movie) {
        MovieDetail md = new MovieDetail();

        md.mMovie = movie;
        return md;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.movie_detail,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             getMainActivity().dismiss();
            }
        });
        mBookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().presentFragment(BookingFragment.newInstance());
            }
        });
    }
}
