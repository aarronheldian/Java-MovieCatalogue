package com.dicoding.picodiploma.subminssionpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetail extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";

    TextView tvJudul;
    TextView tvGenre;
    TextView tvPh;
    TextView tvTanggal;
    TextView tvOverview;
    ImageView imgCover;
    TextView tvRating;
    TextView tvWaktu;
    TextView tvAktor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        tvJudul = findViewById(R.id.tv_judul);
        tvGenre = findViewById(R.id.tv_genre);
        tvPh = findViewById(R.id.tv_ph);
        tvTanggal = findViewById(R.id.tv_tanggal);
        tvOverview = findViewById(R.id.tv_deskripsi);
        imgCover = findViewById(R.id.img_photo);
        tvRating = findViewById(R.id.tv_rating);
        tvWaktu = findViewById(R.id.tv_time);
        tvAktor = findViewById(R.id.tv_aktor);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        assert film != null;
        tvJudul.setText(film.getJudul());
        tvGenre.setText(film.getGenre());
        tvPh.setText(film.getPh());
        tvTanggal.setText(film.getTanggal());
        tvOverview.setText(film.getOverview());
        imgCover.setImageResource(film.getPhoto());
        tvRating.setText(film.getRating());
        tvWaktu.setText(film.getWaktu());
        tvAktor.setText(film.getAktor());
    }
}
