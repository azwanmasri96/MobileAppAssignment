package com.example.user.mobdevassignment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RequestRecordAdapter extends ArrayAdapter<Request> {

    public RequestRecordAdapter(Activity context, int resource, List<Request> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Request requestRecord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()). inflate(R.layout.request_record, parent, false);
        }

        TextView textViewCaseID, textViewStatus, textViewDetails;

        textViewCaseID = (TextView) convertView.findViewById(R.id.textViewName);
        textViewStatus = (TextView) convertView.findViewById(R.id.textViewPhone);
        textViewDetails = (TextView) convertView.findViewById(R.id.textViewEmail);
        textViewCaseID.setText(requestRecord.getCaseID());
        textViewStatus.setText(requestRecord.getCondition());
        textViewDetails.setText(requestRecord.getProblem());

        return convertView;
    }
}
