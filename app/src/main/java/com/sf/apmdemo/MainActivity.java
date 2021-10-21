package com.sf.apmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;

import dex.Dex2oat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Dex2oat.makeDex2oat1("data/app/apmdemo/base.apk","data/app/apmdemo/oat/x86/base.odex");
        try {
            Dex2oat.makeDex2OatV2("data/app/apmdemo/base.apk","data/app/apmdemo/oat/x86/base.odex");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        new Dex2oat().test(this.getApplicationContext());
    }
}