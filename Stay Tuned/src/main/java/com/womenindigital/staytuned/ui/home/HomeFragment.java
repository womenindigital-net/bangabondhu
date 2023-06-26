package com.womenindigital.staytuned.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.womenindigital.staytuned.GridQuoteActivity;
import com.womenindigital.staytuned.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        //1st row
        final ImageView seventyOne = root.findViewById(R.id.seventyOne);
        seventyOne.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(seventyOne);

        final ImageView seventyThree = root.findViewById(R.id.sevetyThree);
        seventyThree.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(seventyThree);
        //2nd row
        final ImageView seventy = root.findViewById(R.id.seventy);
        seventy.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(seventy);
        //3rd row
        final ImageView fortyFour = root.findViewById(R.id.fortyFour);
        fortyFour.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fortyFour);

        final ImageView seventyTwo = root.findViewById(R.id.seventyTwo);
        seventyTwo.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(seventyTwo);

        //6th row
        final ImageView seventyFour = root.findViewById(R.id.seventyFour);
        seventyFour.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(seventyFour);

        final ImageView fortySeven = root.findViewById(R.id.fortySeven);
        fortySeven.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fortySeven);
        //7th row
        final ImageView fortyEight = root.findViewById(R.id.fortyEight);
        fortyEight.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fortyEight);

        final ImageView seventyFive = root.findViewById(R.id.seventyFive);
        seventyFive.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(seventyFive);
        //8th row
        final ImageView fortyNine = root.findViewById(R.id.fortyNine);
        fortyNine.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fortyNine);
        //9th row
        final ImageView fifty = root.findViewById(R.id.fifty);
        fifty.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fifty);

        final ImageView fiftyOne = root.findViewById(R.id.fiftyOne);
        fiftyOne.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyOne);
        //10th row
        final ImageView fiftyTwo = root.findViewById(R.id.fiftyTwo);
        fiftyTwo.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyTwo);

        final ImageView fiftyThree = root.findViewById(R.id.fiftyThree);
        fiftyThree.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyThree);
        //11th row
        final ImageView fiftyFour = root.findViewById(R.id.fiftyFour);
        fiftyFour.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyFour);

        final ImageView fiftyFive = root.findViewById(R.id.fiftyFive);
        fiftyFive.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyFive);
        //12th row
        final ImageView fiftySeven = root.findViewById(R.id.fiftySeven);
        fiftySeven.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftySeven);

        final ImageView fiftySix = root.findViewById(R.id.fiftySix);
        fiftySix.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftySix);
        //13th row
        final ImageView fiftyEight = root.findViewById(R.id.fiftyEight);
        fiftyEight.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyEight);

        final ImageView fiftyNine = root.findViewById(R.id.fiftyNine);
        fiftyNine.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(fiftyNine);
        //14th row
        final ImageView sixty = root.findViewById(R.id.sixty);
        sixty.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(sixty);
        //15th row
        final ImageView sixtyOne = root.findViewById(R.id.sixtyOne);
        sixtyOne.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(sixtyOne);

        final ImageView sixtyTwo = root.findViewById(R.id.sixtyTwo);
        sixtyTwo.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(sixtyTwo);
        //17th row
        final ImageView sixtyFive = root.findViewById(R.id.sixtyFive);
        sixtyFive.setOnClickListener(this);
        PushDownAnim.setPushDownAnimTo(sixtyFive);


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        return root;
    }


    @Override
    public void onClick(View view) {
        Intent gridActivity = new Intent(getActivity(), GridQuoteActivity.class);
        switch (view.getId()){
            //1st row
            case R.id.seventyOne:
            case R.id.fiftyThree:
            case R.id.fiftyOne:
                //7th row
            case R.id.fortyEight:
                gridActivity.putExtra("year",71);
                break;
            case R.id.sevetyThree:
                //9th row
            case R.id.fifty:
            case R.id.fiftyFive:
            case R.id.fortySeven:
                //14th row
            case R.id.sixty:
                gridActivity.putExtra("year",73);
                break;
            //2nd row
            case R.id.seventy:
                //10th row
            case R.id.fiftyTwo:
                //13th row
            case R.id.fiftyEight:
                gridActivity.putExtra("year",70);
                break;
            //3rd row
            case R.id.fortyFour:
            case R.id.seventyFive:
            case R.id.fiftySix:
            case R.id.sixtyTwo:
                //17th row
            case R.id.sixtyFive:
                gridActivity.putExtra("year",75);
                break;
            case R.id.seventyTwo:
                //11th row
            case R.id.fiftyFour:
            case R.id.fiftyNine:
                gridActivity.putExtra("year",72);
                break;
            //6th row
            case R.id.seventyFour:
                //8th row
            case R.id.fortyNine:
                //12th row
            case R.id.fiftySeven:
                //15th row
            case R.id.sixtyOne:
                gridActivity.putExtra("year",74);
                break;


        }
        startActivity(gridActivity);
        ((Activity) getActivity()).overridePendingTransition(0,0);

    }
}