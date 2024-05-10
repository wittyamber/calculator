package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);

        Button buttonac = findViewById(R.id.button_AC);
        Button buttondel = findViewById(R.id.button_c);
        Button buttondivide = findViewById(R.id.button_divide);
        Button buttonmultiply = findViewById(R.id.button_multiply);
        Button buttonminus = findViewById(R.id.button_minus);
        Button buttonequals = findViewById(R.id.button_equals);
        Button buttonplus = findViewById(R.id.button_plus);
        Button buttondot = findViewById(R.id.button_dot);

        TextView screen = findViewById(R.id.solution_tv);
        TextView resultTV = findViewById(R.id.result_tv);

        buttonac.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
            resultTV.setText("");
        });


        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(button0);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);

        for (Button b : buttons) {
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> operations = new ArrayList<>();
        operations.add(buttondivide);
        operations.add(buttonmultiply);
        operations.add(buttonplus);
        operations.add(buttonminus);
        for (Button b : operations) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        buttondel.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length()>1) {
                screen.setText(num.substring(0, num.length()-1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        buttondot.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        buttonequals.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum/secondNum;
                    break;
                case "*":
                    result = firstNum*secondNum;
                    break;
                case "+":
                    result = firstNum+secondNum;
                    break;
                case "-":
                    result = firstNum-secondNum;
                    break;
                default:
                    result = firstNum+secondNum;
            }

            firstNum = result;
            resultTV.setText(" " + (result));
        });

    }
}