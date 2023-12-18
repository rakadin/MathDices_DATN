package com.example.mathdices;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private final Context context;
    String  PREF_NAME = "MathDiceShPrefs";
    String  soundShPref = "Sound";
    String  totalDiceRolls = "TotalDiceRolls"; // how many dice have rolls ?
    String  fishGameGOT = "FishGameGOT"; // fastest win in fishing game
    String  eggGameGOT = "EggGameGOT"; // fastest win in egg game
    String  slideGameGOT = "SlideGameGOT"; // fastest win in slide game
    String  chickenGameGOT = "ChickenGameGOT"; // fastest win in chicken game
    String  cardGameGOT = "CardGameGOT"; // fastest win in card game
    String  goldIslandGameGOT = "GoldIslandGameGOT"; // fastest win in Gold Island game
    String  toyGameGOT = "ToyGameGOT"; // fastest win in card game
    String  mushroomGameGOT = "MushroomGameGOT"; // fastest win in mushroom game
    String  beeGameGOT = "BeeGameGOT"; // fastest win in bee game

    String  fishGameGOH = "FishGameGOH"; // how many wins fishing game
    String  eggGameGOH = "EggGameGOH"; // how many wins egg game
    String  slideGameGOH = "SlideGameGOH"; // how many wins slide game
    String  chickenGameGOH = "ChickenGameGOH"; // how many wins chicken game
    String  cardGameGOH = "CardGameGOH"; // how many wins card game
    String  goldIslandGameGOH = "GoldIslandGameGOH"; // how many wins Gold Island game
    String  toyGameGOH = "ToyGameGOH"; // how many wins card game
    String  mushroomGameGOH = "MushroomGameGOH"; // how many wins mushroom game
    String  beeGameGOH = "BeeGameGOH"; // fastest win in bee game

    public SharedPrefManager(Context context) {
        this.context = context;
    }
    //sound control value
    public void setSoundShPref(Boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(soundShPref, value);
        editor.apply();
    }
    public boolean getSoundShPref() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(soundShPref,true);
    }

    // save total dice rolls
    public void setTotalDiceRolls( int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(totalDiceRolls, value);
        editor.apply();
    }

    public int getTotalDiceRolls() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(totalDiceRolls, 0);
    }

    // save fish game god of time
    public void setFishGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(fishGameGOT, value);
        editor.apply();
    }

    public int getFishGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(fishGameGOT, 0);
    }

    // save egg game god of time
    public void setEggGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(eggGameGOT, value);
        editor.apply();
    }

    public int getEggGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(eggGameGOT, 0);
    }

    // save slide game god of time
    public void setSlideGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(slideGameGOT, value);
        editor.apply();
    }

    public int getSlideGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(slideGameGOT, 0);
    }

    // save chicken game god of time
    public void setChickenGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(chickenGameGOT, value);
        editor.apply();
    }

    public int getChickenGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(chickenGameGOT, 0);
    }

    // save card game god of time
    public void setCardGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(cardGameGOT, value);
        editor.apply();
    }

    public int getCardGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(cardGameGOT, 0);
    }

    // save gold Island game god of time
    public void setGoldIslandGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(goldIslandGameGOT, value);
        editor.apply();
    }

    public int getGoldIslandGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(goldIslandGameGOT, 0);
    }

    // save toy game god of time
    public void setToyGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(toyGameGOT, value);
        editor.apply();
    }

    public int getToyGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(toyGameGOT, 0);
    }

    // save mushroom game god of time
    public void setMushroomGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(mushroomGameGOT, value);
        editor.apply();
    }

    public int getMushroomGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(mushroomGameGOT, 0);
    }

    // save bee game god of time
    public void setBeeGameGOT(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(beeGameGOT, value);
        editor.apply();
    }

    public int getBeeGameGOT() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(beeGameGOT, 0);
    }

    // save fish game god of hard work
    public void setFishGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(fishGameGOH, value);
        editor.apply();
    }

    public int getFishGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(fishGameGOH, 0);
    }

    // save egg game god of hard work
    public void setEggGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(eggGameGOH, value);
        editor.apply();
    }

    public int getEggGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(eggGameGOH, 0);
    }

    // save slide game god of hard work
    public void setSlideGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(slideGameGOH, value);
        editor.apply();
    }

    public int getSlideGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(slideGameGOH, 0);
    }

    // save chicken game god of hard work
    public void setChickenGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(chickenGameGOH, value);
        editor.apply();
    }

    public int getChickenGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(chickenGameGOH, 0);
    }

    // save card game god of hard work
    public void setCardGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(cardGameGOH, value);
        editor.apply();
    }

    public int getCardGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(cardGameGOH, 0);
    }

    // save gold Island game god of hard work
    public void setGoldIslandGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(goldIslandGameGOH, value);
        editor.apply();
    }

    public int getGoldIslandGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(goldIslandGameGOH, 0);
    }

    // save toy game god of hard work
    public void setToyGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(toyGameGOH, value);
        editor.apply();
    }

    public int getToyGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(toyGameGOH, 0);
    }

    // save mushroom game god of hard work
    public void setMushroomGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(mushroomGameGOH, value);
        editor.apply();
    }

    public int getMushroomGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(mushroomGameGOH, 0);
    }

    // save bee game god of hard work
    public void setBeeGameGOH(int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(beeGameGOH, value);
        editor.apply();
    }

    public int getBeeGameGOH() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(beeGameGOH, 0);
    }
    public void clearSharedPrefs() {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}

