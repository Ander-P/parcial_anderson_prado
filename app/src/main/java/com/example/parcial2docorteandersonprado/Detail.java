package com.example.parcial2docorteandersonprado;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {
    public static final String dataUser= "dataUser";
    private static final int modo_privado = Context.MODE_PRIVATE;
    TextView txt_user;
    String dato;
    Button btn_cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView name = findViewById(R.id.txtViewNameFilm);
        name.setText("Nombre: " + getIntent().getStringExtra("name"));

        TextView status = findViewById(R.id.txtViewStatus);
        status.setText("Estado: " + getIntent().getStringExtra("status"));

        TextView gender = findViewById(R.id.txtViewGender);
        gender.setText("Genero: " +getIntent().getStringExtra("gender"));

        TextView city = findViewById(R.id.txtViewCity);
        city.setText("Ciudad: " + getIntent().getStringExtra("city"));

        TextView planet = findViewById(R.id.txtViewPlanet);
        planet.setText("Planeta: "+getIntent().getStringExtra("planet"));

        TextView specie = findViewById(R.id.txtViewSpecies);
        specie.setText("Especie: "+ getIntent().getStringExtra("specie"));

        ImageView image = findViewById(R.id.image_profile);
        String imageUrl = getIntent().getStringExtra("image");
        Picasso.get().load(imageUrl).into(image);

        btn_cerrar = findViewById(R.id.btn_cerrar);

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuracion =  getApplicationContext().getSharedPreferences(dataUser, modo_privado);
                configuracion.edit().clear().commit();
                Intent i = new Intent(Detail.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}