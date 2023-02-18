package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;
    private int wysokoscTemp;
    private int wynik=0;
    private int tura=0;
    private List<Button> przyciski = new ArrayList<>();
    private List<String> pytania = new ArrayList<>();
    private List<String> poprawneOdpowiedzi = new ArrayList<>();
    private List<String> odpowiedziBlad1 = new ArrayList<>();
    private List<String> odpowiedziBlad2 = new ArrayList<>();
    private List<String> odpowiedziBlad3 = new ArrayList<>();
    private TextView lbl0,lbl1,lbl2;
    private int losowo=0;
    private Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Tost",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        dodajPytanie("Ile to 2+2?","1","2","3","4");
        dodajPytanie("Ile łap ma kot?","2","6","3","4");
        dodajPytanie("Jaki kolor ma trawa?","pomarańczowy","niebieski","czerwony","zielony");
        dodajPytanie("Który pokemon jest duchowy?","Charmander","Metapod","Cresselia","Gengar");
        dodajPytanie("Czemu Toriel nie upieczę ciasta?","Bo nie umie","Bo nie lubi","Bo ma inne rzeczy do roboty","Bo nie żyje");
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        lbl0=(TextView) findViewById(R.id.lbl0);
        lbl1=(TextView) findViewById(R.id.lbl1);
        lbl2=(TextView) findViewById(R.id.lbl2);
        przyciski.add(btn1);
        przyciski.add(btn2);
        przyciski.add(btn3);
        przyciski.add(btn4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                wynik+=1;
                lbl1.setText("Wynik: "+ wynik);
                lbl2.setText("Pytanie numer: "+ (tura+1));
                sprawdzCzyKoniec(tura);
                wyswietlPytanie(tura);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                lbl2.setText("Pytanie numer: "+ (tura+1));
                sprawdzCzyKoniec(tura);
                wyswietlPytanie(tura);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                lbl2.setText("Pytanie numer: "+ (tura+1));
                sprawdzCzyKoniec(tura);
                wyswietlPytanie(tura);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tura++;
                lbl2.setText("Pytanie numer: "+ (tura+1));
                sprawdzCzyKoniec(tura);
                wyswietlPytanie(tura);
            }
        });

    }

    private void wyswietlPytanie(int tura) {
        lbl0.setText(pytania.get(tura));
        losowo = random.nextInt(4);
        wysokoscTemp = (int) btn1.getY();
        btn1.setY(przyciski.get(losowo).getY());
        przyciski.get(losowo).setY(wysokoscTemp);
        btn1.setText(poprawneOdpowiedzi.get(tura));
        btn2.setText(odpowiedziBlad1.get(tura));
        btn3.setText(odpowiedziBlad2.get(tura));
        btn4.setText(odpowiedziBlad3.get(tura));
    }
    private void sprawdzCzyKoniec(int tura) {
       if(tura==poprawneOdpowiedzi.size()){
           Intent myActivity = new Intent(this, EndingActivity.class);
           myActivity.putExtra("WYNIK", wynik);
           startActivity(myActivity);
       }
    }
    private void dodajPytanie(String pytanie,String odpowiedzBlad1,String odpowiedzBlad2,String odpowiedzBlad3,String odpowiedzPoprawna){
        pytania.add(pytanie);
        odpowiedziBlad1.add(odpowiedzBlad1);
        odpowiedziBlad2.add(odpowiedzBlad2);
        odpowiedziBlad3.add(odpowiedzBlad3);
        poprawneOdpowiedzi.add(odpowiedzPoprawna);
    }
}