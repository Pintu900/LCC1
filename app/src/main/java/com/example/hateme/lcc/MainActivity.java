package com.example.hateme.lcc;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText editText,editText1;
   TextView textView,textView1;
   ImageView imageView;
   Button button;
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Animation aniFade=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        imageView.startAnimation(aniFade);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        button= findViewById(R.id.login);
        editText=findViewById(R.id.editText);
        editText.setHint("USERNAME");
        textView = findViewById(R.id.user);
        textView.setVisibility(View.INVISIBLE);
        editText1 = findViewById(R.id.editText2);
        editText1.setHint("PASSWORD");
        textView1 = findViewById(R.id.textView5);
        textView1.setVisibility(View.INVISIBLE);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText.setHint("");
                textView.setVisibility(View.VISIBLE);
                return false;
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    textView.setVisibility(View.INVISIBLE);
                    editText.setHint("USERNAME");
                }
            }
        });
        editText1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textView1.setVisibility(View.VISIBLE);
                editText1.setHint("");
                return false;
            }
        });
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    textView1.setVisibility(View.INVISIBLE);
                    editText1.setHint("PASSWORD");
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(2000,1000){
                    public void onTick(long millisecondsUntilDone){
                        button.setVisibility(View.INVISIBLE);
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    public void onFinish(){
                        Toast.makeText(MainActivity.this,"Logged In",Toast.LENGTH_SHORT).show();
                        button.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        });
    }
    public void signUp(View view){
        Intent i = new Intent(MainActivity.this,SignUp.class);
        startActivity(i);
    }
}
