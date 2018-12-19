package com.example.user.mobdevassignment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.mobdevassignment.Database.DatabaseHelper;
import com.example.user.mobdevassignment.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class userSignUp extends AppCompatActivity implements AdapterView.OnItemClickListener {

//    DatabaseHelper helper = new DatabaseHelper(this);
    String username,email,mobnum,age,pw,cpw,gender,occupation;
    EditText etusername,etemail,etmobnum,etage,etpw,etcpw;
    Button btnSignUp;
    ImageButton ibprofpic;
    Spinner spgender,spoccupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);


        etusername=(EditText) findViewById(R.id.user_username);
        etemail=(EditText) findViewById(R.id.et_email);
        etmobnum=(EditText) findViewById(R.id.et_mobile);
        etage=(EditText) findViewById(R.id.et_age);
        etpw=(EditText) findViewById(R.id.user_password);
        etcpw=(EditText) findViewById(R.id.et_cpassword);
        btnSignUp=(Button) findViewById(R.id.user_btn_signUp);
        ibprofpic=(ImageButton) findViewById(R.id.ib_profPic);
        spgender=(Spinner) findViewById(R.id.sp_gender);
        spoccupation=(Spinner) findViewById(R.id.sp_occupation);

        spgender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text;
                text = parent.getItemAtPosition(position).toString();
                gender=text;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spoccupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text;
                text = parent.getItemAtPosition(position).toString();
                occupation=text;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username= etusername.getText().toString();
                email=etemail.getText().toString();
                pw=etpw.getText().toString();
                cpw=etcpw.getText().toString();
                mobnum=etmobnum.getText().toString();
                age=etage.getText().toString();

                if(!pw.equals(cpw))
                {
                    Toast.makeText(userSignUp.this, "Password don't match!", Toast.LENGTH_SHORT).show();
                }
                else{
//                     Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference mDatabase = database.getInstance().getReference();

                    mDatabase.child("Users").child(username).child("Password").setValue(pw);
                    mDatabase.child("Users").child(username).child("Email").setValue(email);
                    mDatabase.child("Users").child(username).child("Mobile Number").setValue(mobnum);
                    mDatabase.child("Users").child(username).child("Age").setValue(age);
                    mDatabase.child("Users").child(username).child("Gender").setValue(gender);
                    mDatabase.child("Users").child(username).child("Occupation").setValue(occupation);
                    Intent intent=new Intent(userSignUp.this,userSignIn.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String text=parent.getItemAtPosition(position).toString();
//        gender=text;
    }
}
