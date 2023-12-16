package com.example.mathdices.part1.game_acitivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.MainActivity;
import com.example.mathdices.part1.game_controller.Fishing_game1_control;
import com.example.mathdices.part1.winning_activity.Winning_activity_fish_catch;
import com.example.mathdices.utils.Utils;

/*
fishing game main activity
 */
public class Fishing_game_main extends AppCompatActivity {
    private ImageButton onoffBut;
    private ImageButton diceButA;
    private ImageButton diceButB;
    private ImageButton homeBut;
    private TextView valueB;
    private TextView valueA;
    // dices values
    private int diceValueA = 1;
    private int diceValueB = 1;
    private int fishSum = 0;
    // get fish click id
    private ImageButton fish1, fish2, fish3, fish4, fish5, fish6, fish7, fish8, fish9, fish10, fish11;

    // get fish to tank id
    private ImageView get1, get2, get3, get4, get5;

    private SoundControl soundControl = new SoundControl();
    private RollDiceController rollDiceController = new RollDiceController();
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    private Dialog dialog;
    private Fishing_game1_control fishingGame1Control = new Fishing_game1_control();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_game_main);
        dialog = new Dialog(this);
        //get id
        getIDs();

        // get fish catch id
        get1 = findViewById(R.id.get1);
        get2 = findViewById(R.id.get2);
        get3 = findViewById(R.id.get3);
        get4 = findViewById(R.id.get4);
        get5 = findViewById(R.id.get5);
        // dice roll controll
        /*
        dice B
         */
        final int[] temB = new int[1];
        final int temA;
        diceButB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceValueB = rollDiceController.rollTheSixDice(diceButB, view.getContext(), dialog);
                fishingGame1Control.changeValueB(valueB, diceValueB);
            }
        });

        // dice A
        diceButA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceValueA = rollDiceController.rollTheSixDice(diceButA, view.getContext(), dialog);
                fishingGame1Control.changeValueA(valueA, diceValueA);
            }
        });
        /*
        end roll dices
         */
        // sound controll but
        soundControl.OnOffFun(Fishing_game_main.this, onoffBut);
        // home navigate button
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Fishing_game_main.this, homeBut);
                Intent intent = new Intent();
                intent.setClass(Fishing_game_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fish_animation);
        ImageButton fishs[] = {fish1, fish2, fish3, fish4, fish5, fish6, fish7, fish8, fish9, fish10, fish11};
        ImageView gets[] = {get1, get2, get3, get4, get5};
   /*
        gameplay control
         */
        /*
        controller of the game
         */
        for (int i = 0; i < 11; i++) {
            int tem = i;
            fishs[tem].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gif_popUp_controller.show_f_penguin(dialog);
                    Utils.delay(30, () -> { //wait till gif done
                        dialog.dismiss();
                        int ans = fishingGame1Control.getAnswer(diceValueA, diceValueB);
                        if (ans == fishingGame1Control.checkAnswer(tem)) {
                            Toast.makeText(view.getContext(), "Đúng rồi!!!", Toast.LENGTH_SHORT).show();
                            gets[fishSum].setImageResource(fishingGame1Control.getFishID(tem));
                            fishs[tem].startAnimation(animation);
                            soundControl.correctSoundFun(Fishing_game_main.this);
                            fishSum++;
                            if (fishSum == 5) {
                                gif_popUp_controller.show_egg_dancing(dialog);
                                soundControl.hooraySoundFun(Fishing_game_main.this);
                                Utils.delay(50, () -> {
                                    dialog.dismiss();
                                    Intent intent = new Intent();
                                    intent.setClass(Fishing_game_main.this, Winning_activity_fish_catch.class);
                                    startActivity(intent);
                                });

                            }
                            soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    mediaPlayer.release();
                                }
                            });
                        } else {
                            Toast.makeText(view.getContext(), "Sai rồi!!!", Toast.LENGTH_SHORT).show();
                            soundControl.wrongSoundFun(Fishing_game_main.this);
                            soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    mediaPlayer.release();
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    private void getIDs() {
        // onoffBut
        onoffBut = findViewById(R.id.SonoffBut_game2);
        //dices id
        diceButA = findViewById(R.id.dice);
        diceButB = findViewById(R.id.dice2);
        // home id
        homeBut = findViewById(R.id.homeBut);
        // value text id
        valueB = findViewById(R.id.rightText);
        valueA = findViewById(R.id.leftText);
        // get fishs id
        fish1 = findViewById(R.id.fish1);
        fish2 = findViewById(R.id.fish2);
        fish3 = findViewById(R.id.fish3);
        fish4 = findViewById(R.id.fish4);
        fish5 = findViewById(R.id.fish5);
        fish6 = findViewById(R.id.fish6);
        fish7 = findViewById(R.id.fish7);
        fish8 = findViewById(R.id.fish8);
        fish9 = findViewById(R.id.fish9);
        fish10 = findViewById(R.id.fish10);
        fish11 = findViewById(R.id.fish11);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.player.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        soundControl.player.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
    }
}