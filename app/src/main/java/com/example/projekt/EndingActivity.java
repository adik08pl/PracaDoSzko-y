package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EndingActivity extends AppCompatActivity {
    private TextView lblWynik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        lblWynik=(TextView) findViewById(R.id.lblWynik);
        int wynik;
        Intent odbierzTure = getIntent();
        wynik = odbierzTure.getIntExtra("WYNIK",0);
        lblWynik.setText("Gratuluję, twoje punkty to: "+wynik);
    }
}