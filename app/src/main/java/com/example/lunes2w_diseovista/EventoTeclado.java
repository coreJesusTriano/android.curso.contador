package com.example.lunes2w_diseovista;

import android.view.KeyEvent;
import android.widget.TextView;

public class EventoTeclado implements TextView.OnEditorActionListener {

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
