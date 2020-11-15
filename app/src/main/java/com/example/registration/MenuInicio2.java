package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuInicio2 extends AppCompatActivity {
    ImageButton btnpizzahut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio2);
        Button btnCuenta =(Button) findViewById(R.id.cuenta);

        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio2.this,MainActivity.class);
                MenuInicio2.this.startActivity(intent);
            }
        });
        ImageButton btnbrasaroja = (ImageButton) findViewById(R.id.brasaroja);

        btnbrasaroja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio2.this,brazaroja.class);

                MenuInicio2.this.startActivity(intent);
            }
        });
        pizzahutbtn();
        btnpizzahut = (ImageButton) findViewById(R.id.pizzahut);

        btnpizzahut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio2.this,pizzahut.class);

                MenuInicio2.this.startActivity(intent);
            }
        });



    }


    public void pizzahutbtn(){
         btnpizzahut = (ImageButton) findViewById(R.id.pizzahut);

        btnpizzahut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio2.this,pizzahut.class);

                MenuInicio2.this.startActivity(intent);
            }
        });

        ImageButton btnpopeyes = (ImageButton) findViewById(R.id.popeyes);

        btnpopeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuInicio2.this,popeyes.class);

                MenuInicio2.this.startActivity(intent);
            }
        });

    }
}