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

public class Upgrades extends AppCompatActivity
{
    Button B2,B4,B6,B8,B10,B12;
    TextView TMod,TVal;
    int value,modifier;
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
        setContentView(R.layout.activity_upgrades);

        B2 = (Button) findViewById(R.id.B2);
        B4 = (Button) findViewById(R.id.B4);
        B6 = (Button) findViewById(R.id.B6);
        B8 = (Button) findViewById(R.id.B8);
        B10 = (Button) findViewById(R.id.B10);
        B12 = (Button) findViewById(R.id.B12);
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
        B2.setText("+2\n"+B2click*2*pclick);
        B4.setText("+4\n"+B4click*4*pclick);
        B6.setText("+6\n"+B6click*6*pclick);
        B8.setText("+8\n"+B8click*8*pclick);
        B10.setText("+10\n"+B10click*10*pclick);
        B12.setText("+12\n"+B12click*12*pclick);
        TVal.setText(value+"");
        TMod.setText(modifier+"");
        new CountDownTimer(10000000,5000)
        {
            public void onTick(long millisUntilFinished)
            {
                if ((ccure+Faccure+Doccure)>=100000)
                {
                    ccure+=(Faccure+Doccure-((ccure+Faccure+Doccure)-100000));

                    Toast.makeText(Upgrades.this, "Cure has been discovered", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Upgrades.this, "Cure has been discovered", Toast.LENGTH_SHORT).show();
                }
                else start();
            }
        }.start();
    }



    public void MainActivity(View view)
    {
        Intent MainActivity = new Intent(this, MainActivity.class);
        MainActivity.putExtra("Modifier",modifier);
        MainActivity.putExtra("Value",value);
        MainActivity.putExtra("Ccure",ccure);
        MainActivity.putExtra("B2click",B2click);
        MainActivity.putExtra("B4click",B4click);
        MainActivity.putExtra("B6click",B6click);
        MainActivity.putExtra("B8click",B8click);
        MainActivity.putExtra("B10click",B10click);
        MainActivity.putExtra("B12click",B12click);
        MainActivity.putExtra("DocCure",Doccure);
        MainActivity.putExtra("FacCure",Faccure);
        MainActivity.putExtra("DocClick",Docclick);
        MainActivity.putExtra("Doc2Click",Doc2click);
        MainActivity.putExtra("Doc3Click",Doc3click);
        MainActivity.putExtra("FacClick",Facclick);
        MainActivity.putExtra("Fac2Click",Fac2click);
        MainActivity.putExtra("Fac3Click",Fac3click);
        startActivity(MainActivity);
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

    public void mod2 (View view)
    {
        if(value>=B2click*2*pclick)
        {
            value-=B2click*2*pclick;
            TVal.setText(value+"");
            modifier += 2;
            TMod.setText(modifier + "");
            B2click+=2;
            B2.setText("+2\n"+B2click*2*pclick);

        }
        else Toast.makeText(Upgrades.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void mod4 (View view)
    {
        if(value>=B4click*4*pclick)
        {
            value-=B4click*4*pclick;
            TVal.setText(value+"");
            modifier += 4;
            TMod.setText(modifier + "");
            B4click+=4;
            B4.setText("+4\n"+B4click*4*pclick);

        }
        else Toast.makeText(Upgrades.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void mod6 (View view)
    {
        if(value>=B6click*6*pclick)
        {
            value-=B6click*6*pclick;
            TVal.setText(value+"");
            modifier+=6;
            TMod.setText(modifier+"");
            B6click+=6;
            B6.setText("+6\n"+B6click*6*pclick);
        }
        else Toast.makeText(Upgrades.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void mod8 (View view)
    {
        if(value>=B8click*8*pclick)
        {
            value-=B8click*8*pclick;
            TVal.setText(value+"");
            modifier+=8;
            TMod.setText(modifier+"");
            B8click+=8;
            B8.setText("+8\n"+B8click*8*pclick);
        }
        else Toast.makeText(Upgrades.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void mod10 (View view)
    {
        if(value>=B10click*10*pclick)
        {
            value-=B10click*10*pclick;
            TVal.setText(value+"");
            modifier+=10;
            TMod.setText(modifier+"");
            B10click+=10;
            B10.setText("+10\n"+B10click*10*pclick);
        }
        else Toast.makeText(Upgrades.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void mod12 (View view)
    {
        if(value>=B12click*12*pclick)
        {
            value-=B12click*12*pclick;
            TVal.setText(value+"");
            modifier+=12;
            TMod.setText(modifier+"");
            B12click+=12;
            B12.setText("+12\n"+B12click*12*pclick);
        }
        else Toast.makeText(Upgrades.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }




}
