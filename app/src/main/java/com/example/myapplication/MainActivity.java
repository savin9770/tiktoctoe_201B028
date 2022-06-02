package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int isvisited = -1;
    int player = 1;
    int [][]winning = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int []game = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
        isvisited = game[tag];
        if(isWinner==false && isvisited==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
            }
            else {
                v.setImageResource(R.drawable.zero);
                Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
            }
            player^=1;
            game[tag] = player;

            for (int i = 0; i < winning.length; i++) {
                if (game[winning[i][0]] == game[winning[i][1]] && game[winning[i][1]] == game[winning[i][2]] && game[winning[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player==0 ? 1:0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout = findViewById(R.id.gridlayout);
        int total_image = gridLayout.getChildCount();
        for(int i=0;i<total_image;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner = false;
        isvisited = -1;
        player = 1;
        for(int i=0;i<game.length;i++) game[i] = -1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}