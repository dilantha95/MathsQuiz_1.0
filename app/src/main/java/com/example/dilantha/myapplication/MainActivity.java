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
    private Random random;
    private int answer;
    private int score;
    private int total;
    private double sum;
    private double highScore;
    private ToggleButton toggleButton;
    private CountDownTimer countDownTimer;
    private TextView time;
    private TextView highScoreText;
    private TextView QNo;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonClr;


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
        sum = 0;
        highScoreText = (TextView)findViewById(R.id.textView10);
        QNo = (TextView)findViewById(R.id.textView13);
        highScore = 0.0;
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonClr = (Button)findViewById(R.id.buttonClr);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    editText.setText("");
                    QNo.setText("Question no : 10");
                    reload();
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        @Override
                        public void onTick(long l) {
                            time.setText(Double.toString(l / 1000));
                        }

                        @Override
                        public void onFinish() {
                            QNo.setText("Question no : " + Integer.toString(10 - ++total));
                            textView3.setText("Time out");
                            textView7.setText(Double.toString(sum * score / total));
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
                    textView7.setText("0");
                    textView3.setText("Result");
                    QNo.setText("Click START to begin..!");
                    time.setText("0.0");
                    countDownTimer.cancel();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (total == 9) {
                    QNo.setText("Game Over");
                    textView3.setText("You score is : " + textView7.getText());
                    if (Double.parseDouble(textView7.getText().toString()) >= highScore) {
                        highScore = Double.parseDouble(textView7.getText().toString());
                        textView3.setText("High Score : " + highScore);
                        highScoreText.setText("High Score :  " + highScore);
                    }
                    score = 0;
                    sum = 0;
                    num1.setText("");
                    num2.setText("");
                    editText.setText("");
                    operator.setText("");
                    time.setText("0");
                    countDownTimer.cancel();
                }
                else if (toggleButton.isChecked()) {
                    int givenAnswer;
                    countDownTimer.cancel();
                    try {
                        givenAnswer = Integer.parseInt(editText.getText().toString());
                    } catch (Exception e) {
                        givenAnswer = 1000;
                    }
                    if (answer == givenAnswer) {
                        textView3.setText("Correct");
                        ++score;
                        sum = sum + Double.parseDouble(time.getText().toString());
                    }
                    else
                        textView3.setText("Wrong");

                    editText.setText("");
                    ++total;
                    textView7.setText(String.format("%.2f", (sum * score / total)));
                    QNo.setText("Question no : " + Integer.toString(10 - total));
                    reload();
                    countDownTimer.start();
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });

        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() > 0)
                    editText.setText(editText.getText().toString().substring(0, editText.getText().length() - 1));
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
            answer = num2 - num1;
            return "-";
        }
        else if (i == 2){
            answer = num1 * num2;
            return "*";
        }
        else{
            answer = num1 * num2;
            return "/";
        }
    }
}