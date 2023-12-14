package com.example.mathdices;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.mathdices.part1.game_acitivity.MainActivity;
import com.example.mathdices.part2.Part2_Homepage_Activity;

import java.util.Objects;

public class Choose_part_activity extends AppCompatActivity {
    ImageButton p1,p2;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_part);
//        Objects.requireNonNull(getSupportActionBar()).hide();
        p1 = findViewById(R.id.part1But);
        p2 = findViewById(R.id.part2But);
        soundControl.themeSongFunc(Choose_part_activity.this);// play theme music in the background
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.touchButFunc(view.getContext());
                Intent intent = new Intent();
                intent.setClass(Choose_part_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Choose_part_activity.this, Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
    }

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