package com.chaithrali.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton= (Button)findViewById(R.id.btnStart);
        final EditText nametext=(EditText)findViewById(R.id.etName);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nametext.getText().toString();

                Intent questionIntent= new Intent(getApplicationContext(),QuestionActivity.class);
                questionIntent.putExtra("myname", name);
                startActivity(questionIntent);
            }
        });
    }
}