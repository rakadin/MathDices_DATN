package com.example.mathdices;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

import com.example.mathdices.part1.MainActivity;
import com.example.mathdices.part2.Part2_Homepage_Activity;
import com.example.mathdices.utils.Utils;

public class Choose_part_activity extends AppCompatActivity {
    ImageButton p1,p2;
    Dialog dialog ;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_part);
        dialog = new Dialog(this);// dialog
        p1 = findViewById(R.id.part1But);
        p2 = findViewById(R.id.part2But);
        soundControl.themeSongFunc(Choose_part_activity.this);// play theme music in the background
        p1.setOnClickListener(view -> {
            soundControl.touchButFunc(view.getContext());
            Intent intent = new Intent();
            intent.setClass(Choose_part_activity.this, MainActivity.class);
            activateMagicBookGif(dialog, intent);
        });
        p2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(Choose_part_activity.this, Part2_Homepage_Activity.class);
            activateMagicBookGif(dialog, intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.releaseAllSound();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.releaseAllSound();
    }
    private void activateMagicBookGif(Dialog dialog, Intent intent){
        Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
        gif_popUp_controller.show_magic_book(dialog);
        Utils.delay(45, () -> {
            dialog.dismiss();
            startActivity(intent);
        });
    }
}