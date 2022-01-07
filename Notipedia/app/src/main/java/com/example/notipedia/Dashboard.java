package com.example.notipedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;


public class Dashboard extends AppCompatActivity {
    RelativeLayout ttos, about, help, share,stot,ImgtoText,TxtToPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);


        ttos = findViewById(R.id.texttospeechr);
        share = findViewById(R.id.share);
        help = findViewById(R.id.help);
        about = findViewById(R.id.about);
        stot=findViewById(R.id.stot);
        ImgtoText=findViewById(R.id.imgtotext);
        TxtToPdf=findViewById(R.id.txt_to_pdf);

        ttos.setOnClickListener(new View.OnClickListener() {   //text to speech
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, TextToSpch.class);
                startActivity(intent);
            }
        });

        stot.setOnClickListener(new View.OnClickListener() {   //speech to text
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, SpchToText.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareText = "Welcome To Notipedia \nDownload This App now:-\nhttps://google.com";
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                String chooserTitle = "Share Notipedia Via";
                startActivity(Intent.createChooser(sendIntent, chooserTitle));
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Help.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, About.class);
                startActivity(intent);
            }
        });
        ImgtoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Ocr.class);
                startActivity(intent);
            }
        });
        TxtToPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Dashboard.this,TxtPdf.class);
                startActivity(intent);
            }
        });

    }
}

