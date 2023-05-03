package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmDetail extends AppCompatActivity {
    Button watchMovieBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_detail_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail Of Film");
        ArrayList<String> filmDetail = getIntent().getStringArrayListExtra("film");
        getDetailOfFilm(filmDetail);
        watchMovieBtn = findViewById(R.id.watchMovieBtn);
        watchMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFilmVideo(filmDetail.get(0));
            }
        });
    }

    private void getDetailOfFilm(ArrayList list) {
        ImageView avatar = findViewById(R.id.filmAvatarDetail);
        String url = "https://img.youtube.com/vi/" + list.get(0) + "/sddefault.jpg";
        Picasso.get().load(url).into(avatar);
        TextView filmNameDetail,filmNationDetail,filmCategoryDetail,filmDurationDetail,filmDirectorDetail,filmReleaseDateDetail;
        filmNameDetail = findViewById(R.id.filmNameDetail);
        filmNationDetail = findViewById(R.id.filmNationDetail);
        filmCategoryDetail = findViewById(R.id.filmCategoryDetail);
        filmDurationDetail = findViewById(R.id.filmDurationDetail);
        filmDirectorDetail = findViewById(R.id.filmDirectorDetail);
        filmReleaseDateDetail = findViewById(R.id.filmReleaseDateDetail);

        filmNameDetail.setText(list.get(1).toString());
        filmDirectorDetail.setText(list.get(2).toString());
        filmDurationDetail.setText(list.get(3).toString());
        filmNationDetail.setText(list.get(4).toString());
        filmCategoryDetail.setText(list.get(5).toString());
        filmReleaseDateDetail.setText(list.get(6).toString());

    }

    private void moveToFilmVideo(String videoId){
        Intent intent = new Intent(FilmDetail.this, FilmVideo.class);
        intent.putExtra("videoId",videoId);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++"+videoId);
        startActivity(intent);
    }

}
