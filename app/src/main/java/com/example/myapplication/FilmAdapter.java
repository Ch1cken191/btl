package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class FilmAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Film> list;

    public FilmAdapter(Context context, int layout, List<Film> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ImageView avatar = view.findViewById(R.id.filmAvatar);
        TextView name = view.findViewById(R.id.filmName);
        TextView director = view.findViewById(R.id.filmDirector);
        TextView duration = view.findViewById(R.id.filmDuration);
        TextView releaseDate = view.findViewById(R.id.filmReleaseDate);
        Film film = list.get(position);
        String url = "https://img.youtube.com/vi/" +film.getId() + "/sddefault.jpg";
        Picasso.get().load(url).into(avatar);
        name.setText(film.getName());
        director.setText(film.getDirector());
        duration.setText(film.getDuration());
        releaseDate.setText(film.getReleaseDate());
        return view;
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }

    public void filterFilm(List<Film> ds,String text,String typeOfFilter){
        this.list = ds;
        if(text.length() == 0) return;
        List<Film> films = new ArrayList<>();
        for(int i = 0; i < this.list.size(); i++){
            String type = "";
            if(typeOfFilter == "name"){
                type = removeAccent(list.get(i).getName().toLowerCase(Locale.ROOT));
            } else if(typeOfFilter == "category"){
                type = removeAccent(list.get(i).getCategory().toLowerCase(Locale.ROOT));
            }
            String compareString = removeAccent(text.toLowerCase(Locale.ROOT));
            if(type.contains(compareString)){
                films.add(list.get(i));
            }
        }
        this.list = films;
    }
}
