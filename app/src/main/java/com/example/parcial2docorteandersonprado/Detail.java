package com.example.parcial2docorteandersonprado;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Detail extends AppCompatActivity {
    public static final String dataUser= "dataUser";
    private static final int modo_privado = Context.MODE_PRIVATE;
    Button btn_cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = findViewById(R.id.txtViewNameFilm);
        textView.setText(getIntent().getStringExtra("name"));

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuracion =  getApplicationContext().getSharedPreferences(dataUser, modo_privado);
                configuracion.edit().clear().commit();
                Intent i = new Intent(Detail.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}