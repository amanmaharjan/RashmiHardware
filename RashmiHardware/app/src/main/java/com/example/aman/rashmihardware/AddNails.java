package com.example.aman.rashmihardware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddNails extends AppCompatActivity {

    EditText category, size, quantity, actualPrice, sellingPrince;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nails);

        //intitializig the component
        category = (EditText) findViewById(R.id.edtxt_category);
        size = (EditText) findViewById(R.id.edtxt_size);
        quantity = (EditText) findViewById(R.id.edtxt_qantity);
        actualPrice = (EditText) findViewById(R.id.edtxt_ActualPrice);
        sellingPrince = (EditText) findViewById(R.id.edtxt_SellingPrice);
        submit = (Button) findViewById(R.id.btn_submit);

        //setting action on submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (category.getText().toString().isEmpty() && size.getText().toString().isEmpty() && quantity.getText().toString().isEmpty()
                        && actualPrice.getText().toString().isEmpty() && sellingPrince.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill All the Field", Toast.LENGTH_SHORT).show();
                } else if (category.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill Category Field", Toast.LENGTH_SHORT).show();
                } else if (size.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill Size Field", Toast.LENGTH_SHORT).show();
                } else if (quantity.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill Quantity Field", Toast.LENGTH_SHORT).show();
                } else if (actualPrice.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill ActualPrice Field", Toast.LENGTH_SHORT).show();
                } else if (sellingPrince.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill SellingPrice Field", Toast.LENGTH_SHORT).show();
                } else {
                    //calling the volley for sending data
                    sendNailData();
                    Toast.makeText(getApplicationContext(), "Data Added Sucessfully", Toast.LENGTH_SHORT).show();
                    ClearAll();

                }
            }
        });


    }

    private void sendNailData() {
        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_Nail_submit, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Category", category.getText().toString());
                params.put("Size", size.getText().toString());
                params.put("Quantity", quantity.getText().toString());
                params.put("ActualPrice", actualPrice.getText().toString());
                params.put("SellingPrice", sellingPrince.getText().toString());
                return params;
            }

        };

        // Adding request to request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strReq);
    }

    private void ClearAll()
    {
        category.setText("");
        size.setText("");
        quantity.setText("");
        actualPrice.setText("");
        sellingPrince.setText("");
    }
}
