package com.example.user.mobdevassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Job_Request extends AppCompatActivity  implements OnItemClickListener {
    ListView listViewRecords;
    RequestSQLHelper requestSQLHelper;
    List<Request> records = new ArrayList<Request>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__request);


        listViewRecords = (ListView) findViewById(R.id.listViewRecords2);
        listViewRecords.setOnItemClickListener(this);
    }

    @Override protected void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Request");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String caseID = ds.getKey();

                    if(ds.child("condition").getValue().toString().equals("Inactive")){
                    Log.d("Condition",ds.child("condition").getValue().toString());

                    Request single = new Request();
                    single.setCaseID(caseID);

                    single.setName(ds.child("name").getValue().toString());
                    single.setUniversity(ds.child("university").getValue().toString());
                    single.setProblem(ds.child("problem").getValue().toString());
                    single.setPhone(ds.child("phone").getValue().toString());
                    single.setModel(ds.child("model").getValue().toString());
                    single.setCondition(ds.child("condition").getValue().toString());

                    records.add(single);
                    }

                }
                if(records.isEmpty()){
                    Toast.makeText(getApplicationContext(), getString(R.string.no_record_message), Toast.LENGTH_SHORT).show();
                }

                RequestListAdapter adapter = new RequestListAdapter(Job_Request.this, R.layout.request_list, records);

                //Link adapter to ListView
                listViewRecords.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}



        };
        ref.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


