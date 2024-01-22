package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextWeight = findViewById(R.id.editTextWeight);
        final EditText editTextHeight = findViewById(R.id.editTextHeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        final TextView textViewResult = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String weightStr = editTextWeight.getText().toString();
                String heightStr = editTextHeight.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {

                    double weight = Double.parseDouble(weightStr);
                    double height = Double.parseDouble(heightStr);


                    double bmi = calculateBMI(weight, height);


                    String result = "Vas BMI je: " + bmi;
                    textViewResult.setText(result);
                } else {
                    textViewResult.setText("Unesite visinu i tezinu");
                }
            }
        });
    }

    private double calculateBMI(double weight, double height) {

        return weight / (height * height);
    }
}
