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
import com.example.mathdices.part2.game_acitivity.Toy_Machine_Activity;

public class Toy_Machine_rule extends AppCompatActivity {
    ImageButton soundBut;
    Button nextBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toy_machine_rule);
        //get id
        soundBut = findViewById(R.id.SonoffBut);
        nextBut = findViewById(R.id.nextBut);

        soundControl.OnOffFun(Toy_Machine_rule.this,soundBut);
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                soundControl.player.release();
                intent.setClass(view.getContext(), Toy_Machine_Activity.class);
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
        soundControl.player.release();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.release();
    }
}