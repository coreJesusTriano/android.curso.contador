package com.example.lunes2w_diseovista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        showCounter();
    }

    public void increment(View view) {
        counter++;
        showCounter();
    }

    public void decrement(View view) {
        counter--;
        showCounter();
    }

    public void reset(View vista) {
        counter = 0;
        showCounter();
    }

    public void showCounter() {
        TextView status;
        status = (TextView) findViewById(R.id.result);
        status.setText(String.valueOf(counter));
    }
}

