package com.example.mathdices.part2.game_controller;

public class Mushroom_Controller {
    static final int ans[] = {35,34,6,67,50,12};
    public boolean getAns( int numFinal, int loc)
    {
        boolean check = false;
       if(ans[loc]== numFinal)// correct
       {
           check = true;
       }
       return check;
    }
}
