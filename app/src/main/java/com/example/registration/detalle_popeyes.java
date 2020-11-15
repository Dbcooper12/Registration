package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class detalle_popeyes extends AppCompatActivity {

    EditText etCantidad,etnombre,ettelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_popeyes);

        final TextView preciow = (TextView) findViewById(R.id.Precio);
        final TextView Personal = (TextView) findViewById(R.id.PersonalEntrega);
        final TextView FechaP = (TextView) findViewById(R.id.FechaP);

        etCantidad  =  (EditText) findViewById(R.id.cantidad);

        etnombre =  (EditText) findViewById(R.id.nombrePer);
        ettelefono =  (EditText) findViewById(R.id.telefonoPer);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null){
            preciow.setText(b.getString("PRE"));
            FechaP.setText(b.getString("FEC"));
            Personal.setText(b.getString("REP"));

        }

        Button btnPedido = (Button) findViewById(R.id.btnPedirPedido);

        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String personaEntrega = Personal.getText().toString();
                final String cantidad = etCantidad.getText().toString();
                final String fecha = FechaP.getText().toString();
                final String precio = preciow.getText().toString();
                final String nombre = etnombre.getText().toString();
                final String telefono = ettelefono.getText().toString();

                Response.Listener<String> responListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(detalle_popeyes.this,pedido_exit_popeyes.class);
                                detalle_popeyes.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(detalle_popeyes.this);
                                builder.setMessage("Error registro").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegistroPedidoRequest registerRequest = new RegistroPedidoRequest(personaEntrega, cantidad, fecha, precio,nombre,telefono, responListener);
                RequestQueue queue = Volley.newRequestQueue(detalle_popeyes.this);
                queue.add(registerRequest);




            }
        });


        Button btnCancelar = (Button) findViewById(R.id.btncancelarB);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detalle_popeyes.this,MenuInicio2.class);

                detalle_popeyes.this.startActivity(intent);
            }
        });


    }
}