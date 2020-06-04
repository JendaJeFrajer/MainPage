package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button BMon;
    TextView TMod,TVal;
    int value=0,modifier=2;
    float ccure;
    int B2click=1,B4click=1,B6click=1,B8click=1,B10click=1,B12click=1;
    int Doccure=0,Faccure=0;
    int Docclick=1,Doc2click=1,Doc3click=1;
    int Facclick=1,Fac2click=1,Fac3click=1;
    int pclick=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    BMon = (Button) findViewById(R.id.BMon);
    TMod = (TextView) findViewById(R.id.TMod);
    TVal = (TextView) findViewById(R.id.TVal);
    }

    @Override
    protected void onStart() {
        super.onStart();
        value = getIntent().getIntExtra("Value",value);
        modifier = getIntent().getIntExtra("Modifier",modifier);
        ccure = getIntent().getFloatExtra("Ccure",ccure);
        B2click = getIntent().getIntExtra("B2click",B2click);
        B4click = getIntent().getIntExtra("B4click",B4click);
        B6click = getIntent().getIntExtra("B6click",B6click);
        B8click = getIntent().getIntExtra("B8click",B8click);
        B10click = getIntent().getIntExtra("B10click",B10click);
        B12click = getIntent().getIntExtra("B12click",B12click);
        Doccure = getIntent().getIntExtra("DocCure",Doccure);
        Faccure = getIntent().getIntExtra("FacCure",Faccure);
        Docclick = getIntent().getIntExtra("DocClick",Docclick);
        Doc2click = getIntent().getIntExtra("Doc2Click",Doc2click);
        Doc3click = getIntent().getIntExtra("Doc3Click",Doc3click);
        Facclick = getIntent().getIntExtra("FacClick",Facclick);
        Fac2click = getIntent().getIntExtra("Fac2Click",Fac2click);
        Fac3click = getIntent().getIntExtra("Fac3Click",Fac3click);
        TVal.setText(value+"");
        TMod.setText(modifier+"");
        new CountDownTimer(10000000,5000)
        {
            public void onTick(long millisUntilFinished)
            {
                if ((ccure+Faccure+Doccure)>=100000)
                {
                    ccure+=(Faccure+Doccure-((ccure+Faccure+Doccure)-100000));

                    Toast.makeText(MainActivity.this, "Cure has been discovered", Toast.LENGTH_SHORT).show();
                    cancel();                       //případný konec
                }
                else
                {
                    ccure += Faccure + Doccure;


                }

            }
            public void onFinish()
            {
                if (ccure>=100000)
                {
                    cancel();                                                       //případný konec
                    Toast.makeText(MainActivity.this, "Cure has been discovered", Toast.LENGTH_SHORT).show();
                }
                else start();
            }
        }.start();
    }

    public void Upgrades(View view)
    {
        Intent Upgrades = new Intent(this, Upgrades.class);
        Upgrades.putExtra("Modifier",modifier);
        Upgrades.putExtra("Value",value);
        Upgrades.putExtra("Ccure",ccure);
        Upgrades.putExtra("B2click",B2click);
        Upgrades.putExtra("B4click",B4click);
        Upgrades.putExtra("B6click",B6click);
        Upgrades.putExtra("B8click",B8click);
        Upgrades.putExtra("B10click",B10click);
        Upgrades.putExtra("B12click",B12click);
        Upgrades.putExtra("DocCure",Doccure);
        Upgrades.putExtra("FacCure",Faccure);
        Upgrades.putExtra("DocClick",Docclick);
        Upgrades.putExtra("Doc2Click",Doc2click);
        Upgrades.putExtra("Doc3Click",Doc3click);
        Upgrades.putExtra("FacClick",Facclick);
        Upgrades.putExtra("Fac2Click",Fac2click);
        Upgrades.putExtra("Fac3Click",Fac3click);
        startActivity(Upgrades);
    }

    public void Cure(View view)
    {
        Intent Cure = new Intent(this, Cure.class);
        Cure.putExtra("Modifier",modifier);
        Cure.putExtra("Value",value);
        Cure.putExtra("Ccure",ccure);
        Cure.putExtra("B2click",B2click);
        Cure.putExtra("B4click",B4click);
        Cure.putExtra("B6click",B6click);
        Cure.putExtra("B8click",B8click);
        Cure.putExtra("B10click",B10click);
        Cure.putExtra("B12click",B12click);
        Cure.putExtra("DocCure",Doccure);
        Cure.putExtra("FacCure",Faccure);
        Cure.putExtra("DocClick",Docclick);
        Cure.putExtra("Doc2Click",Doc2click);
        Cure.putExtra("Doc3Click",Doc3click);
        Cure.putExtra("FacClick",Facclick);
        Cure.putExtra("Fac2Click",Fac2click);
        Cure.putExtra("Fac3Click",Fac3click);
        startActivity(Cure);
    }

    public void Settings(View view)
    {
        Intent Settings = new Intent(this, Settings.class);
        Settings.putExtra("Modifier",modifier);
        Settings.putExtra("Value",value);
        Settings.putExtra("Ccure",ccure);
        Settings.putExtra("B2click",B2click);
        Settings.putExtra("B4click",B4click);
        Settings.putExtra("B6click",B6click);
        Settings.putExtra("B8click",B8click);
        Settings.putExtra("B10click",B10click);
        Settings.putExtra("B12click",B12click);
        Settings.putExtra("DocCure",Doccure);
        Settings.putExtra("FacCure",Faccure);
        Settings.putExtra("DocClick",Docclick);
        Settings.putExtra("Doc2Click",Doc2click);
        Settings.putExtra("Doc3Click",Doc3click);
        Settings.putExtra("FacClick",Facclick);
        Settings.putExtra("Fac2Click",Fac2click);
        Settings.putExtra("Fac3Click",Fac3click);
        startActivity(Settings);
    }

    public void money (View view)
    {
        value+=modifier;
        TVal.setText(value+"");
        TMod.setText(modifier+"");

    }




}
