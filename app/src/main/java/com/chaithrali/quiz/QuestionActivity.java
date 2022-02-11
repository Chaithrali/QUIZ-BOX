package com.chaithrali.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuestionActivity extends AppCompatActivity {
    TextView tvQues;
    Button buttonSubmit, buttonQuit;
    RadioGroup radioGroup;
    RadioButton rb1,rb2,rb3,rb4;
    TextView counterTimer;
    CountDownTimer count=new CountDownTimer(180000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            long minutes=millisUntilFinished/ (60 * 1000) % 60;
            long Seconds =millisUntilFinished/ 1000 % 60;
            counterTimer.setText("" +minutes+":"+Seconds);
        }

        @Override
        public void onFinish() {
            marks=correct;
            Intent resultIntent = new Intent(getApplicationContext(),ResultActivity.class);
            startActivity(resultIntent);

        }
    };


    String question[]={
                        "1.Which of the following converts Java byte code into Dalvik byte code?",
                        "2.Which of the following is contained in the src folder?",
                        "3.Which of the following class in android displays information for a short period of time and disappears after sometime?",
                        "4.What runs in the background and doesn't have any UI components?",
                        "5.During an Activity life-cycle what is the first callback method invoked by the system?",
                        "6.What activity method you use to retrieve a reference to an Android view by using the id attribute of a resources XML?",
                        "7._________can be used as a messaging system across apps and outside of the normal user flow",
                        "8.Android is based on Linux for the following reason.",
                        "9.The XML file that contains all the text your application uses.",
                        "10.The error tab in Android Studio is called?"

    };
    String answers[]={"Dex Compiler","Java source code","toast class","Services","onCreate()","findViewById(int id)","Broadcast","All of these","strings.xml","logcat"};
    String opt[]={
                    "Dalvik converter","Dex Compiler","Mobile interpretive compiler(MIC)","None of these",
                    "XML","Java source code","Manifest","None of the above",
                    "toast class","log class","marketest class","None of the above",
                    "Content Providers","Applications","Intents","Services",
                    "onStart()","onStop()","onRestore()","onCreate()",
                    "findViewById(String id)","findViewByReference(int id)","findViewById(int id)","retrieveResourceById(int id)",
                    "Service","Intent","Process","Broadcast",
                    "Networking","Security","Portability","All of these",
                    "stack.xml","strings.java","strings.xml","text.xml",
                    "CPU","memory","logcat","log"

    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        final TextView score=(TextView)findViewById(R.id.tvDisplayScore);
        TextView tvDispName=(TextView)findViewById(R.id.tvDisplayName);
        counterTimer=(TextView)findViewById(R.id.tvTimer);
        count.start();
        Intent intent=getIntent();
        String name=intent.getStringExtra("myname");
        if (name.trim().equals("")){
            tvDispName.setText("HELLO USER");
        }
        else
            tvDispName.setText("Hello " + name);

        buttonSubmit=(Button)findViewById(R.id.btnSubmit);
        buttonQuit=(Button)findViewById(R.id.btnQuit);
        tvQues=(TextView)findViewById(R.id.tvQuestion);

        radioGroup=(RadioGroup)findViewById(R.id.answerGroup);
        rb1=(RadioButton)findViewById(R.id.option1);
        rb2=(RadioButton)findViewById(R.id.option2);
        rb3=(RadioButton)findViewById(R.id.option3);
        rb4=(RadioButton)findViewById(R.id.option4);

        tvQues.setText(question[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(QuestionActivity.this, "Please Select one choice..!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans=(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                String ansText=uans.getText().toString();
//                Toast.makeText(QuestionActivity.this, "answer", Toast.LENGTH_LONG).show();
                if (ansText.equals(answers[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity.this, "CORRECT...", Toast.LENGTH_SHORT).show();
                }
                else{
                     wrong++;
                    Toast.makeText(QuestionActivity.this, "WRONG!!", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if (score!=null){
                    score.setText("" +correct);
                }
                if (flag<question.length)
                {
                    tvQues.setText(question[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4+1]);
                    rb3.setText(opt[flag*4+2]);
                    rb4.setText(opt[flag*4+3]);
                }
                else
                {
                    marks=correct;
                    Intent resultIntent = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(resultIntent);
                    count.cancel();
                }
                radioGroup.clearCheck();
            }
        });
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}