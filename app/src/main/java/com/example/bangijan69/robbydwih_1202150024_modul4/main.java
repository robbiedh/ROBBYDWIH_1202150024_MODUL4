package com.example.bangijan69.robbydwih_1202150024_modul4;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bangijan69 on 3/17/2018.
 */

public class main extends AppCompatActivity {

    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_utama);
        button1 = (Button)findViewById(R.id.Menu_1); // parsing button 1
        button2 =(Button)findViewById(R.id.menu_2); // parsin button 2

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main.this, MainActivity.class);// membuat object baru
                startActivity(intent); // memulai aktivitas baru
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main.this, Main2Activity.class);// membuat akitfitas baru
                startActivity(intent); //  memulai aktivitas baru
            }
        });

    }
}
