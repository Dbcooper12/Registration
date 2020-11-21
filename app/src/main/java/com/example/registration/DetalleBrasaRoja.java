package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class DetalleBrasaRoja extends AppCompatActivity {
    EditText etCantidad,etnombre,ettelefono;
    FirebaseAuth mAuth;
    TextView userNombre,userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_brasa_roja);

        final TextView preciow = (TextView) findViewById(R.id.Precio);
        final TextView Personal = (TextView) findViewById(R.id.PersonalEntrega);
        final TextView FechaP = (TextView) findViewById(R.id.FechaP);

        etCantidad  =  (EditText) findViewById(R.id.cantidad);

        etnombre =  (EditText) findViewById(R.id.nombrePer);
        ettelefono =  (EditText) findViewById(R.id.telefonoPer);
        userEmail = findViewById(R.id.nombrePer);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userEmail.setText(user.getEmail());
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
                                Intent intent = new Intent(DetalleBrasaRoja.this,PedidoCompletoBrasa.class);
                                DetalleBrasaRoja.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(DetalleBrasaRoja.this);
                                builder.setMessage("Error registro").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegistroPedidoRequest registerRequest = new RegistroPedidoRequest(personaEntrega, cantidad, fecha, precio,nombre,telefono, responListener);
                RequestQueue queue = Volley.newRequestQueue(DetalleBrasaRoja.this);
                queue.add(registerRequest);

            }
        });


        Button btnCancelar = (Button) findViewById(R.id.btncancelarB);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleBrasaRoja.this,MenuInicio2.class);

                DetalleBrasaRoja.this.startActivity(intent);
            }
        });

    }
}