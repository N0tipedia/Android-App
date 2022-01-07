spackage com.example.notipedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;

public class TxtPdf extends AppCompatActivity {

    EditText etInput;
    Button btConvert,btClear,btView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_txt_pdf);


        etInput=findViewById(R.id.et_input);
        btConvert=findViewById(R.id.bt_convert);
        btClear=findViewById(R.id.bt_clear);
        btView=findViewById(R.id.bt_view);

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=etInput.getText().toString();
                String path=getExternalFilesDir(null).toString()+"/user.pdf";
                File file=new File(path);

                if (!file.exists()){
                    try{
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Document document= new Document(PageSize.A4);
                try {
                    PdfWriter.getInstance(document,new FileOutputStream(file.getAbsoluteFile()));
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                document.open();
                Font myfont=new Font(Font.FontFamily.HELVETICA,24,Font.BOLD);

                Paragraph paragraph=new Paragraph();
                paragraph.add(new Paragraph(txt,myfont));

                try{
                    document.add(paragraph);
                }catch(DocumentException e){
                        e.printStackTrace();
                }

                document.close();
                Toast.makeText(TxtPdf.this,"PDF Created Successfully",Toast.LENGTH_SHORT).show();


            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),pdfViewr.class);
                startActivity(intent);
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