package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class brazaroja extends AppCompatActivity {

 ListView lista;
 String[][] datos = {
         {"Pollo a la brasa roja","brasa roja","S/.54.00","9","2020-11-","Jose Calderon"},
         {"Pollo broaster","brasa roja","S/.54.90","7","2020-11-","Maria Perez" }
 };
  int[] datosImg = {R.drawable.polloalbraza,R.drawable.pollobroaster};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brazaroja);

        lista = findViewById(R.id.lvLista);

        lista.setAdapter(new AdaptadorBrasa(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(),DetalleBrasaRoja.class);
                visorDetalles.putExtra("PRE", datos[position][2]);
                visorDetalles.putExtra("REP", datos[position][5]);
                visorDetalles.putExtra("FEC", datos[position][4]);
                startActivity(visorDetalles);
            }
        });

    }
}