package com.example.aman.rashmihardware;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewNails extends AppCompatActivity {

    RecyclerView data;
    EditText search=null;
    ArrayList<HashMap<String, String>> NailData;
    HashMap<String,String > test;
    private NailDetailAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_nails);
        search=(EditText) findViewById(R.id.nailsearch);
        data=(RecyclerView)findViewById(R.id.naillist);
        NailData=new ArrayList<>();
/*
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setAdapter(null);
                search(search.getText().toString());
            }
        });
*/
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               // data.setAdapter(null);
                //   search(search.getText().toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // data.setAdapter(null);
               // search(search.getText().toString());


            }

            @Override
            public void afterTextChanged(Editable s) {
                NailData.clear();
                data.setAdapter(null);
                search(search.getText().toString());

            }
        });



        display();

    }

    private void display()
    {
        StringRequest naildata = new StringRequest(Request.Method.GET, AppConfig.URL_Nail_submit, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jobj= null;
                try {
                    jobj = new JSONObject(response);

                    JSONArray myarray=jobj.getJSONArray("Data");
                    for (int i=0;i<=myarray.length();i++)
                    {
                        JSONObject c = myarray.getJSONObject(i);
                        String Category = c.getString("Category");
                        String Size = c.getString("Size");
                        String Quantity = c.getString("Quantity");
                        String ActualPrice = c.getString("ActualPrice");
                        String SellingPrice = c.getString("SellingPrice");

                        HashMap<String, String> NailDetails = new HashMap<>();
                        NailDetails.put("Category", Category);
                        NailDetails.put("Size", Size);
                        NailDetails.put("Quantity", Quantity);
                        NailDetails.put("ActualPrice", ActualPrice);
                        NailDetails.put("SellingPrice", SellingPrice);

                        //adding to  the array list
                        NailData.add(NailDetails);


                        mAdapter = new NailDetailAdapter(ViewNails.this, NailData);
                        data.setAdapter(mAdapter);
                        data.setLayoutManager(new LinearLayoutManager(getApplicationContext()));




                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }






            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error In VOlley",Toast.LENGTH_SHORT).show();



            }
        });

        // Adding request to request queue
        RequestQueue requeue=Volley.newRequestQueue(this);
        requeue.add(naildata);


    }
    private void search(final String searchQuery)
    {
        StringRequest naildata = new StringRequest(Request.Method.POST, AppConfig.URL_Nail_Search, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jobj= null;
                try {
                    jobj = new JSONObject(response);

                    JSONArray myarray=jobj.getJSONArray("Data");
                    for (int i=0;i<=myarray.length();i++)
                    {
                        JSONObject c = myarray.getJSONObject(i);
                        String Category = c.getString("Category");
                        String Size = c.getString("Size");
                        String Quantity = c.getString("Quantity");
                        String ActualPrice = c.getString("ActualPrice");
                        String SellingPrice = c.getString("SellingPrice");

                        HashMap<String, String> NailDetails = new HashMap<>();
                        NailDetails.put("Category", Category);
                        NailDetails.put("Size", Size);
                        NailDetails.put("Quantity", Quantity);
                        NailDetails.put("ActualPrice", ActualPrice);
                        NailDetails.put("SellingPrice", SellingPrice);

                        //adding to  the array list
                        NailData.add(NailDetails);

                        data=(RecyclerView)findViewById(R.id.naillist);
                        mAdapter = new NailDetailAdapter(ViewNails.this, NailData);
                        data.setAdapter(mAdapter);
                        data.setLayoutManager(new LinearLayoutManager(getApplicationContext()));




                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }






            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error In VOlley",Toast.LENGTH_SHORT).show();



            }
        })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param=new HashMap<>();
                param.put("searchQuery",searchQuery);
                return param;
            }
        };


        // Adding request to request queue
        RequestQueue requeue=Volley.newRequestQueue(this);
        requeue.add(naildata);


    }

}
