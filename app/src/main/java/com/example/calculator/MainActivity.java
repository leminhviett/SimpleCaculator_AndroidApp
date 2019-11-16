package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;

    EditText screen;
    boolean operator = false; //allow user to hit operators


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSubtraction);
        buttonMul = (Button) findViewById(R.id.buttonMultiply);
        buttonDivision = (Button) findViewById(R.id.buttonDivide);
        buttonC = (Button) findViewById(R.id.buttonClearText);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        screen = (EditText) findViewById(R.id.textView1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "1");
                operator = true;

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "2");
                operator = true;

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "3");
                operator = true;

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "4");
                operator = true;

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "5");
                operator = true;

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "6");
                operator = true;

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "7");
                operator = true;

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "8");
                operator = true;

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "9");
                operator = true;

            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "0");
                operator = true;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator) screen.setText(screen.getText() + "+");
                operator = false;

            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator) screen.setText(screen.getText() + "-");
                operator = false;

            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator) screen.setText(screen.getText() + "x");
                operator = false;


            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator) screen.setText(screen.getText() + "/");
                operator = false;

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                operator = false;

            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + ".");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator){
                    String arr = screen.getText() + "";
                    int k = 0;
                    ArrayList<Double> num = new ArrayList<Double>();
                    ArrayList<String> opr = new ArrayList<String>();

                    // load nnumbers & operators into 2 arrays
                    String temp_num = "";
                    String temp_opr = "";
                    int s = 0;
                    if(arr.charAt(0) == '-'){
                        temp_num = "-";
                        s = 1;
                    }

                    for(int i = s; i < arr.length(); i ++){
                        if((arr.charAt(i) >= '0' && arr.charAt(i) <= '9')||arr.charAt(i) == '.') {
                            k = 0;
                            temp_num += arr.charAt(i);
                        } else {
                            k = 1;
                            temp_opr += arr.charAt(i);
                        }

                        if(k == 1){
                            num.add(Double.parseDouble(temp_num));
                            opr.add(temp_opr);
                            temp_num = "";
                            temp_opr = "";
                        }
                    }
                    num.add(Double.parseDouble(temp_num));

                    // calculate step
                    while(opr.size()!= 0){
                        int index = opr.indexOf("/");
                        if(index == -1){
                            index = opr.indexOf("x");
                        }
                        if(index == -1){
                            index = opr.indexOf("+");
                        }
                        if(index == -1){
                            index = opr.indexOf("-");
                        }

                        String c = opr.get(index);
                        double temp;
                        System.out.println(num);
                        switch(c){
                            case "x":
                                temp = num.get(index)*num.get(index + 1);
                                num.set(index, temp);
                                num.remove(index + 1);
                                opr.remove(index);
                                break;
                            case "/":
                                temp = num.get(index)/num.get(index + 1);
                                num.set(index, temp);
                                num.remove(index + 1);
                                opr.remove(index);
                                break;
                            case "+":
                                temp = num.get(index)+num.get(index + 1);
                                num.set(index, temp);
                                num.remove(index + 1);
                                opr.remove(index);
                                break;
                            case "-":
                                temp = num.get(index)-num.get(index + 1);
                                num.set(index, temp);
                                num.remove(index + 1);
                                opr.remove(index);
                                break;
                        }
                    }
                    screen.setText(num.get(0) + "");
                    operator = true;
                }
            }
        });
    }
}