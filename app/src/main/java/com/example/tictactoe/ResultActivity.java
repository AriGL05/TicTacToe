package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView res;
    private static final long Victory_delay=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.result);
        String text=getIntent().getStringExtra("textKey");

        resultTextView.setText(text);
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