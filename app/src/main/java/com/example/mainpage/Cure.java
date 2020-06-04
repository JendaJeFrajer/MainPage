package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Cure extends AppCompatActivity
{
    Button Doc1, Doc2, Doc3,Fac1,Fac2,Fac3;
    TextView TVal,TCur;
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
        setContentView(R.layout.activity_cure);
        TVal = (TextView) findViewById(R.id.TVal);
        TCur = (TextView) findViewById(R.id.TCur);
        Doc1 = (Button) findViewById(R.id.Doc1);
        Doc2 = (Button) findViewById(R.id.Doc2);
        Doc3 = (Button) findViewById(R.id.Doc3);
        Fac1 = (Button) findViewById(R.id.Fac1);
        Fac2 = (Button) findViewById(R.id.Fac2);
        Fac3 = (Button) findViewById(R.id.Fac3);

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
        TCur.setText(ccure/1000+"%");
        Doc1.setText("+1\n"+(Docclick*10*pclick));
        Doc2.setText("+2\n"+(Doc2click*20*pclick));
        Doc3.setText("+3\n"+(Doc3click*30*pclick));
        Fac1.setText("+5\n"+(Facclick*200*pclick));
        Fac2.setText("+10\n"+(Fac2click*400*pclick));
        Fac3.setText("+20\n"+(Fac3click*600*pclick));
        new CountDownTimer(10000000,5000)
        {
            public void onTick(long millisUntilFinished)
            {
                if ((ccure+Faccure+Doccure)>=100000)
                {
                    ccure+=(Faccure+Doccure-((ccure+Faccure+Doccure)-100000));
                    TCur.setText(ccure/1000+"%");
                    Toast.makeText(Cure.this, "Cure has been discovered", Toast.LENGTH_SHORT).show();
                    cancel();                       //případný konec
                }
                else
                {
                    ccure += Faccure + Doccure;
                    TCur.setText(ccure/1000+"%");

                }

            }
            public void onFinish()
            {
                if (ccure>=100000)
                {
                    cancel();                                                       //případný konec
                    Toast.makeText(Cure.this, "Cure has been discovered", Toast.LENGTH_SHORT).show();
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
        startActivity(Upgrades);
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
        startActivity(Settings);
    }

    public void Doc1 (View view) {



        if(value>=Docclick*10*pclick)
        {
            value-=Docclick*10*pclick;
            TVal.setText(value+"");
            Doccure++;

            Docclick+=10;
            Doc1.setText("+1\n"+(Docclick*10*pclick));
        }
        else Toast.makeText(Cure.this, "Can´t Afford", Toast.LENGTH_SHORT).show();



    }

    public void Doc2 (View view) {



        if(value>=Doc2click*20*pclick)
        {
            value-=Doc2click*20*pclick;
            TVal.setText(value+"");
            Doccure+=2;

            Doc2click+=20;
            Doc2.setText("+2\n"+(Doc2click*20*pclick));
        }
        else Toast.makeText(Cure.this, "Can´t Afford", Toast.LENGTH_SHORT).show();




    }

    public void Doc3 (View view) {



        if(value>=Doc3click*30*pclick)
        {
            value-=Doc3click*30*pclick;
            TVal.setText(value+"");
            Doccure+=3;

            Doc3click+=30;
            Doc3.setText("+3\n"+(Doc3click*30*pclick));
        }
        else Toast.makeText(Cure.this, "Can´t Afford", Toast.LENGTH_SHORT).show();


    }

    public void Fac1 (View view)
    {

        if(value>=Facclick*50*pclick)
        {
            value-=Facclick*50*pclick;
            TVal.setText(value+"");
            Faccure+=5;

            Facclick+=50;
            Fac1.setText("+5\n"+(Facclick*50*pclick));
        }
        else Toast.makeText(Cure.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void Fac2 (View view)
    {

        if(value>=Fac2click*100*pclick)
        {
            value-=Fac2click*100*pclick;
            TVal.setText(value+"");
            Faccure+=10;

            Fac2click+=100;
            Fac2.setText("+10\n"+(Fac2click*100*pclick));
        }
        else Toast.makeText(Cure.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

    public void Fac3 (View view)
    {

        if(value>=Fac3click*150*pclick)
        {
            value-=Fac3click*150*pclick;
            TVal.setText(value+"");
            Faccure+=20;

            Fac3click+=150;
            Fac3.setText("+20\n"+(Fac3click*150*pclick));
        }
        else Toast.makeText(Cure.this, "Can´t Afford", Toast.LENGTH_SHORT).show();
    }

}
