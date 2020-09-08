package com.example.lunes2w_diseovista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int counter;
    private CheckBox negative;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        showCounter();
        this.negative = findViewById(R.id.cB_negative);
        negative.setOnClickListener(this);
        this.reset = findViewById(R.id.button_reset);
        reset.setOnClickListener(this);
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
        InputMethodManager teclado = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        EditText defaultCounter = findViewById(R.id.default_counter);
        String counterDefaultString = defaultCounter.getText().toString();
        if (counterDefaultString.isEmpty()) {
            counterDefaultString = "0";
        }
        counter = Integer.parseInt(counterDefaultString);
        teclado.hideSoftInputFromWindow(defaultCounter.getWindowToken(),0);
        showCounter();
    }

    public void showCounter() {
        TextView status = findViewById(R.id.result);
        status.setText(String.valueOf(counter));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cB_negative:
                if (!negative.isChecked() && counter<0){
                    counter=0;
                    showCounter();
                }
                break;
            case R.id.button_reset:
                reset(view);
                break;
        }
    }
}

