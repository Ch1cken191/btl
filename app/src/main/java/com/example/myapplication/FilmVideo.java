package com.example.myapplication;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class FilmVideo extends AppCompatActivity {
    VideoView video;
    Uri uri;
    MediaController mediaController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_video_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        String videoId = getIntent().getStringExtra("videoId");
        System.out.println("================================="+videoId);

//        video = (VideoView) findViewById(R.id.filmVideo);
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ngan;
//        uri = Uri.parse(videoPath);
//        video.setVideoURI(uri);
//        video.setVideoPath("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_20mb.mp4");
//        mediaController = new MediaController(this);
//        video.setMediaController(mediaController);
//        mediaController.setAnchorView(video);
//        video.start();

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
}
