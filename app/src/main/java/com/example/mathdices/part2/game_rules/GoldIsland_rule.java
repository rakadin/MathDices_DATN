package com.example.mathdices.part2.game_rules;

import static com.example.mathdices.R.drawable.sound_on;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part2.game_acitivity.GoldIslandActivity;

public class GoldIsland_rule extends AppCompatActivity {
    ImageButton soundBut;
    Button nextBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_island_rule);
        //get id
        soundBut = findViewById(R.id.SonoffBut);
        nextBut = findViewById(R.id.nextBut);

        soundControl.OnOffFun(GoldIsland_rule.this,soundBut);
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), GoldIslandActivity.class);
                startActivity(intent);
            }
        });
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