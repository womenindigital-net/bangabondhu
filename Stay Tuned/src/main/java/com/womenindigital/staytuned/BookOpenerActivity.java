package com.womenindigital.staytuned;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class BookOpenerActivity extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_opener);

        pdfView = findViewById(R.id.pdfView);

        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("position");

       // Toast.makeText(BookOpenerActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
        if(position == 0){
            pdfView.fromAsset("oshomapto_attojiboni.pdf").load();
        }else if(position == 1){
            pdfView.fromAsset("কারাগারের রোজনামচা - শেখ মুজিবুর রহমান.pdf").load();
        }else if(position == 2){
            pdfView.fromAsset("আমার দেখা নয়াচীন.pdf").load();
        }else if(position == 3){
            pdfView.fromAsset("শেখ মুজিব আমার পিতা.pdf").load();
        }else if(position == 4){
            pdfView.fromAsset("শেখ মুজিবের ছেলেবেলা.pdf").load();
        }
    }
}