package com.example.mathdices.part1.game_rules;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_acitivity.Fishing_game_main;

public class Fishing_introduction extends AppCompatActivity {
    ImageButton onoffBut;
    SoundControl soundControl = new SoundControl();
    Button game1But;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_introduction);
        onoffBut = findViewById(R.id.SonoffBut2);
        game1But = findViewById(R.id.nextBut2);
        soundControl.OnOffFun(Fishing_introduction.this,onoffBut);

        // next game 1 main activity function
        game1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Fishing_introduction.this);
                Intent intent = new Intent();
                intent.setClass(Fishing_introduction.this , Fishing_game_main.class);
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
        soundControl.OnOffFun(Fishing_introduction.this,onoffBut);
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.releaseAllSound();
    }
}