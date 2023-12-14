package com.example.mathdices.part1.game_rules;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_acitivity.Card_game_main;

public class Card_game_introduction extends AppCompatActivity {
    ImageButton onoffBut;
    SoundControl soundControl = new SoundControl();
    Button game1But;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_game_introduction);
        onoffBut = findViewById(R.id.SonoffBut2);
        game1But = findViewById(R.id.nextBut2);
        soundControl.OnOffFun(Card_game_introduction.this,onoffBut);

        // next game 1 main activity function
        game1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Card_game_introduction.this,game1But);
                Intent intent = new Intent();
                intent.setClass(Card_game_introduction.this , Card_game_main.class);
                startActivity(intent);
                soundControl.player.pause();
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
        soundControl.player.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
        soundControl.player.release();
    }
}