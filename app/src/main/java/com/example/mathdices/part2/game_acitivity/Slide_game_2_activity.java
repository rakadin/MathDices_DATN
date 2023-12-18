package com.example.mathdices.part2.game_acitivity;

import static com.example.mathdices.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
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
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.ShPrefEnum;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part2.Part2_Homepage_Activity;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.part2.game_controller.Slide_game2_controller;
import com.example.mathdices.part2.winning_activity.Winning_activity_slide_2;
import com.example.mathdices.utils.Utils;

import java.util.Calendar;

/*
 slide game main activity class
 */
public class Slide_game_2_activity extends AppCompatActivity {
    private Slide_game2_controller control = new Slide_game2_controller();
    private int temmove = 0;
    private int diceNumFinal = 0;
    private int now_loc = 0, previous_loc = 0;
    private ImageButton onoffBut;
    private ImageButton diceBut;
    private SoundControl soundControl = new SoundControl();
    private Button moveBut, upBut, downBut;
    // image character
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16;
    private ImageView img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30;

    //create counting move
    private TextView question;
    private TextView txtInput;
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    private RollDiceController rollDiceController = new RollDiceController();
    private ImageButton homebut;
    private Dialog dialog;
    private Calendar start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2_game);
        start = Calendar.getInstance();
        dialog = new Dialog(this);

        getIDs();

        img1.setImageResource(R.drawable.mario);

        // dice button controll
        // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceNumFinal = rollDiceController.rollTheSixDice(diceBut, view.getContext(), dialog);
            }

        });

        // end roll


        // control sound button
        soundControl.OnOffFun(Slide_game_2_activity.this, onoffBut);
        homebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Slide_game_2_activity.this, homebut);
                Intent intent = new Intent();
                intent.setClass(Slide_game_2_activity.this, Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
        // end controll sound but
    }

    @Override
    protected void onResume() {
        super.onResume();
        //animation set
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_to_right);
        Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce_animation);
        ImageView table[] = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14,
                img15, img16, img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28,
                img29, img30};
        // controll character movement
        /*
        start code
         */
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diceNumFinal == 0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(), "Bạn cần xúc xắc trước đã!", Toast.LENGTH_LONG).show();
                } else {
                    previous_loc = temmove;
                    temmove = temmove + diceNumFinal;
                    now_loc = temmove;
                    if (temmove > 29) {
                        temmove = previous_loc;
                        previous_loc = temmove;
                    } else if (temmove == 29) // wwin the game
                    {
                        Calendar target = Calendar.getInstance();
                        ArchivementController controller = new ArchivementController();
                        ShPrefEnum shPrefEnum = new ShPrefEnum();
                        controller.setNewTimeValueGOT(start,target,view.getContext(), shPrefEnum.slideGameGOT);
                        controller.setNewGOH(shPrefEnum.slideGameGOH, view.getContext());

                        table[previous_loc].setImageResource(0);
                        table[temmove].setImageResource(R.drawable.mario2);
                        table[temmove].startAnimation(animation2);
                        Utils.delay(10, () -> {
                            table[temmove].setImageResource(R.drawable.mario);
                            table[temmove].startAnimation(bounce);
                            soundControl.hooraySoundFun(Slide_game_2_activity.this);
                        });
                        Utils.delay(40, () -> {
                            gif_popUp_controller.show_mario_win(dialog);
                            soundControl.upSoundFun(Slide_game_2_activity.this);
                        });
                        Utils.delay(110, () -> {
                            Intent intent = new Intent();
                            intent.setClass(Slide_game_2_activity.this, Winning_activity_slide_2.class);
                            startActivity(intent);
                        });

                    } else if ((temmove < 29 && temmove >= 0) && (previous_loc < 29 && previous_loc >= 0))// on controll move field
                    {
                        control.getNum(question, txtInput, now_loc, previous_loc, table, view.getContext(), Slide_game_2_activity.this);
                        control.checkAns(question, txtInput, now_loc, Slide_game_2_activity.this, view.getContext());
                        if (temmove == 3 || temmove == 8 || temmove == 17)// activate go up but and moveBut disable
                        {
                            moveBut.setVisibility(View.GONE);
                            upBut.setVisibility(View.VISIBLE);
                            downBut.setVisibility(View.GONE);
                            goUP(table);
                        } else if (temmove == 18 || temmove == 27)// active go down by the slider
                        {
                            moveBut.setVisibility(View.GONE);
                            upBut.setVisibility(View.GONE);
                            downBut.setVisibility(View.VISIBLE);
                            goDOWN(table);
                        }
                    }
                }

            }
        });
        /*
        end code
         */
    }

    private void getIDs() {
        onoffBut = findViewById(R.id.SonoffBut_game2);
        diceBut = findViewById(R.id.dice_game2);
        // questions
        question = findViewById(R.id.questionText);
        txtInput = findViewById(R.id.textInput);
        //get id move charaacter
        moveBut = findViewById(R.id.startMove);
        upBut = findViewById(R.id.upMove);
        downBut = findViewById(R.id.downMove);

        // get image view id for character
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img14 = findViewById(R.id.img14);
        img15 = findViewById(R.id.img15);
        img16 = findViewById(R.id.img16);
        img17 = findViewById(R.id.img17);
        img18 = findViewById(R.id.img18);
        img19 = findViewById(R.id.img19);
        img20 = findViewById(R.id.img20);
        img21 = findViewById(R.id.img21);
        img22 = findViewById(R.id.img22);
        img23 = findViewById(R.id.img23);
        img24 = findViewById(R.id.img24);
        img25 = findViewById(R.id.img25);
        img26 = findViewById(R.id.img26);
        img27 = findViewById(R.id.img27);
        img28 = findViewById(R.id.img28);
        img29 = findViewById(R.id.img29);
        img30 = findViewById(R.id.img30);

        homebut = findViewById(R.id.homeBut);
    }

    void goUP(ImageView table[]) {
        upBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temmove == 3)//location to go up
                {
                    previous_loc = temmove;
                    temmove = 14;
                    now_loc = temmove;
                    control.getNum(question, txtInput, now_loc, previous_loc, table, view.getContext(), Slide_game_2_activity.this);
                    control.checkAns(question, txtInput, now_loc, Slide_game_2_activity.this, view.getContext());
                    moveBut.setVisibility(View.VISIBLE);
                    upBut.setVisibility(View.GONE);
                    downBut.setVisibility(View.GONE);
                }
                if (temmove == 8) {
                    previous_loc = temmove;
                    temmove = 19;
                    now_loc = temmove;
                    control.getNum(question, txtInput, now_loc, previous_loc, table, view.getContext(), Slide_game_2_activity.this);
                    control.checkAns(question, txtInput, now_loc, Slide_game_2_activity.this, view.getContext());
                    moveBut.setVisibility(View.VISIBLE);
                    upBut.setVisibility(View.GONE);
                    downBut.setVisibility(View.GONE);
                }
                if (temmove == 17) {
                    previous_loc = temmove;
                    temmove = 26;
                    now_loc = temmove;
                    control.getNum(question, txtInput, now_loc, previous_loc, table, view.getContext(), Slide_game_2_activity.this);
                    control.checkAns(question, txtInput, now_loc, Slide_game_2_activity.this, view.getContext());
                    moveBut.setVisibility(View.VISIBLE);
                    upBut.setVisibility(View.GONE);
                    downBut.setVisibility(View.GONE);
                }
            }
        });
    }

    void goDOWN(ImageView table[]) {
        downBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temmove == 27) {
                    previous_loc = temmove;
                    temmove = 16;
                    now_loc = temmove;
                    control.getNum(question, txtInput, now_loc, previous_loc, table, view.getContext(), Slide_game_2_activity.this);
                    control.checkAns(question, txtInput, now_loc, Slide_game_2_activity.this, view.getContext());
                    moveBut.setVisibility(View.VISIBLE);
                    upBut.setVisibility(View.GONE);
                    downBut.setVisibility(View.GONE);
                }
                if (temmove == 18) {
                    previous_loc = temmove;
                    temmove = 9;
                    now_loc = temmove;
                    control.getNum(question, txtInput, now_loc, previous_loc, table, view.getContext(), Slide_game_2_activity.this);
                    control.checkAns(question, txtInput, now_loc, Slide_game_2_activity.this, view.getContext());
                    moveBut.setVisibility(View.VISIBLE);
                    upBut.setVisibility(View.GONE);
                    downBut.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.player.release();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onoffBut.setImageResource(sound_on);
        start = Calendar.getInstance();
        soundControl.player.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
        soundControl.player.release();
    }
}