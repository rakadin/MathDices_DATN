package com.example.mathdices.part1.game_rules;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_acitivity.Game1MainActivity;

/*
game 1 - egg pick introduction
 */
public class Game1 extends AppCompatActivity {
    ImageButton onoffBut;
    SoundControl soundControl = new SoundControl();
    Button game1But;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        onoffBut = findViewById(R.id.SonoffBut);
        game1But = findViewById(R.id.nextBut);
        soundControl.OnOffFun(Game1.this,onoffBut);

        // next game 1 main activity function
        game1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Game1.this);
                Intent intent = new Intent();
                intent.setClass(Game1.this, Game1MainActivity.class);
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
        soundControl.OnOffFun(Game1.this,onoffBut);
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.releaseAllSound();
    }
}