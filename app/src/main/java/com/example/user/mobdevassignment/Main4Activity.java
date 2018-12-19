package com.example.user.mobdevassignment;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class Main4Activity extends AppCompatActivity {
    private static final String TAG = "FirebaseIDService";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        Toolbar myToolbar = (Toolbar) findViewById(R.id.TBMain);
        setSupportActionBar(myToolbar);


        Button a = (Button) findViewById(R.id.button4);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button b = (Button) findViewById(R.id.button5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Report_Problem.class);
                startActivity(intent);
            }
        });

        Button c = (Button) findViewById(R.id.button6);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

        Button d = (Button) findViewById(R.id.button7);

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Tips.class);
                startActivity(intent);
            }
        });

        Button e = (Button) findViewById(R.id.chat);

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Chat.class);
                startActivity(intent);
            }
        });

        Button f = (Button) findViewById(R.id.calculator);

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Calculator.class);
                startActivity(intent);
            }
        });

        Button g = (Button) findViewById(R.id.request_history);

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Job_History.class);
                startActivity(intent);
            }
        });
    }
}
