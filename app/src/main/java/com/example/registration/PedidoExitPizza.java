package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PedidoExitPizza extends AppCompatActivity {
    EditText etSource, etDestination;
    Button btTrack, btnconfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_exit_pizza);
        etSource = findViewById(R.id.et_sourece);
        etDestination= findViewById(R.id.et_destubation);
        btTrack  = (Button) findViewById(R.id.bt_track);
        btnconfi = (Button) findViewById(R.id.btnConfi);

        etSource.setText("Los Claveles 37,José Leonardo Ortiz, Perú");
        etDestination.setText("Pizza Hut, Real, Chiclayo");

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSource = etSource.getText().toString().trim();
                String sDestination= etDestination.getText().toString().trim();
                if (sSource.equals("")&& sDestination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter both location", Toast.LENGTH_SHORT).show();
                }else{
                    DisplayTrack(sSource,sDestination);
                }
            }
        });
        btnconfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Pedido confirmado Exitosamente",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PedidoExitPizza.this,MenuInicio2.class);
                PedidoExitPizza.this.startActivity(intent);

            }
        });

    }

    private void DisplayTrack(String sSource, String sDestination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/"+ sDestination);

            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}