package com.example.aman.rashmihardware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //BUttons
    Button Add,View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Add=(Button)findViewById(R.id.btn_add);
        Button View=(Button)findViewById(R.id.btn_view);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(),AddNails.class);
                startActivity(in);
            }
        });

    }
}
