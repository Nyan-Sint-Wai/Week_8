package com.example.week8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inputFirstNumber, inputSecondNumber;
    TextView textResult;
    DecimalFormat df = new DecimalFormat("0.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);
    }

    @SuppressLint("SetTextI18n")
    public void onOperationClick(View view) {
        String num1Str = inputFirstNumber.getText().toString();
        String num2Str = inputSecondNumber.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textResult.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        int id = view.getId();  // Get the ID of the clicked button

        if (id == R.id.buttonPlus) {
            result = num1 + num2;
        } else if (id == R.id.buttonMinus) {
            result = num1 - num2;
        } else if (id == R.id.buttonMultiply) {
            result = num1 * num2;
        } else if (id == R.id.buttonDivide) {
            if (num2 == 0) {
                textResult.setText("Cannot divide by zero");
                return;
            }
            result = num1 / num2;
        }

        textResult.setText("Result: " + df.format(result));
    }
}