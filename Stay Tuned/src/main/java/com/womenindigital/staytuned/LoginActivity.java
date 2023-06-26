package com.womenindigital.staytuned;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.thekhaeng.pushdownanim.PushDownAnim;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText name,email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        PushDownAnim.setPushDownAnimTo(login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent writeIntent = new Intent(LoginActivity.this,WriteQuoteActivity.class);
                startActivity(writeIntent);
            }
        });

        //loginButton = findViewById(R.id.login_button);



    }

}

