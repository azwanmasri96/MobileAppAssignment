package com.example.user.mobdevassignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.mobdevassignment.Database.DatabaseHelper;
import com.example.user.mobdevassignment.Model.Engineer;
import com.example.user.mobdevassignment.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class engineerSignUp extends AppCompatActivity  {

    private ImageButton profpic,idpict;

//    private static final int SELECT_PHOTO=1;
//    private static final int CAPTURE_PHOTO=2;
//
//    private ProgressDialog progressBar;
//    private int progressBarStatus=0;
//    private Handler progressBarHandler=new Handler();
//    private boolean hasImageChanged=false;

    DatabaseHelper helper=new DatabaseHelper(this);
    private String username,email,mobilenum,address,gender,occupation,experience,cpassword,password,idcard,idnum;
    String age;
    private EditText etuname,etemail,etmobile,etaddress,etage,etpw,etcpw,etidnum;
    private Spinner spgender,spoccupation,spexperience,spidtype;
    Button signUp;

    ArrayAdapter<CharSequence> adapter;

    Bitmap thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer_sign_up);

        profpic=findViewById(R.id.ib_eu_profpic);
        idpict=findViewById(R.id.ib_eu_idpic);
        etuname=findViewById(R.id.et_eu_username);
        etemail=findViewById(R.id.et_eu_email);
        etmobile=findViewById(R.id.et_eu_mobile);
        etaddress=findViewById(R.id.et_eu_address);
        etage=findViewById(R.id.et_eu_age);
        etpw=findViewById(R.id.et_eu_password);
        etcpw=findViewById(R.id.et_eu_cpassword);
        etidnum=findViewById(R.id.et_eu_idcard);

        spgender=(Spinner) findViewById(R.id.sp_eu_gender);

        spoccupation=(Spinner)findViewById(R.id.sp_eu_occupation);
        spexperience=(Spinner)findViewById(R.id.sp_eu_experience);
        spidtype=(Spinner)findViewById(R.id.sp_eu_idcard);

        signUp=findViewById(R.id.engineer_btn_signUp);

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

        spexperience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text;
                text = parent.getItemAtPosition(position).toString();
                experience=text;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spidtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text;
                text = parent.getItemAtPosition(position).toString();
                idcard=text;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=etuname.getText().toString();
                email=etemail.getText().toString();
                mobilenum=etmobile.getText().toString();
                address=etaddress.getText().toString();
                password=etpw.getText().toString();
                cpassword=etcpw.getText().toString();
                idnum=etidnum.getText().toString();
                age=etage.getText().toString();

                if(!password.equals(cpassword)){
                    Toast.makeText(engineerSignUp.this, "Password don't match!", Toast.LENGTH_SHORT).show();

                }else {
                    //                     Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference mDatabase = database.getInstance().getReference();

                    mDatabase.child("Users").child(username).child("Password").setValue(password);
                    mDatabase.child("Users").child(username).child("Email").setValue(email);
                    mDatabase.child("Users").child(username).child("Mobile Number").setValue(mobilenum);
                    mDatabase.child("Users").child(username).child("Age").setValue(age);
                    mDatabase.child("Users").child(username).child("Gender").setValue(gender);
                    mDatabase.child("Users").child(username).child("Occupation").setValue(occupation);

                    Intent intent=new Intent(engineerSignUp.this,engineerSignIn.class);
                    startActivity(intent);
                }
            }
        });

    }

}
