package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView res;
    private static final long Victory_delay=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.result);
        TextView p1wins = findViewById(R.id.player1wins);
        TextView p2wins = findViewById(R.id.player2wins);
        String text=getIntent().getStringExtra("textKey");
        int wins1 =getIntent().getIntExtra("winsplayer1",0);
        int wins2 =getIntent().getIntExtra("winsplayer2",0);

        resultTextView.setText(text);
        p1wins.setText(String.valueOf(wins1));
        p2wins.setText(String.valueOf(wins2));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent game = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(game);
                finish();
            }
        },Victory_delay);
    }
}