package com.example.quotesappadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quotesappadmin.Insert.AboutInsert;
import com.example.quotesappadmin.Insert.ContactInsert;
import com.example.quotesappadmin.Insert.QuotesInsert;
import com.example.quotesappadmin.View.InquiryView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contactUS(View view) {
        startActivity(new Intent(MainActivity.this, ContactInsert.class));
    }

    public void openAboutUs(View view) {
        startActivity(new Intent(MainActivity.this, AboutInsert.class));
    }

    public void openQuotes(View view) {
        startActivity(new Intent(MainActivity.this, QuotesInsert.class));
    }

    public void openImageInsertActivity(View view) {
        startActivity(new Intent(MainActivity.this, ImageInsert.class));
    }

    public void openViewInquiryActivity(View view) {
        startActivity(new Intent(MainActivity.this, InquiryView.class));
    }
}
