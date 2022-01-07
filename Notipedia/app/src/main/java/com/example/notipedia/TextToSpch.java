package com.example.notipedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class TextToSpch extends AppCompatActivity {

    EditText etInput;
    Button btConvert,btClear;
  TextToSpeech textToSpeech;
  Uri text_file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_text_to_speech);

        etInput=findViewById(R.id.et_input);
        btConvert=findViewById(R.id.bt_convert);
        btClear=findViewById(R.id.bt_clear);

       btConvert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                   @Override
                   public void onInit(int status) {
                       if(status==textToSpeech.SUCCESS){
                           textToSpeech.setLanguage(Locale.ENGLISH);
                           textToSpeech.setSpeechRate(1.0f);
                           textToSpeech.speak(etInput.getText().toString(),TextToSpeech.QUEUE_ADD,null);
                       }

                   }
               });
           }
       });



       btClear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               etInput.setText("");
           }
       });


        }
    }