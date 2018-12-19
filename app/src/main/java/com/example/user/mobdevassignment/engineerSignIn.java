package com.example.user.mobdevassignment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.mobdevassignment.Database.DatabaseHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class engineerSignIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button btn_signIn,btn_signUp;
    EditText username,password;
    String uname,pw;
    String data="";
    static engineerSignIn INSTANCE;
    boolean nonExist = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer_sign_in);

        username=(EditText) findViewById(R.id.et_username);
        password= (EditText) findViewById(R.id.et_password);


        btn_signIn= (Button) findViewById(R.id.btn_signInEngineer);
        btn_signUp=(Button) findViewById(R.id.btn_signUpEngineer);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(engineerSignIn.this,engineerSignUp.class);
//                Intent intent=new Intent(engineerSignIn.this,repairmanHome.class);
                startActivity(intent);
            }
        });
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mDatabase = database.getInstance().getReference().child("Users").child(username.getText().toString());

                mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String password2 = dataSnapshot.child("Password").getValue().toString();

                        if(password2.equals(password.getText().toString())){
                            data = username.getText().toString();
                            nonExist = false;
                            Intent intent = new Intent(engineerSignIn.this,repairmanHome.class); //engineer home page
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if(nonExist){
                    Toast.makeText(getApplication(),"Password/Username did not exist!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static engineerSignIn getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.data;
    }
}
