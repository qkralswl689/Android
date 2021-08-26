package org.techtown.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment2 extends Fragment /*implements MainActivity.onKeyBackPressedListener*/{
    MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
     /*   ((MainActivity)context).setmOnKeyBackPressedListener(this::onBackKey);*/
    }

    @Override
    public void onDetach() {
        super.onDetach();

        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_2,container,false);

        Button button = (Button) rootView.findViewById(R.id.fragment1);
        if(button != null){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onFragmentChange(0);
                }
            });
        }



        Button button2 = (Button) rootView.findViewById(R.id.fragment3);
        if(button2 != null){
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onFragmentChange(2);
                }
            });

        }

        return rootView;
    }
/*
    @Override
    public void onBackKey() {
        MainActivity activity = (MainActivity) getActivity();
        activity.setmOnKeyBackPressedListener(null);
        activity.onBackPressed();
    }*/
}