package com.example.notipedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class pdfViewr extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pdf_viewr);

        pdfView=findViewById(R.id.view);
        String path=getExternalFilesDir(null).toString()+"/user.pdf";
        File file=new File(path);

        pdfView.fromFile(file).swipeHorizontal(false)
                .enableDoubletap(true)
                .enableAnnotationRendering(false)
                .defaultPage(0)
                .password(null)
                .scrollHandle(null)
                .load();
    }
}