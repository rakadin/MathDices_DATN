package com.example.mathdices.part1.game_controller;

import android.widget.TextView;

import com.example.mathdices.R;
import com.example.mathdices.utils.Utils;

public class Fishing_game1_control {
    int GET_variable[]= {1,5,8,7,0,4,10,2,6,3,9}; // variable of fish
    int imgFish_id[] = {R.drawable.pink_1,R.drawable.blue_5,R.drawable.green_8,R.drawable.yellow_7,
            R.drawable.purple_0,R.drawable.yellow_4,R.drawable.red_10,R.drawable.green_2,R.drawable.red_6,
            R.drawable.red_3,R.drawable.green_9};
    int variable2[] = {0,1,2,3,4,5};// dice b
    int variable1[] = {5,6,7,8,9,10};// dice a
    // animation
    public void changeValueB(TextView target, int diceNum){
        Utils.delay(30, () -> { // wait till gif done
            target.setText(" B: "+variable1[diceNum-1]);
        });
    }
    public void changeValueA(TextView target, int diceNum){
        Utils.delay(30, () -> {// wait till gif done
            target.setText(" A: "+variable2[diceNum-1]);
        });
    }
    public int getAnswer(int diceValueA, int diceValueB){
        int ans = variable1[diceValueB-1] - variable2[diceValueA-1];
        return ans;
    }
    public int checkAnswer(int value){
        return GET_variable[value];
    }
    public int getFishID(int value){
        return imgFish_id[value];
    }
}
