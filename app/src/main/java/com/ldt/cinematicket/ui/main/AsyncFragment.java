package com.ldt.cinematicket.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ldt.cinematicket.R;
public class AsyncFragment extends Fragment implements View.OnClickListener {

    public AsyncFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AsyncFragment newInstance() {
        AsyncFragment fragment = new AsyncFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_async, container, false);
    }
EditText editText;
    TextView textView;
    ProgressBar progressBar;
    Button button;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editText = view.findViewById(R.id.editText);
        textView = view.findViewById(R.id.text_percent);
        progressBar = view.findViewById(R.id.progress_horizontal);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);

    }
    public class customAsync extends AsyncTask<Integer,Integer,Void> {
        @Override
        protected Void doInBackground(Integer... integers) {
            for(int i=0;i<=toValue;i++) {

                this.publishProgress(new Integer[]{i});
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
        button.setEnabled(false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            button.setEnabled(true);
        }

        @Override
        protected void onProgressUpdate(Integer... integers) {
            Integer value = (Integer) integers[0];
            textView.setText(((int)(value/(toValue+0.0f)*100))+"%");
            progressBar.setProgress(value);
        }


    }
    Integer toValue;
    @Override
    public void onClick(View view) {
        toValue = Integer.valueOf(editText.getText().toString());
        progressBar.setMax(toValue);
       new customAsync().execute();
    }
}
