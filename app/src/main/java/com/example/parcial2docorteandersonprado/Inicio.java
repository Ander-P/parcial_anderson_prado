package com.example.parcial2docorteandersonprado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2docorteandersonprado.adaptadores.FilmAdapter;
import com.example.parcial2docorteandersonprado.clases.Film;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {
    RecyclerView rcv_films;
    List<Film> listFilms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        String savedUsername = PreferencesHelper.getUsername(this);

        if (savedUsername != null) {
            setContentView(R.layout.activity_inicio);
            rcv_films = findViewById(R.id.rcv_films);

            Film film1 = new Film("Rick sanchez", "Human", "https://rickandmortyapi.com/api/character/avatar/72.jpeg", "Alive", "Male", "Barr", "Colombia");
            Film film2 = new Film("Morty Smith", "Human", "https://rickandmortyapi.com/api/character/avatar/120.jpeg", "Alive", "Male", "Bogota", "Colombia");
            Film film3 = new Film("Summer Smith", "Human", "https://rickandmortyapi.com/api/character/avatar/190.jpeg", "Alive", "Male", "Cali", "Colombia");
            Film film4 = new Film("Bet Smith", "Human", "https://rickandmortyapi.com/api/character/avatar/241.jpeg", "Alive", "Male", "Barr", "Colombia");

            Film[] films = {film1, film2, film3, film4};

            for (int i = 0; i < films.length; i++) {
                listFilms.add(films[i]);
            }

            rcv_films.setLayoutManager(new LinearLayoutManager(this));
            rcv_films.setAdapter(new FilmAdapter(listFilms));

            rcv_films.addOnItemTouchListener(new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(Inicio.this, Detail.class);
                    Film selectedFilm = listFilms.get(position);
                    intent.putExtra("name", selectedFilm.getName());
                    intent.putExtra("specie", selectedFilm.getDuration());
                    intent.putExtra("status", selectedFilm.getStatus());
                    intent.putExtra("gender", selectedFilm.getGender());
                    intent.putExtra("city", selectedFilm.getCity());
                    intent.putExtra("planet", selectedFilm.getPlanet());
                    intent.putExtra("image", selectedFilm.getImage());
                    startActivity(intent);
                }
            }));

        } else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }
}