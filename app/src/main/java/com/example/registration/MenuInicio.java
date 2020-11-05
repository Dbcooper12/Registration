package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);


        Button btnCuenta =(Button) findViewById(R.id.cuenta);

        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio.this,MainActivity.class);
                MenuInicio.this.startActivity(intent);
            }
        });
        ImageButton  btnbrasaroja = (ImageButton) findViewById(R.id.brasaroja);

        btnbrasaroja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio.this,brazaroja.class);

                MenuInicio.this.startActivity(intent);
            }
        });



    }
}