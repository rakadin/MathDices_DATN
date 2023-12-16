package com.example.mathdices.part1.winning_activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_acitivity.Game1MainActivity;
import com.example.mathdices.part1.MainActivity;

/*
  winning archive activity -> navigate to home or play again - game 1 - eggs picking
 */
public class Winningactivity extends AppCompatActivity {
    Button replayBut;
    Button menuBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_win);
        soundControl.winSoundFun(Winningactivity.this);
        soundControl.win.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        replayBut = findViewById(R.id.replayBut);
        menuBut = findViewById(R.id.menuBut);
        replayBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                soundControl.PopSoundFun(Winningactivity.this,);
                soundControl.PopSoundFun2(Winningactivity.this,replayBut);
                Intent intent = new Intent();
                intent.setClass(Winningactivity.this, Game1MainActivity.class);
                startActivity(intent);
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
//                soundControl.player.pause();
            }
        });
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Winningactivity.this,replayBut);
                Intent intent = new Intent();
                intent.setClass(Winningactivity.this, MainActivity.class);
                startActivity(intent);
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        soundControl.win.stop();
        soundControl.win.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.win.release();
    }
}