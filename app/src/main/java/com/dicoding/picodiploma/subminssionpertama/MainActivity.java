package com.dicoding.picodiploma.subminssionpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataJudul;
    private String[] dataGenre;
    private String[] dataPh;
    private String[] dataTahun;
    private String[] dataTanggal;
    private String[] dataOverview;
    private TypedArray dataCover;
    private String[] dataRating;
    private String[] dataWaktu;
    private String[] dataAktor;
    private ArrayList<Film> films;
    private FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObjectIntent = new Intent(MainActivity.this, ItemDetail.class);
                moveWithObjectIntent.putExtra(ItemDetail.EXTRA_FILM, films.get(i));
                startActivity(moveWithObjectIntent);
            }
        });
    }

    private void addItem() {
        films = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            Film film = new Film();
            film.setGenre(dataGenre[i]);
            film.setJudul(dataJudul[i]);
            film.setPh(dataPh[i]);
            film.setTahun(dataTahun[i]);
            film.setTanggal(dataTanggal[i]);
            film.setOverview(dataOverview[i]);
            film.setPhoto(dataCover.getResourceId(i, -1));
            film.setRating(dataRating[i]);
            film.setWaktu(dataWaktu[i]);
            film.setAktor(dataAktor[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

    private void prepare() {
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataPh = getResources().getStringArray(R.array.data_ph);
        dataTahun = getResources().getStringArray(R.array.data_tahun);
        dataTanggal = getResources().getStringArray(R.array.data_tanggal);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataCover = getResources().obtainTypedArray(R.array.data_cover);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataWaktu = getResources().getStringArray(R.array.data_waktu);
        dataAktor = getResources().getStringArray(R.array.data_aktor);
    }
}
