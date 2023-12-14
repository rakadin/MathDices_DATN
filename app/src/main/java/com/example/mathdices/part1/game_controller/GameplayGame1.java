package com.example.mathdices.part1.game_controller;

import android.app.Activity;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
/*
game 1- eggs pick control the gameplay class
 */
public class GameplayGame1 extends AppCompatActivity {
    public int countEggs =0;
    SoundControl soundControl = new SoundControl();
    public void gameOn(int diceNum, ImageView imgEgg[], Button butClick, Activity main)
    {
       int temID =  butClick.getId();
        switch (diceNum)
        {
            case 1:
            {
                if(  temID == R.id.grEgg3 ||temID == R.id.grEgg4 )
                {
                    soundControl.correctSoundFun(main);
                    butClick.setBackgroundResource(R.drawable.xsign);
                    butClick.setClickable(false);
                    imgEgg[countEggs].setImageResource(R.drawable.green_egg);
                    countEggs++;
                    soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                else {
                    soundControl.wrongSoundFun(main);
                    soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                break;
            }
            case 2:
            {
                if(  temID == R.id.grEgg2 ||temID == R.id.grEgg7 || temID == R.id.yellowEgg2 || temID == R.id.redEgg1 )
                {
                    soundControl.correctSoundFun(main);
                    butClick.setBackgroundResource(R.drawable.xsign);
                    butClick.setClickable(false);
                    if(temID == R.id.yellowEgg2)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.yellow_egg);
                    }
                    if(temID == R.id.redEgg1)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.red_egg);
                    }
                    if(temID == R.id.grEgg2 ||temID == R.id.grEgg7)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.green_egg);
                    }
                    countEggs++;
                    soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                else {
                    soundControl.wrongSoundFun(main);
                    soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                break;
            }
            case 3:
            {
                if(  temID == R.id.redEgg2 ||temID == R.id.redEgg3 ||temID == R.id.purEgg2 )
                {
                    soundControl.correctSoundFun(main);
                    butClick.setBackgroundResource(R.drawable.xsign);
                    butClick.setClickable(false);
                    if(temID == R.id.purEgg2)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.purple_egg);
                    }
                    if(temID == R.id.redEgg2 ||temID == R.id.redEgg3)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.red_egg);
                    }
                    countEggs++;
                    soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                else {
                    soundControl.wrongSoundFun(main);
                    soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                break;
            }
            case 4:
            {
                if(  temID == R.id.yellowEgg1 ||temID == R.id.blueEgg2 )
                {
                    soundControl.correctSoundFun(main);
                    butClick.setBackgroundResource(R.drawable.xsign);
                    butClick.setClickable(false);
                    if(temID == R.id.yellowEgg1)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.yellow_egg);
                    }
                    if(temID == R.id.blueEgg2 )
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.blue_egg);
                    }
                    countEggs++;
                    soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                else {
                    soundControl.wrongSoundFun(main);
                    soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                break;
            }
            case 5:
            {
                if(  temID == R.id.grEgg5 ||temID == R.id.grEgg6 ||temID == R.id.purEgg1)
                {
                    soundControl.correctSoundFun(main);
                    butClick.setBackgroundResource(R.drawable.xsign);
                    butClick.setClickable(false);
                    if(temID == R.id.purEgg1)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.purple_egg);
                    }
                    if( temID == R.id.grEgg5 ||temID == R.id.grEgg6)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.green_egg);
                    }
                    countEggs++;
                    soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                else {
                    soundControl.wrongSoundFun(main);
                    soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                break;
            }
            case 6:
            {
                if(  temID == R.id.grEgg1 ||temID == R.id.blueEgg1 )
                {
                    soundControl.correctSoundFun(main);
                    butClick.setBackgroundResource(R.drawable.xsign);
                    butClick.setClickable(false);
                    if(temID == R.id.blueEgg1)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.blue_egg);
                    }
                    if( temID == R.id.grEgg1)
                    {
                        imgEgg[countEggs].setImageResource(R.drawable.green_egg);
                    }
                    countEggs++;
                    soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                else {
                    soundControl.wrongSoundFun(main);
                    soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
                break;
            }
        }


    }
}
