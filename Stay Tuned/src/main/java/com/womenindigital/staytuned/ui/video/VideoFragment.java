package com.womenindigital.staytuned.ui.video;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.womenindigital.staytuned.R;

public class VideoFragment extends Fragment {

    private VideoViewModel photoViewModel;
    private ImageView albumOne,albumTwo,albumThree,albumFour,albumFive,albumSix;

    YouTubePlayerView youtube_player_view;

    Dialog myDialog;
    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_video, container, false);
        albumOne = root.findViewById(R.id.albumOne);
        albumTwo = root.findViewById(R.id.albumTwo);
        albumThree = root.findViewById(R.id.albumThree);
        albumFour = root.findViewById(R.id.albumFour);
//        albumFive = root.findViewById(R.id.albumFive);
//        albumSix = root.findViewById(R.id.albumSix);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //photoViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);
        // TODO: Use the ViewModel
        albumOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("QxvC3e5E-xw");
            }
        });
        albumTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("gWwtd4FCz_E&feature=youtu.be");


            }
        });
        albumThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("8xeLvIr5ti0&feature=youtu.be");

            }
        });
        albumFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo("WrI0wwIEBuw");

            }
        });

    }

    public void playVideo(final String id){
        myDialog = new Dialog(getContext());
        myDialog.setContentView(R.layout.video_popup);

        youtube_player_view = myDialog.findViewById(R.id.youtube_player_view);

        getLifecycle().addObserver(youtube_player_view);
        youtube_player_view.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = id;
                youTubePlayer.loadVideo(videoId, 0);

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

}