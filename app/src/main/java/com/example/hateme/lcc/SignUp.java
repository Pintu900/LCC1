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

public class SignUp extends AppCompatActivity {
     TextView textView11,textView22,textView33,textView44,textView;
     EditText editText11,editText22,editText33,editText44;
     ImageView imageView;
     Button button;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressBar=findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.INVISIBLE);
        button =findViewById(R.id.button);
        imageView=findViewById(R.id.imageView2);
        Animation aniFade=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        imageView.startAnimation(aniFade);

        textView11 =findViewById(R.id.wr);
        textView11.setVisibility(View.INVISIBLE);
        textView22=findViewById(R.id.em);
        textView22.setVisibility(View.INVISIBLE);
        textView33=findViewById(R.id.pas);
        textView33.setVisibility(View.INVISIBLE);
        textView44=findViewById(R.id.textView8);
        textView44.setVisibility(View.INVISIBLE);

        editText11=findViewById(R.id.editText3);
        editText22=findViewById(R.id.email);
        editText33=findViewById(R.id.password);
        editText44=findViewById(R.id.password1);

        editText11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText11.setHint("");
                textView11.setVisibility(View.VISIBLE);
                return false;
            }
        });
        editText11.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    textView11.setVisibility(View.INVISIBLE);
                    editText11.setHint("Name");
                }
            }
        });

        editText22.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText22.setHint("");
                textView22.setVisibility(View.VISIBLE);
                return false;
            }
        });
        editText22.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    textView22.setVisibility(View.INVISIBLE);
                    editText22.setHint("Email / Phone");
                }
            }
        });

        editText33.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText33.setHint("");
                textView33.setVisibility(View.VISIBLE);
                return false;
            }
        });
        editText33.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    textView33.setVisibility(View.INVISIBLE);
                    editText33.setHint("Password");
                }
            }
        });

        editText44.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText44.setHint("");
                textView44.setVisibility(View.VISIBLE);
                return false;
            }
        });
        editText44.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    textView44.setVisibility(View.INVISIBLE);
                    editText44.setHint("Confirm Password");
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
                        Toast.makeText(SignUp.this,"Registered",Toast.LENGTH_SHORT).show();
                        button.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        });
    }
    public void logIn(View view){
        Intent i = new Intent(SignUp.this,MainActivity.class);
        startActivity(i);
    }
}
