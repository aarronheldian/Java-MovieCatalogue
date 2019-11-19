package com.dicoding.picodiploma.subminssionpertama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Film> films;

    void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder {
        private TextView tvJudul;
        private TextView tvGenre;
        private TextView tvPh;
        private TextView tvTahun;
        private TextView tvOverview;
        private ImageView imgPhoto;
        private TextView tvRating;

        ViewHolder(View view) {
            tvGenre = view.findViewById(R.id.tv_genre);
            tvJudul = view.findViewById(R.id.tv_judul);
            tvPh = view.findViewById(R.id.tv_ph);
            tvTahun = view.findViewById(R.id.tv_tahun);
            tvOverview = view.findViewById(R.id.tv_deskripsi);
            imgPhoto = view.findViewById(R.id.img_photo);
            tvRating = view.findViewById(R.id.tv_rating);
        }

        void bind(Film film) {
            tvGenre.setText(film.getGenre());
            tvJudul.setText(film.getJudul());
            tvPh.setText(film.getPh());
            tvTahun.setText(film.getTahun());
            tvOverview.setText(film.getOverview());
            imgPhoto.setImageResource(film.getPhoto());
            tvRating.setText(film.getRating());
        }
    }
}
