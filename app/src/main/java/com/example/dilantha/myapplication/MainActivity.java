package com.example.dilantha.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;
import java.util.Random.*;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView num1;
    private TextView num2;
    private TextView operator;
    private TextView textView3;
    private TextView textView7;
    private EditText editText;
    private Button button2;
    private Random random;
    private int answer;
    private int score;
    private int total;
    private ToggleButton toggleButton;
    private CountDownTimer countDownTimer;
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (TextView)findViewById(R.id.textView2);
        num2 = (TextView)findViewById(R.id.textView5);
        operator = (TextView)findViewById(R.id.textView4);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView7 = (TextView)findViewById(R.id.textView7);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        time = (TextView)findViewById(R.id.textView9);
        random = new Random();
        score = 0;
        total = 0;




        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    reload();
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        @Override
                        public void onTick(long l) {
                            time.setText(Double.toString(l / 1000));
                        }

                        @Override
                        public void onFinish() {
                            textView3.setText("Time out");
                            textView7.setText(Integer.toString(score) + " / " + ++total);
                            reload();
                            countDownTimer.start();
                        }
                    }.start();
                } else
                {
                    score = 0;
                    total = 0;
                    num1.setText("");
                    num2.setText("");
                    operator.setText("");
                    editText.setText("");
                    textView7.setText("0/0");
                    textView3.setText("Result");
                    time.setText("10.0");
                    countDownTimer.cancel();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    int givenAnswer;
                    countDownTimer.cancel();
                    try {
                        givenAnswer = Integer.parseInt(editText.getText().toString());
                    } catch (Exception e) {
                        givenAnswer = 1000;
                    }
                    if (operator.getText().toString() == "+") {
                        if (Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()) == givenAnswer) {
                            textView3.setText("Correct");
                            ++score;
                        }
                        else
                            textView3.setText("Wrong");
                    }
                    if (operator.getText().toString() == "-") {
                        if (Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString()) == givenAnswer) {
                            textView3.setText("Correct");
                            ++score;
                        }
                        else
                            textView3.setText("Wrong");
                    }
                    if (operator.getText().toString() == "/") {
                        if (Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString()) == givenAnswer) {
                            textView3.setText("Correct");
                            ++score;
                        }
                        else
                            textView3.setText("Wrong");
                    }
                    if (operator.getText().toString() == "*") {
                        if (Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString()) == givenAnswer) {
                            textView3.setText("Correct");
                            ++score;
                        }
                        else
                            textView3.setText("Wrong");
                    }
                    editText.setText("");
                    textView7.setText(Integer.toString(score) + " / " + ++total);
                    reload();
                    countDownTimer.start();
                }
            }
        });



    }
    private void reload() {
        int number1 = random.nextInt(10) + 1;
        int number2 = random.nextInt(10) + number1;

        num1.setText(Integer.toString(number1));
        num2.setText(Integer.toString(number2));

        int temp = random.nextInt(3);
        operator.setText(getOperator(temp, number1, number2));
    }

    private String getOperator(int i, int num1, int num2) {
        if (i == 0) {
            answer = num1 + num2;
            return "+";
        }
        else if (i == 1){
            answer = num1 - num2;
            return "-";
        }
        else if (i == 2){
            answer = num1 / num2;
            return "*";
        }
        else{
            answer = num1 * num2;
            return "/";
        }
    }
}