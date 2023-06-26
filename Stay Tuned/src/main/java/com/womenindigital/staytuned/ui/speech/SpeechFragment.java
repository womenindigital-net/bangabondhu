package com.womenindigital.staytuned.ui.speech;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.womenindigital.staytuned.R;

public class SpeechFragment extends Fragment  {
    private View root;
    Button buttonPlay;
    private SpeechViewModel mViewModel;
    YouTubePlayerView youtube_player_view;
    Dialog myDialog;

    public static SpeechFragment newInstance() {
        return new SpeechFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_speech, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SpeechViewModel.class);



        // TODO: Use the ViewModel
        buttonPlay = root.findViewById(R.id.play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog = new Dialog(getContext());
                myDialog.setContentView(R.layout.video_popup);

                youtube_player_view = myDialog.findViewById(R.id.youtube_player_view);

                getLifecycle().addObserver(youtube_player_view);
                youtube_player_view.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        String videoId = "XFG0i1cv2zY";
                        youTubePlayer.loadVideo(videoId, 0);

                    }
                });


                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();

            }
        });

    }


}