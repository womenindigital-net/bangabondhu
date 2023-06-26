package com.womenindigital.staytuned.ui.slideshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.womenindigital.staytuned.LoginActivity;
import com.womenindigital.staytuned.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        //slideshowViewModel = new ViewModelProvider(requireActivity()).get()
        //slideshowViewModel = new ViewModelProvider(requireActivity()).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        final Button goOn = root.findViewById(R.id.goOn);
        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOnline() == true) {
                    Log.d("result","internet is connected");
                    Intent gridActivity = new Intent(getActivity(), LoginActivity.class);
                    startActivity(gridActivity);
                    ((Activity) getActivity()).overridePendingTransition(0,0);
                } else {
                    Log.d("result","internet is not connected");
                }

            }
        });
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


}