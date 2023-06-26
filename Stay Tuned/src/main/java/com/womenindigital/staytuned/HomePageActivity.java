package com.womenindigital.staytuned;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity {
    private TextView popupTextView;
    private ImageView popupImageView;
    private Button popupOkButton;
    private AppBarConfiguration mAppBarConfiguration;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        overridePendingTransition(0, 0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        popupOkButton = findViewById(R.id.popupOkButton);

        myDialog = new Dialog(this);

        myDialog.setContentView(R.layout.popup);


        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration
                .Builder(R.id.nav_home,R.id.nav_speech, R.id.nav_gallery,R.id.nav_lifehistory,
                R.id.nav_photo,R.id.nav_books,R.id.nav_slideshow,R.id.nav_pictures, R.id.nav_photos)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home_page, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void closePopUp(View view) {
        myDialog.dismiss();
    }
}
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                writeQuoteIntent = new Intent(HomePageActivity.this,WriteQuoteActivity.class);
//                startActivity(writeQuoteIntent);
//
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });

//        settingsDialog = new Dialog(this);
//        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.popup
//                , null));
//        settingsDialog.show();