package com.example.mathdices.part1.game_acitivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.ShPrefEnum;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.MainActivity;
import com.example.mathdices.part1.game_controller.Chicken_game_control;
import com.example.mathdices.part1.winning_activity.Winning_activity_chicken;
import com.example.mathdices.utils.Utils;

import java.util.Calendar;

public class Chicken_game_main extends AppCompatActivity {
    private Chicken_game_control controller = new Chicken_game_control();
    private ImageButton diceBut;
    private SoundControl soundControl = new SoundControl();
    private int diceNumFinal = 0;
    private ImageButton onoffBut;
    private ImageButton homeBut;
    private Button moveBut;
    private TextView questionT;
    private int temmove = 0;
    private RollDiceController rollDiceController = new RollDiceController();
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    private Dialog dialog;
    private Calendar start;
    // moves button
    ImageButton move0, move1, move2, move3, move4, move5, move6, move7, move8, move9, move10, move11, move12,
            move13, move14, move15, move16, move17, move18, move19, move20, move21;
    // chickens button
    ImageButton chick1, chick2, chick3, chick4, chick5, chick6, chick7, chick8, chick9, chick10;
    // chicken get
    ImageView get_1, get_2, get_3, get_4, get_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_game_main);
        start = Calendar.getInstance();
        getIDs();
        dialog = new Dialog(this);
        /*
        dice roll controll
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
        // sound controll but
        soundControl.OnOffFun(Chicken_game_main.this, onoffBut);
        // home navigate button
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Chicken_game_main.this, homeBut);
                Intent intent = new Intent();
                intent.setClass(Chicken_game_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageButton moveButs[] = {move0, move1, move2, move3, move4, move5, move6, move7, move8, move9, move10,
                move11, move12, move13, move14, move15, move16, move17, move18, move19, move20, move21};
        ImageButton chickens[] = {chick1, chick2, chick3, chick4, chick5, chick6, chick7, chick8, chick9, chick10};
        ImageView gets[] = {get_1, get_2, get_3, get_4, get_5};
        int chick_values[] = {7, 1, 4, 2, 5, 3, 8, 6, 9, 0};
        // animation set
        Animation bounce = AnimationUtils.loadAnimation(Chicken_game_main.this, R.anim.bounce_animation);
         /*
        move button controll
         */
        move0.setImageResource(R.drawable.mario);
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diceNumFinal == 0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(), "Bạn cần xúc xắc trước đã!", Toast.LENGTH_LONG).show();
                } else {
                    int previous = temmove;
                    if ((temmove + diceNumFinal) == 0) {

                    } else {
                        if ((temmove + diceNumFinal) > 21) {
                            temmove += diceNumFinal;
                            temmove -= 21;
                            controller.setString (questionT, temmove, moveButs, previous, Chicken_game_main.this, view.getContext());
                        } else {
                            temmove += diceNumFinal;
                            controller.setString (questionT, temmove, moveButs, previous, Chicken_game_main.this, view.getContext());
                        }
                    }
                }
            }
        });
        /*
        chickens clicking control
         */
        for (int i = 0; i < 10; i++) {
            int temi = i;
            chickens[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gif_popUp_controller.show_chicken_running(dialog);
                    Utils.delay(50, () -> {
                        dialog.dismiss();
                        controller.checkAns(view.getContext(), temmove, chick_values[temi], Chicken_game_main.this, chickens[temi], gets, temi);
                        if (controller.get_count == 5) {
                            soundControl.hooraySoundFun(Chicken_game_main.this);
                            moveButs[temmove].startAnimation(bounce);
                            Calendar target = Calendar.getInstance();
                            ArchivementController controller = new ArchivementController();
                            ShPrefEnum shPrefEnum = new ShPrefEnum();
                            controller.setNewTimeValueGOT(start,target,view.getContext(), shPrefEnum.chickenGameGOT);
                            controller.setNewGOH(shPrefEnum.chickenGameGOH, view.getContext());
                            Utils.delay(50, () -> {
                                Intent intent = new Intent();
                                intent.setClass(Chicken_game_main.this, Winning_activity_chicken.class);
                                startActivity(intent);
                            });
                        }
                    });

                }
            });
        }
    }

    private void getIDs() {
        diceBut = findViewById(R.id.dice);
        onoffBut = findViewById(R.id.SonoffBut_game2);
        homeBut = findViewById(R.id.homeBut);
        moveBut = findViewById(R.id.moveBut);
        questionT = findViewById(R.id.questionText);
/// move buttons id
        move0 = findViewById(R.id.move_0);
        move1 = findViewById(R.id.move_1);
        move2 = findViewById(R.id.move_2);
        move3 = findViewById(R.id.move_3);
        move4 = findViewById(R.id.move_4);
        move5 = findViewById(R.id.move_5);
        move6 = findViewById(R.id.move_6);
        move7 = findViewById(R.id.move_7);
        move8 = findViewById(R.id.move_8);
        move9 = findViewById(R.id.move_9);
        move10 = findViewById(R.id.move_10);
        move11 = findViewById(R.id.move_11);
        move12 = findViewById(R.id.move_12);
        move13 = findViewById(R.id.move_13);
        move14 = findViewById(R.id.move_14);
        move15 = findViewById(R.id.move_15);
        move16 = findViewById(R.id.move_16);
        move17 = findViewById(R.id.move_17);
        move18 = findViewById(R.id.move_18);
        move19 = findViewById(R.id.move_19);
        move20 = findViewById(R.id.move_20);
        move21 = findViewById(R.id.move_21);
/// chickens ids
        chick1 = findViewById(R.id.chick_1);
        chick2 = findViewById(R.id.chick_2);
        chick3 = findViewById(R.id.chick_3);
        chick4 = findViewById(R.id.chick_4);
        chick5 = findViewById(R.id.chick_5);
        chick6 = findViewById(R.id.chick_6);
        chick7 = findViewById(R.id.chick_7);
        chick8 = findViewById(R.id.chick_8);
        chick9 = findViewById(R.id.chick_9);
        chick10 = findViewById(R.id.chick_10);
        // chickens u get ids
        get_1 = findViewById(R.id.get_1);
        get_2 = findViewById(R.id.get_2);
        get_3 = findViewById(R.id.get_3);
        get_4 = findViewById(R.id.get_4);
        get_5 = findViewById(R.id.get_5);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.player.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        start = Calendar.getInstance();
        soundControl.player.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
    }
}