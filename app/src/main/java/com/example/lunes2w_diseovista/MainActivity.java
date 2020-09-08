package com.example.lunes2w_diseovista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int counter;
    private CheckBox negative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        showCounter();
        this.negative = findViewById(R.id.cB_negative);
        negative.setOnClickListener(this);
    }
    public void increment(View view) {
        counter++;
        showCounter();
    }

    public void decrement(View view) {
        counter--;
        if (!negative.isChecked() && counter<0){
                counter=0;
        }
        showCounter();
    }

    public void reset(View vista) {
        EditText defaultCounter = findViewById(R.id.default_counter);
        String valorString = defaultCounter.getText().toString();
        if (valorString.isEmpty()) {
            valorString = "0";
        }
        counter = Integer.parseInt(valorString);
        showCounter();
    }

    public void showCounter() {
        TextView status = findViewById(R.id.result);
        status.setText(String.valueOf(counter));
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.cB_negative){
                if (!negative.isChecked() && counter<0){
                    counter=0;
                    showCounter();
                }
        }
    }
}

