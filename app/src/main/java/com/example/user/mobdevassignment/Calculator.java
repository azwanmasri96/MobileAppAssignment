package com.example.user.mobdevassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    EditText cost,price;
    Button calculate;
    TextView commission,toPay;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        cost = (EditText) findViewById(R.id.cost);
        price = (EditText) findViewById(R.id.price);

        calculate = (Button) findViewById(R.id.button7);

        commission = (TextView) findViewById(R.id.textView14);
        toPay = (TextView) findViewById(R.id.textView15);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = Double.parseDouble(cost.getText().toString()) + Double.parseDouble(price.getText().toString());
                commission.setText("RM"+Double.toString((total*0.7)));
                toPay.setText("RM"+Double.toString((total*0.3)));
            }
        });




    }
}
