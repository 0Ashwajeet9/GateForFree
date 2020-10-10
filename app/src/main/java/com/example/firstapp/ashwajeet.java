package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ashwajeet extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button b4;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashwajeet);

        Intent inte=getIntent();
        final String text=inte.getStringExtra(Main2Activity.Extra_Text);
        b4=(Button)findViewById(R.id.button4);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.ytp);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(text);
               youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
      b4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
              b4.setVisibility(view.GONE);
          }
      });


    }
}
