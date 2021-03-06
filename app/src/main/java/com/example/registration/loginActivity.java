package com.example.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {

    TextView lblCrearCuenta;
    EditText txtInputEmail, txtInputPassword;
    Button btnLogin;
    FirebaseAuth mAuth;

    private ProgressDialog mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_login);
        txtInputEmail = findViewById(R.id.inputEmail);
        txtInputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnlogin);
        lblCrearCuenta = findViewById(R.id.txtNotieneCuenta);

        lblCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,RegisterActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarCredenciales();
            }
        });

        mProgressBar = new ProgressDialog(loginActivity.this);
        mAuth = FirebaseAuth.getInstance();
    }

    public void verificarCredenciales(){
        String email = txtInputEmail.getText().toString();


        final String password = txtInputPassword.getText().toString();

        if(email.isEmpty() || !email.contains("@")){
            showError(txtInputEmail, "Email no valido");
        }else if(password.isEmpty()|| password.length()<7){
            showError(txtInputPassword, "Password invalida");
        }else{
            //Mostrar ProgressBar
            mProgressBar.setTitle("Login");
            mProgressBar.setMessage("Iniciando sesión, espere un momento..");
            mProgressBar.setCanceledOnTouchOutside(false);
            mProgressBar.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        mProgressBar.dismiss();
                        //guardar clave en sharedpreferences
                        SharedPreferences prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();

                        editor.putString("password", password);
                        editor.commit();





                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        intent.putExtra("password", password);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "No se puede iniciar sesion, verifique correo o contraseña",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
            //Registrar usuario
            //Exitoso -> Mostrar toast
            //redireccionar - intent a login

            //ocultar progressBar

        }
    }

    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
    @Override
    protected void onStart(){
        FirebaseUser user = mAuth.getCurrentUser();
        if (user!=null){
            SharedPreferences prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
            String password_guardada = prefs.getString("password", "");

            Intent intent = new Intent(loginActivity.this, MainActivity.class);
            intent.putExtra("password", password_guardada);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        super.onStart();
    }
}