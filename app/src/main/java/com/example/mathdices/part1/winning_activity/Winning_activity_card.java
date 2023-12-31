package com.example.mathdices.part1.winning_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_acitivity.Card_game_main;
import com.example.mathdices.part1.MainActivity;

public class Winning_activity_card extends AppCompatActivity {
    Button replayBut;
    Button menuBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_win);
        soundControl.winSoundFun(Winning_activity_card.this);
        replayBut = findViewById(R.id.replayBut);
        menuBut = findViewById(R.id.menuBut);
        replayBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Winning_activity_card.this);
                Intent intent = new Intent();
                intent.setClass(Winning_activity_card.this, Card_game_main.class);
                startActivity(intent);
            }
        });
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Winning_activity_card.this);
                Intent intent = new Intent();
                intent.setClass(Winning_activity_card.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        soundControl.releaseAllSound();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.releaseAllSound();
    }
}