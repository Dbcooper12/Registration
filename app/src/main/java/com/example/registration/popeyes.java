package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class popeyes extends AppCompatActivity {

    ListView lista;
    String[][] datos = {
            {"Popeyes Chicken Sandwich","popeyes","S/.44.00","9","2020/11/21","Paul Zapata"},
            {"Cajun Maria","popeyes","S/.19.90","7","2020/11/21","Danny Peralta Perez" },
            {"+ Festi + Golazo","popeyes","S/.39.90","7","2020/11/21","Arnold Roque" },
            {"CHICKEN MIX","popeyes","S/.9.90","7","2020/11/21","Monica Samillan" },
            {"Lunes de Alitas","popeyes","S/.12.90","7","2020/11/21","Bochini Bochini" }
    };
    int[] datosImg = {R.drawable.sanwich,R.drawable.cajunpopeye,R.drawable.festigolazo,R.drawable.chickenmix,R.drawable.lunesalitas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popeyes);

        lista = findViewById(R.id.lvLista);

        lista.setAdapter(new AdaptadorPopeyes(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(),detalle_popeyes.class);
                visorDetalles.putExtra("PRE", datos[position][2]);
                visorDetalles.putExtra("FEC", datos[position][4]);
                visorDetalles.putExtra("REP", datos[position][5]);
                startActivity(visorDetalles);
            }
        });
    }
}