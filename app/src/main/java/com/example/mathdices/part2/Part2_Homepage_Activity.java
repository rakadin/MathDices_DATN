package com.example.mathdices.part2;

import static com.example.mathdices.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.Choose_part_activity;
import com.example.mathdices.R;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part2.game_rules.Bee_Home_rule;
import com.example.mathdices.part2.game_rules.Fishing_2_rule;
import com.example.mathdices.part2.game_rules.GoldIsland_rule;
import com.example.mathdices.part2.game_rules.Mushroom_rule;
import com.example.mathdices.part2.game_rules.Slide_2_rule;
import com.example.mathdices.part2.game_rules.Toy_Machine_rule;

public class Part2_Homepage_Activity extends AppCompatActivity {
    SoundControl soundControl = new SoundControl();
    ImageButton soundbut,bookBut;
    ImageButton  goldisland,fishing,ladder_slide,mushroom,gettoy,beehome;
    ImageButton archivement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_homepage);
        //get ids
        soundbut = findViewById(R.id.SonoffBut);
        goldisland = findViewById(R.id.goldisland);
        fishing = findViewById(R.id.fishing);
        ladder_slide = findViewById(R.id.ladder_slide);
        mushroom = findViewById(R.id.mushroom);
        gettoy = findViewById(R.id.gettoy);
        beehome = findViewById(R.id.beehome);
        bookBut = findViewById(R.id.bookBut);
        archivement = findViewById(R.id.ArchivementBut);
        // get on click button funcs
        goldisland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), GoldIsland_rule.class);
                startActivity(intent);
            }
        });
        bookBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Choose_part_activity.class);
                startActivity(intent);
            }
        });
        fishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Fishing_2_rule.class);
                startActivity(intent);
            }
        });
        ladder_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Slide_2_rule.class);
                startActivity(intent);
            }
        });
        gettoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Toy_Machine_rule.class);
                startActivity(intent);
            }
        });
        mushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Mushroom_rule.class);
                startActivity(intent);
            }
        });
        beehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Bee_Home_rule.class);
                startActivity(intent);
            }
        });
        // function
        soundControl.OnOffFun(Part2_Homepage_Activity.this,soundbut);
        openArchivement();
    }
    private void openArchivement(){
        archivement.setOnClickListener(new View.OnClickListener() {
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
        soundControl.OnOffFun(this,soundbut);
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