package com.example.mathdices.part1.winning_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_acitivity.MainActivity;
import com.example.mathdices.part1.game_acitivity.Slide_game_main;

public class Winning_activity_Slide extends AppCompatActivity {
    Button replayBut;
    Button menuBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_win);
        soundControl.winSoundFun(Winning_activity_Slide.this);
        replayBut = findViewById(R.id.replayBut);
        menuBut = findViewById(R.id.menuBut);
        replayBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                soundControl.PopSoundFun(Winningactivity.this,);
                soundControl.PopSoundFun2(Winning_activity_Slide.this,replayBut);
                Intent intent = new Intent();
                intent.setClass(Winning_activity_Slide.this, Slide_game_main.class);
                startActivity(intent);
//                soundControl.player.pause();
            }
        });
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Winning_activity_Slide.this,replayBut);
                Intent intent = new Intent();
                intent.setClass(Winning_activity_Slide.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        soundControl.win.stop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.win.release();
    }
}