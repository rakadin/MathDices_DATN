package com.example.mathdices;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageButton;

import com.example.mathdices.utils.Utils;

public class RollDiceController {
    SoundControl soundControl = new SoundControl();
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    private int diceNumFinal;
    public int rollTheSixDice(ImageButton diceBut, Context context, Dialog dialog){
        int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
        gif_popUp_controller.show_roll_dice(dialog); // start roll dice gif
        for (int j = 0 ; j < 7;j++){
            diceNumFinal = (int) (Math.random() * 6 + 1); // get dice value from 1
        }
        soundControl.RollSoundFun(context);
        soundControl.rollSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        Utils.delay(30, () -> {
            dialog.dismiss();
            diceBut.setImageResource(images[diceNumFinal-1]);
        });
        return diceNumFinal;
    }
}
