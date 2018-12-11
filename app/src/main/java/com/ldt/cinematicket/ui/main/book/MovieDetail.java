package com.ldt.cinematicket.ui.main.book;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.data.DataFilm;
import com.ldt.cinematicket.model.Movie;
import com.ldt.cinematicket.ui.main.MainActivity;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieDetail extends SupportFragment {
    private static final String TAG = "MovieDetail";
    /** Phim nguồn cần xem chi tiết */
    DataFilm mMovie;

    @BindView(R.id.back_image_view) ImageView mBackImageView;
    @BindView(R.id.avatar) ImageView mAvatarImageView;
    @BindView(R.id.title) TextView mTitleTextView;
    @BindView(R.id.description) TextView mDescriptionTextView;

    @BindView(R.id.content_text_view) TextView mContentTextView;
    @BindView(R.id.category) TextView mCategoryTextView;
    @BindView(R.id.release) TextView mReleaseTextView;
    @BindView(R.id.director) TextView mDirectorTextView;
    @BindView(R.id.cast) TextView mCastTextView;


    @BindView(R.id.back_button) View mBackButton;
    @BindView(R.id.rentButton) FloatingActionButton mBookNowButton;

    @OnClick(R.id.rentButton)
    void doSomething() {
        String video_url ="https://m.imdb.com";
        getMainActivity().presentFragment(WebViewFragment.newInstance(video_url));
    }

    @OnClick(R.id.back_button) void dismiss() {
        getMainActivity().dismiss();
    }

    /**
     * Tạo Fragment Movie Detail để xem chi tiết một phim
     * @param movie Phim cần xem chi tiết
     * @return  Đối tượng MovieDetail
     */
    public static MovieDetail newInstance(DataFilm movie) {
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

        bind(mMovie);
    }
    private void bind(DataFilm dataFilm) {
        if(dataFilm!=null) {
            mAvatarImageView.setImageResource(dataFilm.getImage());
            mBackImageView.setImageResource(dataFilm.getImage());

            mTitleTextView.setText(dataFilm.getName());

            mCastTextView.setText(dataFilm.getActors());
            mCategoryTextView.setText(dataFilm.getShowingType());
            mDirectorTextView.setText(dataFilm.getDirector());
        }
    }
}
