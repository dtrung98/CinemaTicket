package com.ldt.cinematicket.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.main.root.BottomPagerAdapter;
import com.ldt.cinematicket.ui.main.root.FireBaseActivity;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.SupportFragment;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.FragmentNavigationController;
import com.ldt.cinematicket.ui.widget.fragmentnavigationcontroller.PresentStyle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FireBaseActivity  {
    private static final String TAG ="MainActivity";

    @BindView(R.id.message) TextView mTextMessage;

    BottomPagerAdapter mBottomAdapter;

    @BindView(R.id.bottom_view_pager)
    ViewPager mBottomPager;
//    @BindView(R.id.bottom_view_pager)
//    FrameLayout mContainer;

   FragmentNavigationController mNavigationController;

    @Override
    public void onBackPressed() {
        if(mNavigationController.getTopFragment().isReadyToDismiss())
        if(!(isNavigationControllerInit() && mNavigationController.dismissFragment(true)))
            super.onBackPressed();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_trending:
                    mBottomPager.setCurrentItem(0);
                  //  replaceFragment(mBottomAdapter.getItem(0),mBottomAdapter.getPageTitle(0).toString());
                    mTextMessage.setText(R.string.trending);
                    return true;
                case R.id.navigation_cinema:
                    mBottomPager.setCurrentItem(1);
                   // replaceFragment(mBottomAdapter.getItem(1),mBottomAdapter.getPageTitle(1).toString());
                    mTextMessage.setText(R.string.cinema);
                    return true;
                case R.id.navigation_profile:
                    mBottomPager.setCurrentItem(2);
                  //  replaceFragment(mBottomAdapter.getItem(2),mBottomAdapter.getPageTitle(2).toString());
                    mTextMessage.setText(R.string.my_profile);
                    return true;
            }
            return false;
        }
    };
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                dismiss();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        mBottomAdapter = new BottomPagerAdapter(this,getSupportFragmentManager());
        mBottomPager.setAdapter(mBottomAdapter);

        BottomNavigationView navigation =  findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initBackStack(savedInstanceState);
    }
    public static int PRESENT_STYLE_DEFAULT = PresentStyle.ACCORDION_LEFT;


    private void initBackStack(Bundle savedInstanceState) {
        FragmentManager fm = getSupportFragmentManager();
        mNavigationController = FragmentNavigationController.navigationController(fm, R.id.container);
        mNavigationController.setPresentStyle(PRESENT_STYLE_DEFAULT);
        mNavigationController.setDuration(250);
        mNavigationController.setInterpolator(new AccelerateDecelerateInterpolator());
      //if(savedInstanceState==null) {

          mNavigationController.presentFragment(new MainFragment());

     // } else {

//          mNavigationController = (FragmentNavigationController) fm.getFragment(savedInstanceState,"navigation-controller");
//          if(mNavigationController==null) Log.d(TAG, "initBackStack: found Navigation Controller");
//          else Log.d(TAG, "initBackStack: unable to get Navigation Controller");
     // }
    }
    private boolean isNavigationControllerInit() {
        return null!= mNavigationController;
    }
    public void presentFragment(SupportFragment fragment) {
        if(isNavigationControllerInit()) {
//            Random r = new Random();
//            mNavigationController.setPresentStyle(r.nextInt(39)+1); //exclude NONE present style
            mNavigationController.setPresentStyle(fragment.getPresentTransition());
              mNavigationController.presentFragment(fragment, true);

        }
    }
    public void dismiss() {
        if(isNavigationControllerInit()) {
            mNavigationController.dismissFragment();
        }
    }

    public void presentFragment(SupportFragment fragment, boolean animated) {
        if(isNavigationControllerInit()) {
            mNavigationController.presentFragment(fragment,animated);
        }
    }
    public void dismiss(boolean animated) {
        if(isNavigationControllerInit()) {
            mNavigationController.dismissFragment(animated);
        }
    }
    private void replaceFragment(Fragment newFragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.bottom_view_pager, newFragment, tag)
                .commit();

    }
}
