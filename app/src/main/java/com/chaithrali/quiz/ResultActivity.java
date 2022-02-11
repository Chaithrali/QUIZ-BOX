package com.chaithrali.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tvcorrectans,tvwrongans,tvfinalscore;
    Button restartbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvcorrectans=(TextView)findViewById(R.id.tvCorrect);
        tvwrongans=(TextView)findViewById(R.id.tvWrong);
        tvfinalscore=(TextView)findViewById(R.id.tvFinal);
        restartbtn=(Button) findViewById(R.id.btnRestart);

        StringBuffer sb=new StringBuffer();
        sb.append("CORRECT ANSWERS:" + QuestionActivity.correct + "\n");
        StringBuffer sb2=new StringBuffer();
        sb2.append("WRONG ANSWERS:" + QuestionActivity.wrong + "\n");
        StringBuffer sb3=new StringBuffer();
        sb3.append("FINAL SCORE:" + QuestionActivity.correct + "\n");
        tvcorrectans.setText(sb);
        tvwrongans.setText(sb2);
        tvfinalscore.setText(sb3);
        QuestionActivity.correct=0;
        QuestionActivity.wrong=0;

        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(restartIntent);
            }
        });

    }
}