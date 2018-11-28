package com.ldt.cinematicket.ui.main.book;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.ldt.cinematicket.util.BitmapEditor;
import com.ldt.cinematicket.R;

public class BookingFragment extends Fragment implements View.OnClickListener {
    private static final String TAG="BookingFragment";


    private View root;
    private ImageView imageView;
private View showTimeTextView,time2,time3,time4;
private ImageView menu_view;
    public static BookingFragment newInstance() {
        return new BookingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.booking, container, false);
        toolbar = root.findViewById(R.id.toolbar);
        showTimeTextView = root.findViewById(R.id.show_time_textView);
        time2= root.findViewById(R.id.time_2);
        time3 = root.findViewById(R.id.time_3);
        time4 = root.findViewById(R.id.time_4);
        menu_view = root.findViewById(R.id.menu_view);
        Thread x_thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        x_thread.start();
        menu_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getActivity(),view);
                popupMenu.inflate(R.menu.my_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        String s;
                        switch (menuItem.getItemId()) {
                            case R.id.line1: s= "Line 1"; break;
                            case R.id.line2: s="Line 2";break;
                            case R.id.line3: s="Line 3";break;
                            default:s="Line 4";break;
                        }

                        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        showTimeTextView.setOnClickListener(this);
        time2.setOnClickListener(this);
        time3.setOnClickListener(this);
        time4.setOnClickListener(this);
        imageView = root.findViewById(R.id.imageView3);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.madagasca);

        Bitmap new2 = BitmapEditor.getMyCustomRoundedBitmap(bitmap, (int)bitmap.getWidth()/16);

       // Bitmap ret =  BitmapEditor.GetRoundedBitmapWithBlurShadow(getActivity(), new2, 30, 30, 30, 30, -6, 180, 12, 2);
        //new2.recycle();

       // newBitmap =BitmapEditor.GetRoundedBitmapWithBlurShadow(bitmap,5,5,5,5);
        imageView.setImageBitmap(new2);
        return root;
    }
    Toolbar toolbar;
    private void setupToolbar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         }

    public void ShowTimeViewOnClick(View view) {
    }

    @Override
    public void onClick(View view) {
getActivity().getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, ChooseSeat.createInstance((TextView) view))
        .addToBackStack(TAG)
        .commitNow();
    }
}
