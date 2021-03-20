package com.example.psl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VideoPlayerActivity extends AppCompatActivity {
    VideoView videoView;
    FirebaseDatabase firebaseDatabase;
    TextView tvname;
    public static String firebaseVideoURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        tvname = findViewById(R.id.tvnamev);
        String category = "", categoryItem = "";
        int code = getIntent().getIntExtra("code", 0);
        if(code == 1){
            categoryItem = getIntent().getStringExtra("item");
            category = getCategory(categoryItem);
            playVideo(category , categoryItem);
        }else if( code == 2){
            category = getIntent().getStringExtra("category");
            categoryItem = getIntent().getStringExtra("categoryItem");
            playVideo(category, categoryItem);
        }
    }

    private String getCategory(String item) {
        if(item.equals("A") || item.equals("B") || item.equals("C") || item.equals("D") || item.equals("E")){
            return "Alphabets";
        }else if(item.equals("Air Crash") || item.equals("Allama Iqbal Airport") || item.equals("Arrival") || item.equals("Baggage Cleaning") || item.equals("Quaid-e-Azam Airport")){
            return "Airport";
        }else if(item.equals("Battery") || item.equals("Ceiling Fan") || item.equals("Electric Iron") || item.equals("Electric Toaster") || item.equals("Freezer")) {
            return "Appliances";
        }else if(item.equals("Abstract") || item.equals("Painting") || item.equals("Palette Knife") || item.equals("Pastel") || item.equals("Palette")){
            return "Arts";
        }else if(item.equals("Crow") || item.equals("Dove") || item.equals("Falcon") || item.equals("Hawk")){
            return "Birds";
        }else{
            return "";
        }
    }

    private void playVideo(String category, String categoryItem) {
        firebaseVideoURL = new String();
        videoView = findViewById(R.id.videoView);
        tvname.setText(category + ": " + categoryItem);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference()
                .child("Categories")
                .child(category)
                .child(categoryItem)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        firebaseVideoURL = snapshot.getValue(String.class);
                        if(!firebaseVideoURL.isEmpty()) {
                            Uri uri = Uri.parse(firebaseVideoURL);
                            videoView.setVideoURI(uri);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(VideoPlayerActivity.this, "Video not Found", Toast.LENGTH_SHORT).show();
                    }
                });
        MediaController mediaController;
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}