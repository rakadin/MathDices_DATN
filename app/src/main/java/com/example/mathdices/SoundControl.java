package com.example.mathdices;

import static com.example.mathdices.R.drawable.sound_off;
import static com.example.mathdices.R.drawable.sound_on;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
/*
     control all sounds in the project
 */
public class SoundControl extends AppCompatActivity {
    private MediaPlayer player;
    private MediaPlayer up;
    private MediaPlayer fall;
    private MediaPlayer run;
    private MediaPlayer win;
    public MediaPlayer correct;
    public MediaPlayer wrong;
    private MediaPlayer hooray;
    private MediaPlayer popSound;
    private MediaPlayer rollSound;
    public void releaseAllSound(){
        if(player != null){
            player.release();
        }
        if(up != null){
            up.release();
        }
        if(fall != null){
            fall.release();
        }
        if(run != null){
            run.release();
        }
        if(win != null){
            win.release();
        }
        if(correct != null){
            correct.release();
        }
        if(wrong != null){
            wrong.release();
        }
        if(hooray != null){
            hooray.release();
        }
        if(popSound != null){
            popSound.release();
        }
        if(rollSound != null){
            rollSound.release();
        }
    }

    // background sound control
    public void OnOffFun(Activity main, ImageButton onoffBut) {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            onoffBut.setImageResource(sound_on);
            if (player == null) {
                player = MediaPlayer.create(main, R.raw.backgroundmusic);
            }
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                    player = MediaPlayer.create(main, R.raw.backgroundmusic);
                    player.start();
                }
            });
        } else {
            onoffBut.setImageResource(sound_off);
        }

        onoffBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSoundOn = prefManager.getSoundShPref();
                prefManager.setSoundShPref(!isSoundOn);

                if (isSoundOn) {
                    if (player != null) {
                        player.pause();
                    }
                    onoffBut.setImageResource(sound_off);
                } else {
                    onoffBut.setImageResource(sound_on);
                    if (player == null) {
                        player = MediaPlayer.create(main, R.raw.backgroundmusic);
                    }
                    player.start();
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                            player = MediaPlayer.create(main, R.raw.backgroundmusic);
                            player.start();
                        }
                    });
                }
            }
        });
    }

    //play theme song
    public void themeSongFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            player = MediaPlayer.create(context,R.raw.theme_song);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                    player.release();
                }
            });
        }

    }
    // pop sound
    public  void touchButFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            popSound = MediaPlayer.create(context,R.raw.pop);
            popSound.start();
            popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void PopSoundFun(Activity main, ImageButton onoffBut)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            popSound = MediaPlayer.create(main,R.raw.pop);
            popSound.start();
            popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void PopSoundFun2(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            popSound = MediaPlayer.create(main,R.raw.pop);
            popSound.start();
            popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    // roll the dice sound
    public void RollSoundFun(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            rollSound = MediaPlayer.create(context,R.raw.dicerollsound);
            for (int i = 0 ; i < 10;i++)
            {
                rollSound.start();
            }
            rollSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    // wrong sound
    public void wrongSoundFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            wrong = MediaPlayer.create(main,R.raw.wrong);
            wrong.start();
            wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

    }
    // wrong sound
    public void wrongSoundFun2(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            wrong = MediaPlayer.create(context,R.raw.wrong);
            wrong.start();
            wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    // correct sound
    public void correctSoundFun(Context main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main);

        if (prefManager.getSoundShPref()) {
            correct = MediaPlayer.create(main,R.raw.correct);
            correct.start();
            correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

    }
    // winning sound
    public void winSoundFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main);

        if (prefManager.getSoundShPref()) {
            win= MediaPlayer.create(main,R.raw.winning);
            win.start();
            win.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    // running sound
    public void runSoundFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            run= MediaPlayer.create(main,R.raw.running);
            run.start();
            run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void runSoundStopFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            run= MediaPlayer.create(main,R.raw.running);
            run.stop();
            run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

    }
    // go up sound
    public void upSoundFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            up= MediaPlayer.create(main,R.raw.upstair);
            up.start();
            up.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void upSoundStopFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            up= MediaPlayer.create(main,R.raw.upstair);
            up.stop();
            up.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    // falling sound
    public void fallSoundFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            fall= MediaPlayer.create(main,R.raw.fall);
            fall.start();
            fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    // hooray sound
    public void hooraySoundFun2(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            hooray= MediaPlayer.create(context,R.raw.hooray);
            hooray.start();
            hooray.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    // hooray sound
    public void hooraySoundFun(Activity main)
    {
        SharedPrefManager prefManager = new SharedPrefManager(main.getApplicationContext());

        if (prefManager.getSoundShPref()) {
            hooray= MediaPlayer.create(main,R.raw.hooray);
            hooray.start();
            hooray.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

    }
    public void sailingSoundFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            fall= MediaPlayer.create(context,R.raw.ship_sailing_sound);
            fall.start();
            fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void fishingSoundFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            fall= MediaPlayer.create(context,R.raw.fishing_sound);
            fall.start();
            fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void pianoSoundFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            fall= MediaPlayer.create(context,R.raw.piano);
            fall.start();
            fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void machineSoundFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            fall= MediaPlayer.create(context,R.raw.machine_startup);
            fall.start();
            fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

    }
    public void beeSoundFunc(Context context)
    {
        SharedPrefManager prefManager = new SharedPrefManager(context);

        if (prefManager.getSoundShPref()) {
            fall= MediaPlayer.create(context,R.raw.bee_noise);
            fall.start();
            fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void stopShipSailingSound(){
        if(fall != null){
            fall.release();
        }
    }
}
