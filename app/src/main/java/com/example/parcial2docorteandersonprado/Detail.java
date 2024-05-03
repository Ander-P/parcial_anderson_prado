package com.example.parcial2docorteandersonprado;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

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

        TextView textView = findViewById(R.id.txtViewNameFilm);
        textView.setText(getIntent().getStringExtra("name"));

        btn_cerrar = findViewById(R.id.btn_cerrar);

       // dato = getApplicationContext().getSharedPreferences(dataUser, modo_privado).getString("usuario", "0");

        //if (!dato.equals("0")){
            //txt_user.setText(dato);
        //}else{
           // txt_user.setText("No hay informacion");
       // }
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