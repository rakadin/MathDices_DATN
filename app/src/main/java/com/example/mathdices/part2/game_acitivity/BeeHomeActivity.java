package com.example.mathdices.part2.game_acitivity;

import static com.example.mathdices.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.ShPrefEnum;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part2.Part2_Homepage_Activity;
import com.example.mathdices.part2.game_controller.Bee_Home_Controller;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.part2.winning_activity.Winning_activity_bee_home;
import com.example.mathdices.utils.Utils;

import java.util.Calendar;

import pl.droidsonroids.gif.GifImageView;


public class BeeHomeActivity extends AppCompatActivity {
    private SoundControl soundControl = new SoundControl();
    private ImageButton soundBut,homeBut,diceBut;
    private Dialog dialog ;
    private Bee_Home_Controller controller = new Bee_Home_Controller();
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();// call controller
    private RollDiceController rollDiceController = new RollDiceController();
    private int diceNumFinal = 0;
    private int now_loc =0, previous_loc =0;
    private Button moveBut,getHBut;
    private GifImageView clock_1,clock_2,clock_3,clock_4,clock_5,clock_6,clock_7,clock_8,clock_9,clock_10,
            clock_11,clock_12,clock_13,clock_14,clock_15;
    private ImageView clock_now;
    private Calendar start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bee_home);
        start = Calendar.getInstance();
        dialog = new Dialog(BeeHomeActivity.this);// dialog
        // get idS
        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);
        moveBut = findViewById(R.id.moveBut);
        getHBut = findViewById(R.id.getHBut);
        clock_now = findViewById(R.id.clock_now);
        getid();
        GifImageView clocks[] = {clock_1,clock_2,clock_3,clock_4,clock_5,clock_6,clock_7,clock_8,clock_9,clock_10,
                clock_11,clock_12,clock_13,clock_14,clock_15};
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
                    previous_loc = now_loc;
                    now_loc += diceNumFinal;
                    if(now_loc > 15)// if move > 15
                    {
                        now_loc -= diceNumFinal;
                        previous_loc = now_loc;
                    }
                    else
                    {
                        if(previous_loc >0)// previous lock must > 0
                        {
                            clocks[previous_loc-1].setImageResource(0);
                        }
                        soundControl.beeSoundFunc(view.getContext());
                        gif_popUp_controller.show_bee_yeah(dialog);
                        Utils.delay(50, () -> {
                            Boolean flag = false;
                            soundControl.fall.release();
                            dialog.dismiss();
                            clocks[now_loc-1].setImageResource(R.drawable.bee_gif);
                            controller.getIMG(now_loc-1,clock_now);
                            Dialog questionDialog = new Dialog(view.getContext());
                            if(now_loc == 15)
                            {
                                flag = true;
                                gif_popUp_controller.show_bee_home(dialog);
                                soundControl.hooraySoundFun2(view.getContext());
                                Utils.delay(50, () -> {
                                   winner(view.getContext());
                                });
                            }
                            if(now_loc == 11 || now_loc == 7)
                            {
                                flag = true;
                                moveBut.setVisibility(View.GONE);
                                getHBut.setVisibility(View.VISIBLE);
                                HButFunc();
                            }

                            if(flag != true){ // go home -> no question dialog
                                controller.getClockQuestion(now_loc-1, questionDialog);
                            }
                        });


                    }
                }
            }
        });


    }
    void HButFunc()
    {
        getHBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gif_popUp_controller.show_bee_home(dialog);
                soundControl.hooraySoundFun2(view.getContext());
                Utils.delay(50, () -> {
                    winner(view.getContext());
                });
            }
        });
    }
    void winner(Context context)
    {
        Calendar target = Calendar.getInstance();
        ArchivementController controller = new ArchivementController();
        ShPrefEnum shPrefEnum = new ShPrefEnum();
        controller.setNewTimeValueGOT(start,target,this, shPrefEnum.beeGameGOT);
        controller.setNewGOH(shPrefEnum.beeGameGOH, this);

        Intent intent = new Intent();
        intent.setClass(context, Winning_activity_bee_home.class);
        startActivity(intent);
    }
    // get clock id
    void getid()
    {
        clock_1 = findViewById(R.id.clock_1);
        clock_2 = findViewById(R.id.clock_2);
        clock_3 = findViewById(R.id.clock_3);
        clock_4 = findViewById(R.id.clock_4);
        clock_5 = findViewById(R.id.clock_5);
        clock_6 = findViewById(R.id.clock_6);
        clock_7 = findViewById(R.id.clock_7);
        clock_8 = findViewById(R.id.clock_8);
        clock_9 = findViewById(R.id.clock_9);
        clock_10 = findViewById(R.id.clock_10);
        clock_11 = findViewById(R.id.clock_11);
        clock_12 = findViewById(R.id.clock_12);
        clock_13 = findViewById(R.id.clock_13);
        clock_14 = findViewById(R.id.clock_14);
        clock_15 = findViewById(R.id.clock_15);
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
    int rollDice()
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
        return diceNumFinal;

    }

    // if restart set activity again
    @Override
    protected void onRestart() {
        super.onRestart();
        soundBut.setImageResource(sound_on);
        start = Calendar.getInstance();
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