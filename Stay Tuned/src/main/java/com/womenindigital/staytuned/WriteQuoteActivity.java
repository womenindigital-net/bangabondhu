package com.womenindigital.staytuned;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thekhaeng.pushdownanim.PushDownAnim;

public class WriteQuoteActivity extends AppCompatActivity {
    ImageView quoteUpload,photoUpload,bookUpload,videoUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_quote);
        overridePendingTransition(0, 0);

        quoteUpload = findViewById(R.id.quoteUpload);
        PushDownAnim.setPushDownAnimTo(quoteUpload);
        photoUpload= findViewById(R.id.photoUpload);
        PushDownAnim.setPushDownAnimTo(photoUpload);
        bookUpload = findViewById(R.id.bookUpload);
        PushDownAnim.setPushDownAnimTo(bookUpload);
        videoUpload = findViewById(R.id.videoUpload);
        PushDownAnim.setPushDownAnimTo(videoUpload);
    }
}