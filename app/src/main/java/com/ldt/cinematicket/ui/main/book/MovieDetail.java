package com.ldt.cinematicket.ui.main.book;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.model.Movie;

public class MovieDetail extends Fragment {
    private static final String TAG = "MovieDetail";
    /** Phim nguồn cần xem chi tiết */
    Movie mMovie;

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_detail,container,false);
    }
}
