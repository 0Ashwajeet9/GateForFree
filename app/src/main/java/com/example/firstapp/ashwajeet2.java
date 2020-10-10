package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ashwajeet2 extends AppCompatActivity {
    Button b;
    DatePicker dt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashwajeet2);
        tv = (TextView) findViewById(R.id.textView3);
        dt = (DatePicker) findViewById(R.id.datePicker);
        b = (Button) findViewById(R.id.button2);

        tv.setText("Current Date :" + getCurrentDate());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Current Date :" + getCurrentDate());
            }
        });


    }

    public String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        builder.append(dt.getMonth() + 1 + "/");
        builder.append(dt.getDayOfMonth() + "/");
        builder.append(dt.getYear() + " ");
        return builder.toString();
    }
}