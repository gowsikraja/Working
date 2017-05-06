package com.example.gowsik.working.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gowsik.working.R;

public class FabricCrash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabric_crash);
        findViewById(R.id.crash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("This is a crash");
            }
        });
    }
   }
