package com.example.user.mobdevassignment;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Report_Problem extends AppCompatActivity {
    Button submit;
    EditText problem,phone,model,name;
    TextView caseID;
    private RadioGroup radioUniGroup;
    private RadioButton radioUni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_problem);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.TBRepair);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

        radioUniGroup = (RadioGroup) findViewById(R.id.radioUni);

        submit = (Button) findViewById(R.id.submit);

        problem = (EditText) findViewById(R.id.problem);
        phone = (EditText) findViewById(R.id.phone);
        model = (EditText) findViewById(R.id.model);
        name = (EditText) findViewById(R.id.name);

        caseID = (TextView) findViewById(R.id.caseID);

        String caseIDRandom = generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 9);

        caseID.setText(caseIDRandom);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    // get selected radio button from radioGroup
                    int selectedId = radioUniGroup.getCheckedRadioButtonId();
                    // find the radiobutton by returned id
                    radioUni = (RadioButton) findViewById(selectedId);

//                    FcmNotifier.sendNotification(problem.getText().toString(),"");

//                     Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference mDatabase = database.getInstance().getReference();

                    Request request = new Request(name.getText().toString(),radioUni.getText().toString(),problem.getText().toString(),phone.getText().toString(),model.getText().toString(), "Inactive", "Nobody");
                    mDatabase.child("Request").child(caseID.getText().toString()).setValue(request).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplication(),"Notification sended.",Toast.LENGTH_SHORT).show();
                            // ...
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplication(),"Data failed to send.",Toast.LENGTH_SHORT).show();
                                    // ...
                                }
                            });;



                }catch(Exception e){
                    Toast.makeText(getApplication(),"Error Sending Notification: "+e,Toast.LENGTH_SHORT).show();
                    Log.d("Error Report",e.toString());
                }


                Report_Problem.this.finish(); //Terminate this Activity
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.purchae_hardware:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
}
