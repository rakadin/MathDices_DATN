package com.example.mathdices.part2.game_acitivity;

import static com.example.mathdices.R.drawable.sound_on;
import static com.example.mathdices.R.drawable.xsign;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.ShPrefEnum;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part2.Part2_Homepage_Activity;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.part2.game_controller.Mushroom_Controller;
import com.example.mathdices.part2.winning_activity.Winning_activity_mushroom;
import com.example.mathdices.utils.Utils;

import java.util.Calendar;

public class Mushroom_Activity extends AppCompatActivity {
    private ImageButton soundBut, homeBut, diceBut;
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    private SoundControl soundControl = new SoundControl();
    private Mushroom_Controller controller = new Mushroom_Controller();
    private int diceNumFinal = 0;
    private int count = 0;
    private Dialog dialog;
    private ImageButton move_0, move_1, move_2, move_3, move_4, move_5;
    private Calendar start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom);
        start = Calendar.getInstance();
        dialog = new Dialog(Mushroom_Activity.this);

        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);

        // set sound but func
        soundControl.OnOffFun(Mushroom_Activity.this, soundBut);
        setHomeBut();
        rollDice();
        getmoveID();
        // set move_ids
        ImageButton moves[] = {move_0, move_1, move_2, move_3, move_4, move_5};


        for (int i = 0; i <= 5; i++) {
            int tem = i;
            moves[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (diceNumFinal == 0) // make sure that users have roll the dice first
                    {
                        Toast.makeText(view.getContext(), "Bạn cần xúc xắc trước đã!", Toast.LENGTH_LONG).show();
                    } else {
                        soundControl.pianoSoundFunc(view.getContext());
                        gif_popUp_controller.show_mushroom_picker(dialog);
                        Utils.delay(40, () -> {
                            soundControl.fall.release();
                            dialog.dismiss();
                            checkAns(tem, moves, view.getContext());
                        });
                    }

                }
            });
        }
    }

    void checkAns(int tem, ImageButton moves[], Context context)// checking ans
    {
        boolean check = controller.getAns(diceNumFinal, tem);
        if (check == true) {
            soundControl.correctSoundFun(Mushroom_Activity.this);
            gif_popUp_controller.show_mushroom_yeah(dialog);
            Utils.delay(40, () -> {
                dialog.dismiss();
                moves[tem].setImageResource(xsign);// set xsign to mushroom
                moves[tem].setClickable(false); // cant click after xsign
                count++; // mushroom ++
                if (count == 4) {
                    winning(context, dialog);
                }
            });
        } else {
            soundControl.wrongSoundFun(Mushroom_Activity.this);
            gif_popUp_controller.show_mushroom_sad(dialog);
            Utils.delay(50, () -> {
                dialog.dismiss();
            });
        }
    }

    void winning(Context context, Dialog dialog)// check and open winning
    {
        if (count == 4) {
            Calendar target = Calendar.getInstance();
            ArchivementController controller = new ArchivementController();
            ShPrefEnum shPrefEnum = new ShPrefEnum();
            controller.setNewTimeValueGOT(start,target,this, shPrefEnum.mushroomGameGOT);
            controller.setNewGOH(shPrefEnum.mushroomGameGOH, this);

            soundControl.hooraySoundFun2(context);
            gif_popUp_controller.show_mushroom_yeah(dialog);
            Utils.delay(80, () -> {
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setClass(Mushroom_Activity.this, Winning_activity_mushroom.class);
                startActivity(intent);
            });

        }
    }

    // home button func
    void setHomeBut() {
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Mushroom_Activity.this, Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
    }

    // roll the dicefunc
    int rollDice() {
        // dice button controll
        // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RollDiceController rollDiceController = new RollDiceController();
                diceNumFinal = rollDiceController.rollTheNumDice(diceBut, view.getContext(), dialog);
            }

        });

        // end roll
        return diceNumFinal;

    }

    void getmoveID() {
        move_0 = findViewById(R.id.mushroom_1);
        move_1 = findViewById(R.id.mushroom_2);
        move_2 = findViewById(R.id.mushroom_3);
        move_3 = findViewById(R.id.mushroom_4);
        move_4 = findViewById(R.id.mushroom_5);
        move_5 = findViewById(R.id.mushroom_6);

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
        if (soundControl.player != null) {
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