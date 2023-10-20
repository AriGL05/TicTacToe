package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView player1wins, player2wins;
    private Button [] buttons = new Button[9];
    private int wins1, wins2, count;
    boolean activeplayer;

    int [ ] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winning= {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1wins = (TextView) findViewById(R.id.player1wins);
        player2wins = (TextView) findViewById(R.id.player2wins);
        for(int i=0;i< buttons.length;i++){
            String buttonID = "btn_"+i;
            int resourceID = getResources().getIdentifier(buttonID,"id",getPackageName());
            buttons[i]=(Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
        }
        count =0;
        wins1=0;
        wins2=0;
        activeplayer = true;
    }

    @Override
    public void onClick(View view) {
        if(!((Button)view).getText().toString().equals("")){
            return;
        }
        String buttonID = view.getResources().getResourceEntryName(view.getId());
        int gameStatePointer= Integer.parseInt(buttonID.substring(buttonID.length()-1, buttonID.length()));

        if(activeplayer){
            ((Button) view).setText("X");
            gameState[gameStatePointer] = 0;
        }
        else{
            ((Button) view).setText("O");
            gameState[gameStatePointer] = 1;
        }
        count++;

        if(checkWinner()){
            if(activeplayer){
                wins1++;
                updateWins();
                String eventData="Player One Won!";
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("textKey",eventData);
                startActivity(intent);
                playAgain();
            }
            else{
                wins2++;
                updateWins();
                String eventData="Player Two Won!";
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("textKey",eventData);
                startActivity(intent);
                playAgain();
            }
        }
        else if(count==9){
            String eventData="It´s a Draw!";
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("textKey",eventData);
            startActivity(intent);
            playAgain();
        }
        else{
            activeplayer=!activeplayer;
        }
    }

    public boolean checkWinner(){
        boolean winnerRes= false;
        for(int []winning:winning){
            if(gameState[winning[0]]== gameState[winning[1]] && gameState[winning[1]]== gameState[winning[2]] &&
            gameState[winning[0]]!=2){
                winnerRes=true;
            }
        }
        return winnerRes;
    }
    public  void updateWins(){
        player1wins.setText(Integer.toString(wins1));
        player2wins.setText(Integer.toString(wins2));
    }
    public void playAgain(){
        count=0;
        activeplayer=true;
        for(int i=0;i<buttons.length;i++){
            gameState[i]=2;
            buttons[i].setText("");
        }
    }
}