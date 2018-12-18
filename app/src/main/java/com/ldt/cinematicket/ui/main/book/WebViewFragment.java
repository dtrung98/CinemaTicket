package com.ldt.cinematicket.ui.main.book;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.PresentStyle;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewFragment extends SupportFragment {
    @BindView(R.id.web)
    WebView mWebView;
    private String mURL;

    public static WebViewFragment newInstance(String url) {
     WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.mURL = url;
        return webViewFragment;

    }

    @Nullable
    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.web_view,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        //https://youtu.be/iMbzy-_LPqw
        String myVideoYoutubeId;
        myVideoYoutubeId =mURL.replace("https://youtu.be/","");
        mIsPaused = true;
        mWebView.loadUrl("https://www.youtube.com/embed/" + myVideoYoutubeId);
    }
    private boolean mIsPaused = false;

    @Override
    public void onResume() {
        super.onResume();
        if (mIsPaused)
        {
            // resume flash and javascript etc
            callHiddenWebViewMethod(mWebView, "onResume");
            mWebView.resumeTimers();
            mIsPaused = false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (!mIsPaused)
        {
            // pause flash and javascript etc
            callHiddenWebViewMethod(mWebView, "onPause");
            mWebView.pauseTimers();
            mIsPaused = true;
        }
    }
    private void callHiddenWebViewMethod(final WebView wv, final String name)
    {
        try
        {
            final Method method = WebView.class.getMethod(name);
            method.invoke(mWebView);
        } catch (final Exception e)
        {}
    }

    @Override
    public int getPresentTransition() {
        return PresentStyle.SCALEXY;
    }
}
