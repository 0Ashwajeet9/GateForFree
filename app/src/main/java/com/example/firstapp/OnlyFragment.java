package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import static com.example.firstapp.bestpage.Low_me;

public class OnlyFragment extends Fragment {
    CardView c1,c2,c3,c4,c5,c6;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.fragment_only,container,false);
      c1=view.findViewById(R.id.cardview);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getContext(),Main4Activity.class);
                i1.putExtra(Low_me,"CSE");
               startActivity(i1);

            }
        });
        c2=view.findViewById(R.id.cardview1);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getContext(),Main4Activity.class);
                i1.putExtra(Low_me,"ECE");
                startActivity(i1);

            }
        });
        c3=view.findViewById(R.id.cardview2);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getContext(),Main4Activity.class);
                i1.putExtra(Low_me,"MEC");
                startActivity(i1);

            }
        });
        c4=view.findViewById(R.id.cardview3);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getContext(),Main4Activity.class);
                i1.putExtra(Low_me,"EE");
                startActivity(i1);

            }
        });
        c5=view.findViewById(R.id.cardview4);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getContext(),Main4Activity.class);
                i1.putExtra(Low_me,"CE");
                startActivity(i1);

            }
        });
        c6=view.findViewById(R.id.cardview5);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getContext(),Main4Activity.class);
                i1.putExtra(Low_me,"PROGRAM");
                startActivity(i1);

            }
        });
       return view;
    }
}
