package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class pizzahut extends AppCompatActivity {
    ListView lista;
    String[][] datos = {
            {"Pizza Americana","Pizza Hut","S/.41.90","9","2020/11/21","Monica Samillan"},
            {"Pizza Pepperoni","Pizza Hut","S/.51.90","7","2020/11/21","Paul Zapata" }
    };
    int[] datosImg = {R.drawable.americana,R.drawable.pepperoni};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzahut);
        lista = findViewById(R.id.lvListaP);

        lista.setAdapter(new Adaptador_pizzahut(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(),DetallePizzaHut.class);
                visorDetalles.putExtra("PRE", datos[position][2]);
                visorDetalles.putExtra("FEC", datos[position][4]);
                visorDetalles.putExtra("REP", datos[position][5]);
                startActivity(visorDetalles);
            }
        });

    }
}