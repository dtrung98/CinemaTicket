package com.ldt.cinematicket.ui.main.root;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ldt.cinematicket.R;
import com.ldt.cinematicket.ui.main.MainActivity;
import com.ldt.cinematicket.ui.main.admin.DashBoard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class ProfileTab extends Fragment {
    private static final String TAG ="ProfileTab";
    Button btnSignout;
    FirebaseAuth mAuth;

    public static ProfileTab newInstance() {
        ProfileTab fragment = new ProfileTab();
        return fragment;
    }

    // Control Center
    @BindView(R.id.control_center_panel) View mControlCenterPanel;
    @BindView(R.id.control_center) View mControlCenter;
    @BindView(R.id.next_control_center) View mControlCenterNext;

    // Theme
    @BindView(R.id.theme_panel) View mThemePanel;
    @BindView(R.id.theme) View mTheme;
    @BindView(R.id.switch_theme) SwitchCompat mThemeSwitch;

    @BindView(R.id.avatar) ImageView mAvatarView;
    @BindView(R.id.user_id) TextView mDisplayName;
    @BindView(R.id.sign_in) FloatingActionButton mAddAccountButton;

    @OnClick(R.id.control_center_panel)
    void goToControlCenter() {
        ((MainActivity)getActivity()).presentFragment(DashBoard.newInstance());
    }

    @OnClick(R.id.theme_panel)
    void changeTheme() {
        mThemeSwitch.setChecked(!mThemeSwitch.isChecked());
    }

    @OnCheckedChanged(R.id.switch_theme)
    void updateTheme() {
        boolean isDark = mThemeSwitch.isChecked();
        Toast.makeText(getContext(),"Theme switched to "+((isDark)? "Dark Mode":"Light Mode"),Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.avatar,R.id.sign_in})
    void avatarClick() {
        Toast.makeText(getContext(),"Account management will be available soon.",Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_tab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        mAuth = FirebaseAuth.getInstance();
        getUserInfo();
    }

    private void getUserInfo(){
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            if(photoUrl == null){
                Glide.with(this)
                        .load(R.drawable.movie_pop_corn)
                        .into(mAvatarView);
            }
            else{
                Glide.with(this)
                        .load(Uri.parse(photoUrl.toString()))
                        .into(mAvatarView);
            }

            if(name == null){
                mDisplayName.setText(email);
            }
            else{
                mDisplayName.setText(name);
            }
        }
    }
}
