package com.example.mathdices.part1.game_acitivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mathdices.ArchivementController;
import com.example.mathdices.Gif_PopUp_Controller;
import com.example.mathdices.R;
import com.example.mathdices.RollDiceController;
import com.example.mathdices.ShPrefEnum;
import com.example.mathdices.SharedPrefManager;
import com.example.mathdices.SoundControl;
import com.example.mathdices.part1.MainActivity;
import com.example.mathdices.part1.game_controller.GameplayGame1;
import com.example.mathdices.part1.winning_activity.Winningactivity;
import com.example.mathdices.utils.Utils;

import java.util.Calendar;

/*
      game 1 - eggs pick main activity
 */
public class Game1MainActivity extends AppCompatActivity {
    GameplayGame1 gameplayGame1 = new GameplayGame1();
    public SoundControl soundControl = new SoundControl();
    private RollDiceController rollDiceController = new RollDiceController();
    private Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    private Dialog dialog;
    /*
    image view
     */
    private ImageView imgEgg1,imgEgg2,imgEgg3,imgEgg4,imgEgg5,imgEgg6;
    //
    private ImageButton homeBut,onoffBut,diceBut;
    //* button
    private Button grEgg1,grEgg2,grEgg3,grEgg4,grEgg5,grEgg6,grEgg7,redEgg1,redEgg2,redEgg3,yellowEgg1;
    private Button yellowEgg2,purEgg1,purEgg2,blueEgg1,blueEgg2;
    //end egg
    private ImageView imageSwitcher;
    private int diceNumFinal ;
    private int ImageSwitcherImages[] ={R.drawable.game1_pic1};// create images for img switcher
    private int switcherImageLength = ImageSwitcherImages.length;//length get
    private Calendar start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_main);
        start = Calendar.getInstance();
        dialog = new Dialog(this);
        imageSwitcher = findViewById(R.id.imgswt);
        homeBut = findViewById(R.id.homeBut);
        onoffBut = findViewById(R.id.SonoffBut);
        diceBut = findViewById(R.id.dice);
        //* img egg
        imgEgg1 = findViewById(R.id.ans1);
        imgEgg2 = findViewById(R.id.ans2);
        imgEgg3 = findViewById(R.id.ans3);
        imgEgg4 = findViewById(R.id.ans4);
        imgEgg5 = findViewById(R.id.ans5);
        imgEgg6 = findViewById(R.id.ans6);
        ImageView imgViews[] = {imgEgg1,imgEgg3,imgEgg4,imgEgg5,imgEgg6,imgEgg2};
        //get eggbut id

        grEgg1 = findViewById(R.id.grEgg1);
        grEgg2 = findViewById(R.id.grEgg2);
        grEgg3 = findViewById(R.id.grEgg3);
        grEgg4 = findViewById(R.id.grEgg4);
        grEgg5 = findViewById(R.id.grEgg5);
        grEgg6 = findViewById(R.id.grEgg6);
        grEgg7 = findViewById(R.id.grEgg7);
        redEgg1 = findViewById(R.id.redEgg1);
        redEgg2 = findViewById(R.id.redEgg2);
        redEgg3 = findViewById(R.id.redEgg3);
        yellowEgg1 = findViewById(R.id.yellowEgg1);
        yellowEgg2 = findViewById(R.id.yellowEgg2);
        purEgg1 = findViewById(R.id.purEgg1);
        purEgg2 = findViewById(R.id.purEgg2);
        blueEgg1 = findViewById(R.id.blueEgg1);
        blueEgg2 = findViewById(R.id.blueEgg2);

       // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceNumFinal = rollDiceController.rollTheSixDice(diceBut, view.getContext(),dialog);
            }
        });
        // end roll
        /*
        start clicking the eggs
         */
        grEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg1,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        grEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg2,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        grEgg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg3,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        grEgg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg4,Game1MainActivity.this, dialog);
                    winAcOpen();
                }


            }
        });
        grEgg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg5,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        grEgg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg6,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        grEgg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg7,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        redEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,redEgg1,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        redEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,redEgg2,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        redEgg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,redEgg3,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        yellowEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,yellowEgg1,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        yellowEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,yellowEgg2,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        purEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,purEgg1,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        purEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,purEgg2,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        blueEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,blueEgg1,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });
        blueEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    gameplayGame1.gameOn(diceNumFinal,imgViews,blueEgg2,Game1MainActivity.this, dialog);
                    winAcOpen();
                }

            }
        });

// end clicking the eggs
        // make view for image switcher
       imageSwitcher.setImageResource(R.drawable.game1_pic1);
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Game1MainActivity.this,homeBut);
                Intent intent = new Intent();
                intent.setClass(Game1MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imageSwitcher.setImageResource(ImageSwitcherImages[switcherImageLength-1]);
        soundControl.OnOffFun(Game1MainActivity.this,onoffBut);


    }
    // if eggs get ==6 -> open winning activity
    protected  void winAcOpen(){

        Utils.delay(60, () -> { // wait untill gif done and countEgg++
            if(gameplayGame1.countEggs == 6)
            {
                gif_popUp_controller.show_egg_dancing(dialog);
                Calendar target = Calendar.getInstance();
                ArchivementController controller = new ArchivementController();
                ShPrefEnum shPrefEnum = new ShPrefEnum();
                controller.setNewTimeValueGOT(start,target,this, shPrefEnum.eggGameGOT);
                controller.setNewGOH(shPrefEnum.eggGameGOH, this);
                soundControl.hooraySoundFun(Game1MainActivity.this);
                Utils.delay(50, () -> {
                    dialog.dismiss();
                    Intent intent = new Intent();
                    intent.setClass(Game1MainActivity.this, Winningactivity.class);
                    startActivity(intent);
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.releaseAllSound();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        start = Calendar.getInstance();
        soundControl.OnOffFun(Game1MainActivity.this,onoffBut);
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.releaseAllSound();
    }
}