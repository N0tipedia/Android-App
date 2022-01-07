package com.example.notipedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SpchToText extends AppCompatActivity {
    EditText editText;
    Button clear,button_copy;
    ImageButton imgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spch_to_text);

        editText=findViewById(R.id.et_input);
        clear=findViewById(R.id.bt_clear);
        imgb=findViewById(R.id.voice);
        button_copy=findViewById(R.id.bt_copy);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        button_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scanned_text=editText.getText().toString();
                copyToClipBoard(scanned_text);
            }
        });

        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 10);
                } else {
                    Toast.makeText(SpchToText.this,"Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editText.setText(result.get(0));
                }
                break;
        }
    }

    private void copyToClipBoard(String text){
        ClipboardManager clipBoard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip=ClipData.newPlainText("Copied data",text);
        clipBoard.setPrimaryClip(clip);
        Toast.makeText(SpchToText.this,"Copiedto ClipBoard", Toast.LENGTH_SHORT).show();

    }
}