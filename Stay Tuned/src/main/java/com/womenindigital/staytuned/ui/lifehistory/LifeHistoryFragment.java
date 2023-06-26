package com.womenindigital.staytuned.ui.lifehistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.womenindigital.staytuned.R;

public class LifeHistoryFragment extends Fragment {

    private LifeHistoryViewModel lifeHistoryViewModel;
    TextView textView;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_life_history, container, false);
        textView = root.findViewById(R.id.lifetitle);
        return root;
    }

    @Override    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //lifeHistoryViewModel = ViewModelProviders.of(this).get(LifeHistoryViewModel.class);
        // TODO: Use the ViewModel

        lifeHistoryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

    }

}