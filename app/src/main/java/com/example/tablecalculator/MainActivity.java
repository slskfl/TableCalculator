package com.example.tablecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btnAdd, btnMin, btnMul, btnDiv;
    TextView tvResult;
    Button[] numButton=new Button[10];
    int[] numBtnIDs={R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4
            , R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
    String num1, num2;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1=findViewById(R.id.edtNum1);
        edtNum2=findViewById(R.id.edtNum2);
        btnAdd=findViewById(R.id.btnAdd);
        btnMin=findViewById(R.id.btnMin);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);
        tvResult=findViewById(R.id.tvReult);

        for (int i=0; i<numBtnIDs.length; i++){
            numButton[i]=findViewById(numBtnIDs[i]);
        }
        for(int i=0; i<numBtnIDs.length; i++){
            final int index;
            index=i;
            numButton[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edtNum1.isFocused()==true) {
                        num1=edtNum1.getText().toString()+numButton[index].getText().toString();
                    } else if(edtNum2.isFocused()==true){
                        num2=edtNum2.getText().toString()+numButton[index].getText().toString();
                    } else {
                        showToast("먼저 에디트 텍스트를 선책해주세요.");
                    }
                }
            });
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edtNum1.getText().toString();
                num2=edtNum1.getText().toString();
                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT).show();
                } else {
                    result=Double.parseDouble(num1)+Double.parseDouble(num2);
                    tvResult.setText("계산 결과 : " + result);
                }
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edtNum1.getText().toString();
                num2=edtNum1.getText().toString();
                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT).show();
                } else {
                    result=Double.parseDouble(num1)-Double.parseDouble(num1);
                    tvResult.setText("계산 결과 : " + result);
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edtNum1.getText().toString();
                num2=edtNum1.getText().toString();
                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT).show();
                } else {
                    result=Double.parseDouble(num1)*Double.parseDouble(num2);
                    tvResult.setText("계산 결과 : " + result);
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // '0'으로 나누어지는 것을 방지.
                try {
                    num1=edtNum1.getText().toString();
                    num2=edtNum1.getText().toString();
                    if(num1.equals("")||num2.equals("")){
                        Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT).show();
                    } else {
                        result=Double.parseDouble(num1)/Double.parseDouble(num2);
                        //소수점 한 자리만 나타내기
                        result=(int)(result*10)/10.0;
                        tvResult.setText("계산 결과 : " + result);
                    }
                } catch (java.lang.ArithmeticException e){
                    Toast.makeText(getApplicationContext(), "0으로 나누면 안됩니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}