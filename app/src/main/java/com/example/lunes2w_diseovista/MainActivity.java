package com.example.lunes2w_diseovista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

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
        Button reset = findViewById(R.id.button_reset);
        reset.setOnClickListener(this);
        Button incr = findViewById(R.id.button_increment);
        incr.setOnClickListener(this);
        Button decr = findViewById(R.id.button_decrement);
        decr.setOnClickListener(this);
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
        String counterDefaultString = defaultCounter.getText().toString();
        if (counterDefaultString.isEmpty()) {
            counterDefaultString = "0";
        }
        counter = Integer.parseInt(counterDefaultString);
        showCounter();
    }

    public void showCounter() {
        TextView status = findViewById(R.id.result);
        status.setText(String.valueOf(counter));
    }

    public void hideKeyboard(View view){
        InputMethodManager keyboard = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        if (keyboard.isActive()){
            keyboard.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(),0);
        }
    }

    @Override
    public void onClick(View view) {
        hideKeyboard(view);
        switch (view.getId()){
            case R.id.cB_negative:
                if (!negative.isChecked() && counter<0){
                    counter=0;
                }
                showCounter();
                break;
            case R.id.button_reset:
                reset(view);
                break;
            case R.id.button_increment:
                increment(view);
                break;
            case R.id.button_decrement:
                decrement(view);
                break;
        }
    }
}

