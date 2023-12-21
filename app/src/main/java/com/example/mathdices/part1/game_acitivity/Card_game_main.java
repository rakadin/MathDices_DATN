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
import android.widget.Toast;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.ShPrefEnum;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.MainActivity;
import com.example.mathdices.part1.winning_activity.Winning_activity_card;
import com.example.mathdices.utils.Utils;

import java.util.Calendar;

public class Card_game_main extends AppCompatActivity {
    ImageButton diceBut;
    SoundControl soundControl = new SoundControl();
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    RollDiceController rollDiceController = new RollDiceController();
    Dialog dialog;
    int diceNumFinal;
    int card_cound = 0;
    ImageButton card1;
    ImageButton card2;
    ImageButton card3;
    ImageButton card4;
    ImageButton card5;
    ImageButton card6;
    ImageButton card7;
    ImageButton card8;
    ImageButton card9;
    ImageButton card10;
    ImageButton card11;
    ImageButton card12;

    ImageButton onoffBut;
    ImageButton homeBut;
    private Calendar start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_game_main);
        start = Calendar.getInstance();
        dialog = new Dialog(this);
        // get id
        diceBut = findViewById(R.id.dice);
        // card id
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        card9 = findViewById(R.id.card9);
        card10 = findViewById(R.id.card10);
        card11 = findViewById(R.id.card11);
        card12 = findViewById(R.id.card12);
        // animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.card_animation);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.card_animation_wrong);
        onoffBut = findViewById(R.id.SonoffBut_game2);
        homeBut = findViewById(R.id.homeBut);
        ImageButton CARDS[] = {card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12};
        int cards_value[] = {1,1,2,2,3,3,4,4,5,5,6,6};
        /*
        dice roll
         */
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceNumFinal = rollDiceController.rollTheSixDice(diceBut, view.getContext(), dialog);
            }
        });
        /*
        end roll
         */
        for (int i = 0 ; i < 12;i++)
        {
            int tem = i;
            CARDS[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(diceNumFinal ==0)// make sure roll the dice first
                    {
                        Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        gif_popUp_controller.show_flipping_card(dialog);
                        Utils.delay(20, () -> {
                            dialog.dismiss();
                            if(cards_value[tem] == diceNumFinal)
                            {
                                CARDS[tem].startAnimation(animation);
                                soundControl.correctSoundFun(Card_game_main.this);
                                // controll yellow and blue card to flip back
                                if (tem % 2 == 0) {
                                    CARDS[tem].setImageResource(R.drawable.yellow_card_back);
                                }
                                else
                                {
                                    CARDS[tem].setImageResource(R.drawable.blue_card_back);
                                }
                                Toast.makeText(Card_game_main.this,"Đúng rồi !!!",Toast.LENGTH_LONG).show();
                                CARDS[tem].setClickable(false);
                                card_cound++;
                                // if card count == 6 -> win
                                if(card_cound == 6)
                                {
                                    Calendar target = Calendar.getInstance();
                                    ArchivementController controller = new ArchivementController();
                                    ShPrefEnum shPrefEnum = new ShPrefEnum();
                                    controller.setNewTimeValueGOT(start,target,view.getContext(), shPrefEnum.cardGameGOT);
                                    controller.setNewGOH(shPrefEnum.cardGameGOH, view.getContext());
                                    gif_popUp_controller.show_egg_dancing(dialog);
                                    soundControl.hooraySoundFun(Card_game_main.this);
                                    Utils.delay(50, () -> {
                                        dialog.dismiss();
                                        Intent intent = new Intent();
                                        intent.setClass(Card_game_main.this, Winning_activity_card.class);
                                        startActivity(intent);
                                    });
                                }
                            }
                            else
                            {
                                CARDS[tem].startAnimation(animation2);
                                soundControl.wrongSoundFun(Card_game_main.this);
                                Toast.makeText(Card_game_main.this,"Sai rồi !!!",Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                }
            });
        }
        // sound controll but
        soundControl.OnOffFun(Card_game_main.this,onoffBut);
        // home navigate button
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Card_game_main.this,homeBut);
                Intent intent = new Intent();
                intent.setClass(Card_game_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.releaseAllSound();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        start = Calendar.getInstance();
        soundControl.OnOffFun(Card_game_main.this,onoffBut);
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.releaseAllSound();
    }
}