package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class visor_imagen_popeyes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen_popeyes);
        ImageView img = (ImageView) findViewById(R.id.imagenB);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null){
            img.setImageResource(b.getInt("IMG"));
        }
    }
}