package com.example.user.mobdevassignment;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mobdevassignment.Database.DatabaseHelper;



public class userSignIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button btn_signIn,btn_signUp;
    EditText username,password;
    String uname,pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in);

        username=(EditText) findViewById(R.id.et_us_username);
        password= (EditText) findViewById(R.id.et_us_password);


        btn_signIn= (Button) findViewById(R.id.btn_signIn);
        btn_signUp=(Button) findViewById(R.id.btn_signUp);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(userSignIn.this,userSignUp.class);
//                Intent intent=new Intent(userSignIn.this,userHome.class);
                startActivity(intent);
            }
        });
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String pass=helper.searchPass(userSignIn.this.username.getText().toString());
                //search password from database using username
                //if password entered == pasword from db, then proceed
//                if(userSignIn.this.password.getText().toString().equals(pass)){
//                    Intent intent=new Intent(userSignIn.this,userHome.class);
                    Intent intent=new Intent(userSignIn.this,userHome.class);
                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(userSignIn.this,"Password/username don't match!",Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }


}
