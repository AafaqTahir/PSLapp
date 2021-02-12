package com.example.psl;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoView = findViewById(R.id.videoView);

        String item = getIntent().getStringExtra("item");
        String videopath = null;
        if(item.equals("Adobe")) {
            videopath = "android.resource://" + getPackageName() + "/" + R.raw.adobe;
        }else if(item.equals("Apple")) {
             videopath = "android.resource://" + getPackageName() + "/" + R.raw.apple;
        }else if(item.equals("Artwork")) {
             videopath = "android.resource://" + getPackageName() + "/" + R.raw.artwork;
        }else if(item.equals("Boss")) {
            videopath = "android.resource://" + getPackageName() + "/" + R.raw.boss;
        }else if(item.equals("Chicken")) {
            videopath = "android.resource://" + getPackageName() + "/" + R.raw.chicken;
        }
        if(!videopath.isEmpty()){
            Uri uri = Uri.parse(videopath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
    }
}