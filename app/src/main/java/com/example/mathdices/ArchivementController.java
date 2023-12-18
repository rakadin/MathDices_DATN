package com.example.mathdices;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Calendar;

public class ArchivementController {
    public void activateArchivementDialog(Dialog dialog, Context context){
        SharedPrefManager manager = new SharedPrefManager(context);
        dialog.setContentView(R.layout.archivement_dialog);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        TextView fishGameGOT = dialog.findViewById(R.id.fishGameGOT);
        TextView eggGameGOT = dialog.findViewById(R.id.eggGameGOT);
        TextView slideGameGOT = dialog.findViewById(R.id.slideGameGOT);
        TextView chickenGameGOT = dialog.findViewById(R.id.chickenGameGOT);
        TextView cardGameGOT = dialog.findViewById(R.id.cardGameGOT);
        TextView goldIslandGameGOT = dialog.findViewById(R.id.goldIslandGameGOT);
        TextView toyGameGOT = dialog.findViewById(R.id.toyGameGOT);
        TextView mushroomGameGOT = dialog.findViewById(R.id.mushroomGameGOT);
        TextView beeGameGOT = dialog.findViewById(R.id.beeGameGOT);
        TextView fishGameGOH = dialog.findViewById(R.id.fishGameGOH);
        TextView eggGameGOH = dialog.findViewById(R.id.eggGameGOH);
        TextView slideGameGOH = dialog.findViewById(R.id.slideGameGOH);
        TextView chickenGameGOH = dialog.findViewById(R.id.chickenGameGOH);
        TextView cardGameGOH = dialog.findViewById(R.id.cardGameGOH);
        TextView goldIslandGameGOH = dialog.findViewById(R.id.goldIslandGameGOH);
        TextView toyGameGOH = dialog.findViewById(R.id.toyGameGOH);
        TextView mushroomGameGOH = dialog.findViewById(R.id.mushroomGameGOH);
        TextView beeGameGOH = dialog.findViewById(R.id.beeGameGOH);
        TextView totalDiceRolls = dialog.findViewById(R.id.diceRollNumTxt);
        TextView xBut = dialog.findViewById(R.id.archivementButOff);

        fishGameGOT.setText(""+getText(manager.getFishGameGOT()));
        eggGameGOT.setText(""+getText(manager.getEggGameGOT()));
        slideGameGOT.setText(""+getText(manager.getSlideGameGOT()));
        chickenGameGOT.setText(""+getText(manager.getChickenGameGOT()));
        cardGameGOT.setText(""+getText(manager.getCardGameGOT()));
        goldIslandGameGOT.setText(""+getText(manager.getGoldIslandGameGOT()));
        toyGameGOT.setText(""+getText(manager.getToyGameGOT()));
        mushroomGameGOT.setText(""+getText(manager.getMushroomGameGOT()));
        beeGameGOT.setText(""+getText(manager.getBeeGameGOT()));

        fishGameGOH.setText(""+getNumText(manager.getFishGameGOH()));
        eggGameGOH.setText(""+getNumText(manager.getEggGameGOH()));
        slideGameGOH.setText(""+getNumText(manager.getSlideGameGOH()));
        chickenGameGOH.setText(""+getNumText(manager.getChickenGameGOH()));
        cardGameGOH.setText(""+getNumText(manager.getCardGameGOH()));
        goldIslandGameGOH.setText(""+getNumText(manager.getGoldIslandGameGOH()));
        toyGameGOH.setText(""+getNumText(manager.getToyGameGOH()));
        mushroomGameGOH.setText(""+getNumText(manager.getMushroomGameGOH()));
        beeGameGOH.setText(""+getNumText(manager.getBeeGameGOH()));

        totalDiceRolls.setText(""+manager.getTotalDiceRolls());
        xBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void setNewDiceRollCount(int addNum, Context context){
        SharedPrefManager manager = new SharedPrefManager(context);
        int current = manager.getTotalDiceRolls();
        int newNum = current +addNum;
        manager.setTotalDiceRolls(newNum);
    }
    public void setNewTimeValueGOT(Calendar current, Calendar target, Context context, String wCase){
        SharedPrefManager manager = new SharedPrefManager(context);
        ShPrefEnum Snum = new ShPrefEnum();
        int minute = calculateMinutesDifference(current,target);
        if(wCase.equals(Snum.fishGameGOT)){
            int currentGOT = manager.getFishGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setFishGameGOT(minute);
                }
            }else {
                manager.setFishGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.eggGameGOT)){
            int currentGOT = manager.getEggGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setEggGameGOT(minute);
                }
            }else {
                manager.setEggGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.slideGameGOT)){
            int currentGOT = manager.getSlideGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setSlideGameGOT(minute);
                }
            }else {
                manager.setSlideGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.chickenGameGOT)){
            int currentGOT = manager.getChickenGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setChickenGameGOT(minute);
                    Log.d("Duc","triggered"+minute);
                }
            }else {
                manager.setChickenGameGOT(minute);
                Log.d("Duc","triggered"+minute);
            }
        }
        if(wCase.equals(Snum.cardGameGOT)){
            int currentGOT = manager.getCardGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setCardGameGOT(minute);
                }
            }else {
                manager.setCardGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.goldIslandGameGOT)){
            int currentGOT = manager.getGoldIslandGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setGoldIslandGameGOT(minute);
                }
            }else {
                manager.setGoldIslandGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.toyGameGOT)){
            int currentGOT = manager.getToyGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setToyGameGOT(minute);
                }
            }else {
                manager.setToyGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.mushroomGameGOT)){
            int currentGOT = manager.getMushroomGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setMushroomGameGOT(minute);
                }
            }else {
                manager.setMushroomGameGOT(minute);
            }
        }
        if(wCase.equals(Snum.beeGameGOT)){
            int currentGOT = manager.getBeeGameGOT();
            if (currentGOT!= 0){
                if(currentGOT > minute ){
                    manager.setBeeGameGOT(minute);
                }
            }else {
                manager.setBeeGameGOT(minute);
            }
        }
    }
    public void setNewGOH(String wCase, Context context){
        SharedPrefManager manager = new SharedPrefManager(context);
        ShPrefEnum Snum = new ShPrefEnum();
        if(wCase.equals(Snum.fishGameGOH)){
            int current = manager.getFishGameGOH();
            int newValue = current + 1;
            manager.setFishGameGOH(newValue);
        }
        if(wCase.equals(Snum.eggGameGOH)){
            int current = manager.getEggGameGOH();
            int newValue = current + 1;
            manager.setEggGameGOH(newValue);
        }
        if(wCase.equals(Snum.slideGameGOH)){
            int current = manager.getSlideGameGOH();
            int newValue = current + 1;
            manager.setSlideGameGOH(newValue);
        }
        if(wCase.equals(Snum.chickenGameGOH)){
            int current = manager.getChickenGameGOH();
            int newValue = current + 1;
            manager.setChickenGameGOH(newValue);
        }
        if(wCase.equals(Snum.cardGameGOH)){
            int current = manager.getCardGameGOH();
            int newValue = current + 1;
            manager.setCardGameGOH(newValue);
        }
        if(wCase.equals(Snum.goldIslandGameGOH)){
            int current = manager.getGoldIslandGameGOH();
            int newValue = current + 1;
            manager.setGoldIslandGameGOH(newValue);
        }
        if(wCase.equals(Snum.toyGameGOH)){
            int current = manager.getToyGameGOH();
            int newValue = current + 1;
            manager.setToyGameGOH(newValue);
        }
        if(wCase.equals(Snum.mushroomGameGOH)){
            int current = manager.getMushroomGameGOH();
            int newValue = current + 1;
            manager.setMushroomGameGOH(newValue);
        }
        if(wCase.equals(Snum.beeGameGOH)){
            int current = manager.getBeeGameGOH();
            int newValue = current + 1;
            manager.setBeeGameGOH(newValue);
        }
    }
    public static int calculateMinutesDifference(Calendar current, Calendar target) {
        // Get the time in milliseconds for both calendars
        long currentTimeMillis = current.getTimeInMillis();
        long targetTimeMillis = target.getTimeInMillis();

        // Calculate the difference in milliseconds
        long differenceInMillis = targetTimeMillis - currentTimeMillis;

        // Convert milliseconds to minutes and round down to the nearest whole minute
        int minutesDifference = (int) Math.floor(differenceInMillis / (1000.0 * 60.0));

        // Set minimum difference to 1 minute if actual difference is less
        if (minutesDifference < 1) {
            minutesDifference = 1;
        }

        return minutesDifference;
    }
    private String getText(int num){
       return num+" Phút";
    }
    private String getNumText(int num){
        return num+" Lần";
    }
}
