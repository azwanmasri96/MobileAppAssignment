package com.example.user.mobdevassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class userHome extends AppCompatActivity {
    ImageButton tips,checkStatus,laptopService,desktopService,phoneService,chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        tips = (ImageButton) findViewById(R.id.ib_tips);

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userHome.this,Tips.class);
                startActivity(intent);
            }
        });

        checkStatus = (ImageButton) findViewById(R.id.ib_checkstatus);

        checkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userHome.this,Check_Status.class);
                startActivity(intent);
            }
        });

        laptopService = (ImageButton) findViewById(R.id.ib_laptservice);

        laptopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userHome.this,Report_Problem.class);
                startActivity(intent);
            }
        });

        phoneService = (ImageButton) findViewById(R.id.ib_phoneservice);

        phoneService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userHome.this,Report_Problem.class);
                startActivity(intent);
            }
        });

        desktopService = (ImageButton) findViewById(R.id.ib_deskservice);

        desktopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userHome.this,Report_Problem.class);
                startActivity(intent);
            }
        });

        chat = (ImageButton) findViewById(R.id.ib_purchasehardware);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userHome.this,Chat.class);
                startActivity(intent);
            }
        });


    }
}
