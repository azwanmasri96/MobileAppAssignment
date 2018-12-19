package com.example.user.mobdevassignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class RequestListAdapter extends ArrayAdapter<Request> {

    public RequestListAdapter(Activity context, int resource, List<Request> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Request requestRecord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()). inflate(R.layout.request_list, parent, false);
        }

        TextView textViewCaseID, textViewStatus, textViewDetails;
        Button button;

        button = (Button)  convertView.findViewById(R.id.request);

        textViewCaseID = (TextView) convertView.findViewById(R.id.textViewName);
        textViewStatus = (TextView) convertView.findViewById(R.id.textViewPhone);
        textViewDetails = (TextView) convertView.findViewById(R.id.textViewEmail);
        textViewCaseID.setText(requestRecord.getCaseID());
        textViewStatus.setText(requestRecord.getCondition());
        textViewDetails.setText(requestRecord.getProblem());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "User: "+engineerSignIn.getActivityInstance().getData(), Toast.LENGTH_LONG).show();

                //                     Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mDatabase = database.getInstance().getReference();
                mDatabase.child("Request").child(requestRecord.getCaseID()).child("condition").setValue("Active");
                mDatabase.child("Request").child(requestRecord.getCaseID()).child("repairman").setValue(engineerSignIn.getActivityInstance().getData());

                startActivity(v.getContext());
            }
        });

        return convertView;
    }

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, Job_Request.class));
    }
}
