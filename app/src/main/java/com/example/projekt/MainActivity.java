package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;
    private int wynik=0;
    private int tura=0;
    private List<String> pytania = new ArrayList<>();
    private List<String> poprawnaOdpowiedz = new ArrayList<>();
    private List<String> odpowiedzBlad1 = new ArrayList<>();
    private List<String> odpowiedzBlad2 = new ArrayList<>();
    private List<String> odpowiedzBlad3 = new ArrayList<>();
    private TextView lbl0,lbl1,lbl2,lbl4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Tost",Toast.LENGTH_SHORT).show();
        pytania.add("Pytanie 1");
        pytania.add("Pytanie 2");
        pytania.add("Pytanie 3");
        pytania.add("Pytanie 4");
        odpowiedzBlad1.add("Odpowiedz 1.1");
        odpowiedzBlad1.add("Odpowiedz 1.2");
        odpowiedzBlad1.add("Odpowiedz 1.3");
        odpowiedzBlad1.add("Odpowiedz 1.4");
        odpowiedzBlad2.add("Odpowiedz 2.1");
        odpowiedzBlad2.add("Odpowiedz 2.2");
        odpowiedzBlad2.add("Odpowiedz 2.3");
        odpowiedzBlad2.add("Odpowiedz 2.4");
        odpowiedzBlad3.add("Odpowiedz 3.1");
        odpowiedzBlad3.add("Odpowiedz 3.2");
        odpowiedzBlad3.add("Odpowiedz 3.3");
        odpowiedzBlad3.add("Odpowiedz 3.4");
        poprawnaOdpowiedz.add("Odpowiedz 4.1");
        poprawnaOdpowiedz.add("Odpowiedz 4.2");
        poprawnaOdpowiedz.add("Odpowiedz 4.3");
        poprawnaOdpowiedz.add("Odpowiedz 4.4");
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        lbl0=(TextView) findViewById(R.id.lbl0);
        lbl1=(TextView) findViewById(R.id.lbl1);
        lbl2=(TextView) findViewById(R.id.lbl2);
        lbl4=(TextView) findViewById(R.id.lbl4);
        lbl4.setVisibility(View.INVISIBLE);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                wynik+=1;
                lbl1.setText("Wynik: "+ wynik);
                lbl2.setText("Pytanie numer: "+ (tura+1));
                wyswietlPytanie(tura);
                sprawdzCzyKoniec(tura);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                lbl2.setText("Pytanie numer: "+ (tura+1));
                wyswietlPytanie(tura);
                sprawdzCzyKoniec(tura);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                lbl2.setText("Pytanie numer: "+ (tura+1));
                wyswietlPytanie(tura);
                sprawdzCzyKoniec(tura);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                lbl2.setText("Pytanie numer: "+ (tura+1));
                wyswietlPytanie(tura);
                sprawdzCzyKoniec(tura);
            }
        });

    }

    private void wyswietlPytanie(int tura) {
        lbl0.setText(pytania.get(tura));
        btn1.setText(poprawnaOdpowiedz.get(tura));
        btn2.setText(odpowiedzBlad1.get(tura));
        btn3.setText(odpowiedzBlad2.get(tura));
        btn4.setText(odpowiedzBlad3.get(tura));
    }
    private void sprawdzCzyKoniec(int tura) {
       if(tura==poprawnaOdpowiedz.size()-1){
           lbl0.setVisibility(View.INVISIBLE);
           btn1.setVisibility(View.INVISIBLE);
           btn2.setVisibility(View.INVISIBLE);
           btn3.setVisibility(View.INVISIBLE);
           btn4.setVisibility(View.INVISIBLE);
           lbl4.setVisibility(View.VISIBLE);
       }
    }
}