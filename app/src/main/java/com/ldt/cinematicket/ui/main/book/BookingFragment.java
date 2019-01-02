package com.ldt.cinematicket.ui.main.book;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ldt.cinematicket.model.Movie;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.PresentStyle;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;
import com.ldt.cinematicket.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookingFragment extends SupportFragment {
    private static final String TAG="BookingFragment";

    public static BookingFragment newInstance(Movie movie) {
        BookingFragment bf = new BookingFragment();
        bf.mMovie = movie;
        return bf;
    }

    Movie mMovie;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.movie_panel) View mMoviePanel;
    @BindView(R.id.image) ImageView mImage;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.genre) TextView mGenre;
    @BindView(R.id.duration) TextView mDuration;
    @BindView(R.id.rate) TextView mRate;
    @BindView(R.id.next) View mNext;

    @BindView(R.id.date_recycler_view)
    RecyclerView mDateRecyclerView;

    @BindView(R.id.cinema_recycle_view)
    RecyclerView mCinemaRecyclerView;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;

    @BindView(R.id.error) TextView mError;

    @Override
    public int getPresentTransition() {
        return PresentStyle.SLIDE_LEFT;
    }

    private void setupToolbar() {
        if(getActivity() instanceof AppCompatActivity) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (ab != null) {
                ab.setDisplayShowTitleEnabled(false);
                ab.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Nullable
    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.booking_v2,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        setupToolbar();
        bindMovie();
        mSwipeLayout.setOnRefreshListener(this::searchForAllCinema);
        searchForAllCinema();
    }

    @SuppressLint("DefaultLocale")
    private void bindMovie() {
        if(mMovie==null) return;
        mTitle.setText(mMovie.getTitle());
        mGenre.setText(mMovie.getGenre());
        mDuration.setText(String.format("%d min", mMovie.getDuration()));
        mRate.setText(String.format("%s", mMovie.getRate()));

        RequestOptions requestOptions = new RequestOptions();
        if(getContext()!=null) {
            Glide.with(getContext())
                    .load(mMovie.getImageUrl())
                    .apply(requestOptions)
                    .into(mImage);
        }
    }

    @OnClick(R.id.movie_panel)
    void goToMovieDetail(){
        if(mMovie!=null) {
            getMainActivity().presentFragment(MovieDetail.newInstance(mMovie));
        }
    }
    void searchForAllCinema() {
        mSwipeLayout.setRefreshing(true);
        if(mMovie==null) {
          mSwipeLayout.setRefreshing(false);
          mError.setVisibility(View.VISIBLE);
        } else {
            mSwipeLayout.setRefreshing(false);
            mError.setVisibility(View.VISIBLE);
            //TODO: Search All Cinema
        }
    }
}
