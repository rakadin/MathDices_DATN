package com.example.mathdices.part1;

import static com.example.mathdices.R.drawable.*;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.Choose_part_activity;
import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.game_rules.Game1;
import com.example.mathdices.part1.game_rules.Card_game_introduction;
import com.example.mathdices.part1.game_rules.Chicken_game_introduction;
import com.example.mathdices.part1.game_rules.Fishing_introduction;
import com.example.mathdices.part1.game_rules.Slide_introduction;

/*
 home activity that navigate to 5 games
 */
public class MainActivity extends AppCompatActivity {
    SoundControl soundControl = new SoundControl();
    ImageButton onoffBut;
    ImageButton game1But;
    ImageButton game2But;
    ImageButton game3But;
    ImageButton game4But;
    ImageButton game5But,bookBut, archivementBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onoffBut = findViewById(R.id.book1_sOnOffBut);
        game1But = findViewById(R.id.eggcatch);
        game2But = findViewById(R.id.slide);
        game3But = findViewById(R.id.fishcatch);
        game4But = findViewById(R.id.chicken);
        game5But = findViewById(R.id.cardch);
        bookBut = findViewById(R.id.bookBut);
        archivementBut = findViewById(R.id.ArchivementBut);
        // choose book
        bookBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Choose_part_activity.class);
                startActivity(intent);
            }
        });
        //onlick for game 1
        game1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game1But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Game1.class);
                startActivity(intent);
            }
        });
        game2But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game2But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Slide_introduction.class);
                startActivity(intent);
            }
        });
        game3But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game3But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Fishing_introduction.class);
                startActivity(intent);
            }
        });
        game4But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game4But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Card_game_introduction.class);
                startActivity(intent);
            }
        });
        game5But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game4But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Chicken_game_introduction.class);
                startActivity(intent);
            }
        });
        soundControl.OnOffFun(MainActivity.this,onoffBut);
        openArchivement();
    }
    private void openArchivement(){
        archivementBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog archivementDialog = new Dialog(view.getContext());
                ArchivementController controller = new ArchivementController();
                controller.activateArchivementDialog(archivementDialog, view.getContext());
            }
        });
    }
// if restart set activity again
    @Override
    protected void onRestart() {
        super.onRestart();
        soundControl.OnOffFun(MainActivity.this,onoffBut);
    }
// if destroy stop music
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
}