package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class Start extends AppCompatActivity {

    private static final long Start_delay=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // Reset the score (wins) here
        int wins1 = 0;
        int wins2 = 0;

        // Update the SharedPreferences to store the new score
        SharedPreferences sharedPreferences = getSharedPreferences("Wins", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("winsplayer1", wins1);
        editor.putInt("winsplayer2", wins2);
        editor.apply();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent game = new Intent(Start.this,MainActivity.class);
                startActivity(game);
                finish();
            }
        },Start_delay);
    }

}