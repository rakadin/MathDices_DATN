package com.example.mathdices;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageButton;

import com.example.mathdices.part2.game_acitivity.Mushroom_Activity;
import com.example.mathdices.utils.Utils;

public class RollDiceController {
    private SoundControl soundControl = new SoundControl();
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    int dice_num[] = {6,12,34,35,50,67};// dice variable
    private int diceNumFinal;
    public int rollTheSixDice(ImageButton diceBut, Context context, Dialog dialog){
        ArchivementController controller = new ArchivementController();
        int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
        gif_popUp_controller.show_roll_dice(dialog); // start roll dice gif
        for (int j = 0 ; j < 7;j++){
            diceNumFinal = (int) (Math.random() * 6 + 1); // get dice value from 1
        }
        controller.setNewDiceRollCount(1,context);//add to shrPref
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
    public int rollTheNumDice(ImageButton diceBut, Context context, Dialog dialog){
        ArchivementController controller = new ArchivementController();
        int images[] = {R.drawable.num_dice_6,R.drawable.num_dice_12,R.drawable.num_dice_34,R.drawable.num_dice_35,R.drawable.num_dice_50,R.drawable.num_dice_67};
        gif_popUp_controller.show_roll_dice(dialog); // start roll dice gif
        int temDiceNum = 0;
        for (int j = 0 ; j < 7;j++){
             temDiceNum= (int) (Math.random() * 6 + 1); // get dice value from 1
            diceNumFinal = dice_num[temDiceNum-1];
        }
        controller.setNewDiceRollCount(1,context);//add to shrPref
        soundControl.RollSoundFun(context);
        soundControl.rollSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        int finalTemDiceNum = temDiceNum;
        Utils.delay(30, () -> {
            dialog.dismiss();
            diceBut.setImageResource(images[finalTemDiceNum -1]);
        });
        return diceNumFinal;
    }
}
