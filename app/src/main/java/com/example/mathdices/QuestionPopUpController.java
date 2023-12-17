package com.example.mathdices;

import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionPopUpController {

    public void showTextQuestion(Dialog dialog, int qText, Question questionIn) {
        dialog.setContentView(R.layout.question_dialog);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        TextView questionT = dialog.findViewById(R.id.questionInp);
        TextView question = dialog.findViewById(R.id.questionTextview);
        ImageView questionImg = dialog.findViewById(R.id.questionIntputImg);
        TextView ans1 = dialog.findViewById(R.id.answer1);
        TextView ans2 = dialog.findViewById(R.id.answer2);
        TextView ans3 = dialog.findViewById(R.id.answer3);
        TextView ans4 = dialog.findViewById(R.id.answer4);
        questionT.setVisibility(View.VISIBLE);
        questionImg.setVisibility(View.GONE);
        question.setText("Câu hỏi: Cách đọc nào đúng với số dưới đây?");
        questionT.setText("" + qText);
        ans1.setText(questionIn.getAnswer1());
        ans2.setText(questionIn.getAnswer2());
        ans3.setText(questionIn.getAnswer3());
        ans4.setText(questionIn.getAnswer4());
        dialog.show();
        checkClickAns(ans1, questionIn.getCorrect(), dialog);
        checkClickAns(ans2, questionIn.getCorrect(), dialog);
        checkClickAns(ans3, questionIn.getCorrect(), dialog);
        checkClickAns(ans4, questionIn.getCorrect(), dialog);
    }
    public void showImageQuestion(Dialog dialog, int imgRes, Question questionIn) {
        dialog.setContentView(R.layout.question_dialog);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        TextView questionT = dialog.findViewById(R.id.questionInp);
        TextView question = dialog.findViewById(R.id.questionTextview);
        ImageView questionImg = dialog.findViewById(R.id.questionIntputImg);
        TextView ans1 = dialog.findViewById(R.id.answer1);
        TextView ans2 = dialog.findViewById(R.id.answer2);
        TextView ans3 = dialog.findViewById(R.id.answer3);
        TextView ans4 = dialog.findViewById(R.id.answer4);
        questionT.setVisibility(View.INVISIBLE);
        questionImg.setVisibility(View.VISIBLE);
        question.setText("Câu hỏi: Đồng hồ dưới đây chỉ mấy giờ?");
        questionImg.setImageResource(imgRes);
        ans1.setText(questionIn.getAnswer1());
        ans2.setText(questionIn.getAnswer2());
        ans3.setText(questionIn.getAnswer3());
        ans4.setText(questionIn.getAnswer4());
        dialog.show();
        checkClickAns(ans1, questionIn.getCorrect(), dialog);
        checkClickAns(ans2, questionIn.getCorrect(), dialog);
        checkClickAns(ans3, questionIn.getCorrect(), dialog);
        checkClickAns(ans4, questionIn.getCorrect(), dialog);
    }
    private void checkClickAns(TextView textView, String correctAns, Dialog dialog) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundControl soundControl = new SoundControl();
                if (textView.getText().equals(correctAns)) {
                    soundControl.correctSoundFun(view.getContext());
                    Toast.makeText(view.getContext(), "Đúng rồi!!!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    textView.setBackgroundResource(R.drawable.red_rounded_button);
                    soundControl.wrongSoundFun2(view.getContext());
                    Toast.makeText(view.getContext(), "Sai rồi!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
