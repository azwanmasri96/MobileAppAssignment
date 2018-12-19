package com.example.user.mobdevassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.messaging.FirebaseMessaging;

public class repairmanHome extends AppCompatActivity {
    ImageButton jobRequest,jobHistory,orderPart,calculator,chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairman_home);

        FirebaseMessaging.getInstance().subscribeToTopic("repairman");

        jobRequest = (ImageButton) findViewById(R.id.imageView);
        jobHistory = (ImageButton) findViewById(R.id.imageView2);
        orderPart = (ImageButton) findViewById(R.id.imageView3);
        calculator = (ImageButton) findViewById(R.id.imageView4);
        chat = (ImageButton) findViewById(R.id.imageView3);

        jobRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(repairmanHome.this,Job_Request.class);
                startActivity(intent);
            }
        });

        jobHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(repairmanHome.this,Job_History.class);
                startActivity(intent);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(repairmanHome.this,Chat.class);
                startActivity(intent);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(repairmanHome.this,Calculator.class);
                startActivity(intent);
            }
        });
    }
}
