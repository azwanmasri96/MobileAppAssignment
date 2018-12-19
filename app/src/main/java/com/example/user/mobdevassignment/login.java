package com.example.user.mobdevassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class login extends AppCompatActivity {

    ImageButton user,engineer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=(ImageButton) findViewById(R.id.ib_user);
        engineer=(ImageButton) findViewById(R.id.ib_engineer);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,userSignIn.class);
                startActivity(intent);
            }
        });

        engineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, engineerSignIn.class);
                startActivity(intent);
            }
        });
    }
}
