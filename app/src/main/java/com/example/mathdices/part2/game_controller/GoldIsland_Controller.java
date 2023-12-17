package com.example.mathdices.part2.game_controller;

import android.app.Dialog;
import android.widget.TextView;

import com.example.mathdices.Question;
import com.example.mathdices.QuestionPopUpController;

public class GoldIsland_Controller {
    private int nums[] = {0, 11, 7, 15, 12, -4, 10, 13, 20, 14, 9, 19, 16, 6, 11, 19, -3, 15, 8, -2, 18, 11, 1, 7, 3, -1, 18, 10, 20, 12, 4, 15, 19, 16, 13, 10, 17, 14, 20, 0};
    // 40 questions
    private Question question1 = new Question("null", "null", "null", "null", "null");
    private Question question2 = new Question("Mười chín", "Mười một", "Mười hai", "Mười bảy", "Mười một");
    private Question question3 = new Question("Bảy", "Tám", "Năm", "Sáu", "Bảy");
    private Question question4 = new Question("Mười hai", "Mười bốn", "Mười lăm", "Mười sáu", "Mười lăm");
    private Question question5 = new Question("Mười lăm", "Mười bốn", "Mười một", "Mười hai", "Mười hai");
    private Question question6 = new Question("null", "null", "null", "null", "null");
    private Question question7 = new Question("Mười", "Một không", "Bảy", "Chín", "Mười");
    private Question question8 = new Question("Mười hai", "Một không", "Một ba", "Mười ba", "Mười ba");

    private Question question9 = new Question("Hai mốt", "Hai mươi", "Hai không", "Mười ba", "Hai mươi");
    private Question question10 = new Question("Hai hai", "Mười bốn", "Mười ba", "Mười hai", "Mười bốn");
    private Question question11 = new Question("Sáu", "Năm", "Chín", "Mười", "Chín");
    private Question question12 = new Question("Một chín", "Mười sáu", "Mười chín", "Mười ba", "Mười chín");
    private Question question13 = new Question("Một chín", "Mười sáu", "Mười chín", "Mười ba", "Mười sáu");
    private Question question14 = new Question("Một", "Sáu", "Chín", "Bảy", "Sáu");
    private Question question15 = new Question("Mười một", "Mười sáu", "Mười chín", "Mười bảy", "Mười một");
    private Question question16 = new Question("Một chín", "Mười chín", "Mười sáu", "Mười tám", "Mười chín");


    private Question question17 = new Question("null", "null", "null", "null", "null");
    private Question question18 = new Question("Mười lăm", "Mười bốn", "Một năm", "Mười sáu", "Mười lăm");
    private Question question19 = new Question("Một", "Sáu", "Tám", "Bảy", "Tám");
    private Question question20 = new Question("null", "null", "null", "null", "null");
    private Question question21 = new Question("Mười lăm", "Mười bốn", "Một tám", "Mười tám", "Mười tám");
    private Question question22 = new Question("Mười chín", "Mười bảy", "Mười hai", "Mười một", "Mười một");
    private Question question23 = new Question("Một", "Sáu", "Tám", "Bảy", "Một");
    private Question question24 = new Question("Một", "Sáu", "Tám", "Bảy", "Bảy");
    private Question question25 = new Question("Một", "Bảy", "Tám", "Ba", "Ba");
    private Question question26 = new Question("null", "null", "null", "null", "null");
    private Question question27 = new Question("Mười tám", "Mười bốn", "Một tám", "Mười lăm", "Mười tám");
    private Question question28 = new Question("Mười một", "Một không", "Bảy", "Mười", "Mười");
    private Question question29 = new Question("Hai ba", "Hai tám", "Hai không", "Hai mươi", "Hai mươi");
    private Question question30 = new Question("Mười tám", "Mười hai", "Một tám", "Mười bảy", "Mười hai");
    private Question question31 = new Question("Bốn", "Một", "Hai", "Ba", "Bốn");


    private Question question32 = new Question("Mười sáu", "Mười hai", "Mười tám", "Mười lăm", "Mười lăm");
    private Question question33 = new Question("Mười sáu", "Mười hai", "Mười tám", "Mười chín", "Mười chín");
    private Question question34 = new Question("Mười ba", "Mười sáu", "Mười tám", "Mười bảy", "Mười sáu");
    private Question question35 = new Question("Mười hai", "Mười bảy", "Mười tám", "Mười ba", "Mười ba");
    private Question question36 = new Question("Bảy", "Một", "Mười", "Tám", "Mười");
    private Question question37 = new Question("Mười bảy", "Mười hai", "Mười tám", "Mười lăm", "Mười bảy");
    private Question question38 = new Question("Mười bảy", "Mười hai", "Mười tám", "Mười bốn", "Mười bốn");
    private Question question39 = new Question("Mười bảy", "Mười tám", "Hai mươi", "Mười một", "Hai mươi");
    private Question question40 = new Question("null", "null", "null", "null", "null");
    private Question[] questions = {question1, question2, question3, question4, question5, question6, question7, question8, question9, question10,
            question11, question12, question13, question14, question15, question16, question17, question18, question19, question20,
            question21, question22, question23, question24, question25, question26, question27, question28, question29, question30,
            question31, question32, question33, question34, question35, question36, question37, question38, question39, question40,};
    private QuestionPopUpController questionPopUpController = new QuestionPopUpController();

    public void show_num(TextView num_now, int location) {
        num_now.setText("" + nums[location - 1]);
    }

    public void showQuestion(Dialog dialog, int location) {
        questionPopUpController.showTextQuestion(dialog, nums[location - 1], questions[location - 1]);
    }
}
