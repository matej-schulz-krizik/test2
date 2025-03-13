package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerOperation = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.znamenko,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerOperation.setAdapter(adapter);


    }
    public void calculate(View view){

        EditText a = (EditText)findViewById(R.id.editTextNumberA);
        int cislo1 = Integer.parseInt(a.getText().toString());

        EditText b = (EditText)findViewById(R.id.editTextNumberB);
        int cislo2 = Integer.parseInt(b.getText().toString());

        EditText c = (EditText)findViewById(R.id.editTextNumberC);
        int cislo3 = Integer.parseInt(c.getText().toString());

        String znak = spinnerOperation.getSelectedItem().toString();

        double vysledek1;
        double vysledek2;

        if (cislo1==0){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("je to linearni nerovnice"));
            return;


        }


        int D = (cislo2*cislo2)-4*cislo1*cislo3;

       /* if (D<=0){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("Diksriminant je mensi nebo roven 0"));
            return;
        } */

        if(D>0&&cislo1>0){
            vysledek1 = (-cislo2+Math.sqrt(D))/2*cislo1;
            vysledek2 = (-cislo2-Math.sqrt(D))/2*cislo1;

            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("(-inf; " + vysledek1 + ") U (" + vysledek2 + "; +inf)"));
            
        } else if (D>0&&cislo1<0) {

            vysledek1 = (-cislo2+Math.sqrt(D))/2*cislo1;
            vysledek2 = (-cislo2-Math.sqrt(D))/2*cislo1;
            
            
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("(" + vysledek1 + "; " + vysledek2 + ")"));
            
        } else if (D==0&&cislo1>0) {

            vysledek1 = (-cislo2)/2*cislo1;

            //x se rovnaji
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf(vysledek1));

        } else if (D==0&&cislo1<0) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("prazdna mnozina"));
        } else if (D<0&&cislo1>0) {

            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("(-inf; +inf)"));


        } else if (D<0&&cislo1<0) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(String.valueOf("prazdna mnozina"));
        }


      /*  vysledek1 = (-cislo2+Math.sqrt(D))/2*cislo1;
        vysledek2 = (-cislo2-Math.sqrt(D))/2*cislo1;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf("x1= " + vysledek1 + ",x2= " + vysledek2));*/

    }
}