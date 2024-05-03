package com.example.parcial2docorteandersonprado;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    String dato;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUser= "dataUser";
    private static final int modo_privado = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        //sharedPreferences = getSharedPreferences(dataUser, modo_privado);
        //editor = sharedPreferences.edit();

        //dato = getApplicationContext().getSharedPreferences(dataUser, modo_privado).getString("usuario", "0");

        //if (!dato.equalsIgnoreCase("0")){
            //Intent i = new Intent(LoginActivity.this, Inicio.class);
           // startActivity(i);
            //finish();
        //}

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    PreferencesHelper.saveUsername(LoginActivity.this, username);
                    Intent intent = new Intent(LoginActivity.this, Inicio.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}