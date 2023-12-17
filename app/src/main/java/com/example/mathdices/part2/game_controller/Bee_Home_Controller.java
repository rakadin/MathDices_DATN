package com.example.mathdices.part2.game_controller;

import android.app.Dialog;
import android.widget.ImageView;

import com.example.mathdices.Question;
import com.example.mathdices.QuestionPopUpController;
import com.example.mathdices.R;

public class Bee_Home_Controller {
    private QuestionPopUpController controller = new QuestionPopUpController();
    private final int ids[] = {R.drawable.clock_1,R.drawable.clock_2,R.drawable.clock_3,R.drawable.clock_4,R.drawable.clock_5,
            R.drawable.clock_6,0,R.drawable.clock_7,R.drawable.clock_8,R.drawable.clock_9,0,R.drawable.clock_10,
            R.drawable.clock_11,R.drawable.clock_12,0};
    private Question question1 = new Question("Một giờ","Mười hai giờ",
            "Hai giờ","Ba giờ","Một giờ");
    private Question question2 = new Question("Mười hai giờ","Bảy giờ",
            "Tám giờ","Một giờ","Bảy giờ");
    private Question question3 = new Question("Mười một giờ","Chín giờ",
            "Tám giờ","Mười giờ","Mười giờ");
    private Question question4 = new Question("Mười hai giờ","Mười một giờ",
            "Một giờ","Mười giờ","Mười hai giờ");
    private Question question5 = new Question("Ba giờ","Năm giờ",
            "Sáu giờ","Bốn giờ","Sáu giờ");
    private Question question6 = new Question("Chín giờ","Ba giờ",
            "Hai giờ","Bảy giờ","Chín giờ");
    private Question question7 = new Question("null","null",
            "Hai giờ","null","null");
    private Question question8 = new Question("Tám giờ","Hai giờ",
            "Ba giờ","Bảy giờ","Ba giờ");
    private Question question9 = new Question("Chín giờ","Một giờ",
            "Bốn giờ","Năm giờ","Năm giờ");
    private Question question10 = new Question("Mười một giờ","Mười hai giờ",
            "Mười giờ","Năm giờ","Mười một giờ");
    private Question question11 = new Question("null","null",
            "Hai giờ","null","null");
    private Question question12 = new Question("Một giờ","Hai giờ",
            "Ba giờ","Bốn giờ","Hai giờ");
    private Question question13 = new Question("Bảy giờ","Sáu giờ",
            "Ba giờ","Tám giờ","Tám giờ");
    private Question question14 = new Question("Tám giờ","Năm giờ",
            "Ba giờ","Bốn giờ","Bốn giờ");
    private Question question15 = new Question("null","null",
            "Hai giờ","null","null");
    private Question questions[] = {question1,question2,question3,question4,question5,
            question6,question7,question8,question9,question10,
            question11,question12,question13,question14,question15,};
    public void getIMG(int location, ImageView img)
    {
        img.setImageResource(ids[location]);
    }
    public void getClockQuestion(int location, Dialog dialog){
        int imgRes = ids[location];
        Question target = questions[location];
        controller.showImageQuestion(dialog,imgRes,target);
    }
}
