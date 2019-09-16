package com.example.usdconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double dollarEntered;
    double eurosConversion = 1.10;
    double pesosConversion = 0.05;
    double cndConversion = 0.75;
    double convertedDollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText dollars = (EditText) findViewById(R.id.txtDollars);
        final RadioButton euroToDollar = (RadioButton) findViewById(R.id.radEuros);
        final RadioButton pesoToDollar = (RadioButton) findViewById(R.id.radPesos);
        final RadioButton canToDollar = (RadioButton) findViewById(R.id.radCanadian);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               dollarEntered=Double.parseDouble(dollars.getText().toString());
               DecimalFormat currency = new DecimalFormat("$###,###,##.##");
               if (euroToDollar.isChecked()){
                   if (dollarEntered <= 100000) {
                       convertedDollar = dollarEntered / eurosConversion;
                       result.setText(currency.format(convertedDollar) + " in euros.");
                   }
                   else {
                       Toast.makeText(MainActivity.this, "Cannot exceed $100,000", Toast.LENGTH_LONG).show();
                   }
               }
               if (pesoToDollar.isChecked()){
                   if (dollarEntered <= 100000) {
                       convertedDollar = dollarEntered / pesosConversion;
                       result.setText(currency.format(convertedDollar) + " in pesos.");
                   }
                   else {
                       Toast.makeText(MainActivity.this, "Cannot exceed $100,000", Toast.LENGTH_LONG).show();
                   }
               }
               if (canToDollar.isChecked()) {
                   if (dollarEntered <= 100000) {
                       convertedDollar = dollarEntered / cndConversion;
                       result.setText(currency.format(convertedDollar) + " in Canadian dollars.");
                   }
                   else {
                       Toast.makeText(MainActivity.this, "Cannot exceed $100,000", Toast.LENGTH_LONG).show();
                   }
               }
           }
        });
    }
}
