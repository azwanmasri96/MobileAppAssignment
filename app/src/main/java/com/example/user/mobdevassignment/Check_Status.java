package com.example.user.mobdevassignment;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Check_Status extends AppCompatActivity {
    Button check;
    EditText caseID;
    TextView status;
    public boolean nonExist = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__status);

        check = (Button) findViewById(R.id.check);

        caseID = (EditText) findViewById(R.id.checkCaseID);

        status = (TextView) findViewById(R.id.statusCheck);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caseIDStr = caseID.getText().toString();

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Request").child(caseIDStr);

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        nonExist = false;
                        status.setText(dataSnapshot.child("condition").getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if(nonExist){
                    Toast.makeText(getApplicationContext(), "Data do not exist", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Data exist", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
