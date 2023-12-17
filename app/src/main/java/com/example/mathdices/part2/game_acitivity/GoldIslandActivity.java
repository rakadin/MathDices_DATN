package com.example.mathdices.part2.game_acitivity;

import static com.example.mathdices.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part2.Part2_Homepage_Activity;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.part2.game_controller.GoldIsland_Controller;
import com.example.mathdices.part2.winning_activity.Winning_activity_golden_island;
import com.example.mathdices.utils.Utils;

import pl.droidsonroids.gif.GifImageView;

public class GoldIslandActivity extends AppCompatActivity {
    private GoldIsland_Controller goldIsland_controller = new GoldIsland_Controller();
    private SoundControl soundControl = new SoundControl();
    private RollDiceController rollDiceController = new RollDiceController();
    private ImageButton soundBut,homeBut,diceBut;
    private GifImageView ship_gif,chest_gif;
    private TextView num_now;
    private Dialog dialog ;
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();// call controller
    private int diceNumFinal = 0;
    private int now_loc =0, previous_loc =0;
    private Button loc_1,loc_2,loc_3,loc_4,loc_5,loc_6,loc_7,loc_8,loc_9,loc_10,loc_11,loc_12,loc_13,loc_14,loc_15,loc_16,loc_17,loc_18,loc_19,loc_20,
            loc_21,loc_22,loc_23,loc_24,loc_25,loc_26,loc_27,loc_28,loc_29,loc_30,
            loc_31,loc_32,loc_33,loc_34,loc_35,loc_36,loc_37,loc_38,loc_39;
    private Button moveBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_island);
        dialog = new Dialog(GoldIslandActivity.this);// dialog
        // get idS
        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);
        moveBut = findViewById(R.id.moveBut);
        num_now = findViewById(R.id.num_now);
        ship_gif = findViewById(R.id.ship_sailing);
        chest_gif = findViewById(R.id.chest_open);
        getShipBut();
        Button multiShip[] ={loc_1,loc_2,loc_3,loc_4,loc_5,loc_6,loc_7,loc_8,loc_9,loc_10,loc_11,loc_12,loc_13,loc_14,loc_15,loc_16,loc_17,loc_18,loc_19,loc_20,
                loc_21,loc_22,loc_23,loc_24,loc_25,loc_26,loc_27,loc_28,loc_29,loc_30,
                loc_31,loc_32,loc_33,loc_34,loc_35,loc_36,loc_37,loc_38,loc_39};
        // set sound controll button
        soundControl.OnOffFun(this,soundBut);
        setHomeBut();
        rollDice();
        // set function moving ship
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    // switching location
                    int tempr = previous_loc;
                    int tem = now_loc;
                    previous_loc = tem;
                    now_loc = previous_loc+ diceNumFinal;
                    if(now_loc >39)// not increase > 39
                    {
                        now_loc = now_loc - diceNumFinal;
                        previous_loc = tempr;
                        dialog.dismiss();
                    }
                    else
                    {
                        Boolean flag = false;
                        Animation animation3 = AnimationUtils.loadAnimation(view.getContext(), R.anim.ship_go_down_right);
                        Animation animation4 = AnimationUtils.loadAnimation(view.getContext(), R.anim.ship_go_up_right);
                        Animation animation5 = AnimationUtils.loadAnimation(view.getContext(), R.anim.ship_go_up_right_2);
                        if(now_loc == 39)//go to island
                        {

                            Utils.delay(55, () -> {
                                soundControl.hooraySoundFun(GoldIslandActivity.this);
                                gif_popUp_controller.show_gold_chest(dialog);
                            });
                            Utils.delay(125, () -> {
                                dialog.dismiss();
                                Intent intent = new Intent();
                                intent.setClass(view.getContext(), Winning_activity_golden_island.class);
                                startActivity(intent);
                            });

                        }else {
                            if(now_loc == 5)
                            {
                                flag = true;
                                now_loc = 13;
                                Utils.delay(55, () -> {
                                    multiShip[now_loc-1].setAnimation(animation4);
                                });

                            }
                            if(now_loc == 16)
                            {
                                flag = true;
                                now_loc = 27;
                                Utils.delay(55, () -> {
                                    multiShip[now_loc-1].setAnimation(animation5);
                                });
                            }
                            if(now_loc == 19)
                            {
                                flag = true;
                                now_loc = 3;
                                Utils.delay(55, () -> {
                                    multiShip[now_loc-1].setAnimation(animation3);
                                });
                            }
                            if(now_loc == 25)
                            {
                                flag = true;
                                now_loc = 36;
                                Utils.delay(55, () -> {
                                    multiShip[now_loc-1].setAnimation(animation4);
                                });
                            }
                            soundControl.sailingSoundFunc(view.getContext());
                            gif_popUp_controller.show_ship_sailing(dialog);
                            Boolean finalFlag = flag;
                            Utils.delay(55, () -> {
                                soundControl.fall.release();
                                if(now_loc <39)
                                { // dismiss dialog after few secs when location <39
                                    dialog.dismiss();
                                }
                                multiShip[now_loc-1].setBackgroundResource(R.drawable.pirate_ship);
                                goldIsland_controller.show_num(num_now,now_loc+1);//show location number

                                if(finalFlag == true){
                                    diceBut.setClickable(false);// wait till animation complete
                                    moveBut.setClickable(false);
                                    // handle if ship go into specific case, wait till animation complete
                                    Utils.delay(75, () -> {
                                        diceBut.setClickable(true);// wait till animation complete
                                        moveBut.setClickable(true);
                                        Dialog dialog2 = new Dialog(view.getContext());
                                        goldIsland_controller.showQuestion(dialog2,now_loc+1);
                                    });
                                } else {
                                    Dialog dialog2 = new Dialog(view.getContext());
                                    goldIsland_controller.showQuestion(dialog2,now_loc+1);
                                }

                                if(previous_loc>0)
                                {
                                    multiShip[previous_loc-1].setBackgroundResource(0);
                                }
                            });
                        }

                    }
                }


            }
        });
    }
    // home button func
    void setHomeBut()
    {
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
    }
    // roll the dicefunc
    private void rollDice()
    {
        // dice button controll
        // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceNumFinal = rollDiceController.rollTheSixDice(diceBut, view.getContext(), dialog);
            }
        });
        // end roll
    }
    void getShipBut()
    {
        loc_1 = findViewById(R.id.loc_1);
        loc_2 = findViewById(R.id.loc_2);
        loc_3 = findViewById(R.id.loc_3);
        loc_4 = findViewById(R.id.loc_4);
        loc_5 = findViewById(R.id.loc_6);
        loc_6 = findViewById(R.id.loc_7);
        loc_7 = findViewById(R.id.loc_8);
        loc_8 = findViewById(R.id.loc_9);
        loc_9 = findViewById(R.id.loc_10);
        loc_10 = findViewById(R.id.loc_11);
        loc_11 = findViewById(R.id.loc_12);
        loc_12 = findViewById(R.id.loc_13);
        loc_13 = findViewById(R.id.loc_14);
        loc_14 = findViewById(R.id.loc_15);
        loc_15 = findViewById(R.id.loc_16);
        loc_16 = findViewById(R.id.loc_17);
        loc_17 = findViewById(R.id.loc_18);
        loc_18 = findViewById(R.id.loc_19);
        loc_19 = findViewById(R.id.loc_20);
        loc_20 = findViewById(R.id.loc_21);
        loc_21 = findViewById(R.id.loc_22);
        loc_22 = findViewById(R.id.loc_23);
        loc_23 = findViewById(R.id.loc_24);
        loc_24 = findViewById(R.id.loc_25);
        loc_25 = findViewById(R.id.loc_26);
        loc_26 = findViewById(R.id.loc_27);
        loc_27 = findViewById(R.id.loc_28);
        loc_28 = findViewById(R.id.loc_29);
        loc_29 = findViewById(R.id.loc_30);
        loc_30 = findViewById(R.id.loc_31);
        loc_31 = findViewById(R.id.loc_32);
        loc_32 = findViewById(R.id.loc_33);
        loc_33 = findViewById(R.id.loc_34);
        loc_34 = findViewById(R.id.loc_35);
        loc_35 = findViewById(R.id.loc_36);
        loc_36 = findViewById(R.id.loc_37);
        loc_37 = findViewById(R.id.loc_38);
        loc_38 = findViewById(R.id.loc_39);
        loc_39 = findViewById(R.id.loc_40);
    }

    // if restart set activity again
    @Override
    protected void onRestart() {
        super.onRestart();
        soundBut.setImageResource(sound_on);
        soundControl.player.start();
    }
    // if destroy stop music
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundControl.player != null)
        {
            soundControl.player.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
        soundControl.player.release();
    }
}