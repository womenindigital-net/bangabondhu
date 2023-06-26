package com.womenindigital.staytuned;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class VideoPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

//        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
//        getLifecycle().addObserver(youTubePlayerView);
    }

//    public void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {
//        //initialize youtube player view
//        youTubePlayerView.initialize("AIzaSyBjRNdxhQRvUuy9cOynHhIj6G0cMb-y6DI",
//                new YouTubePlayer.OnInitializedListener() {
//                    @Override
//                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
//                                                        YouTubePlayer youTubePlayer, boolean b) {
//                        youTubePlayer.cueVideo(videoId);
//                    }
//
//                    @Override
//                    public void onInitializationFailure(YouTubePlayer.Provider provider,
//                                                        YouTubeInitializationResult youTubeInitializationResult) {
//
//                    }
//                });
//    }
}