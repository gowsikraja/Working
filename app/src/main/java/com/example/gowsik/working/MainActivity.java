package com.example.gowsik.working;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.gowsik.working.activities.MapActivity;
import com.example.gowsik.working.recyclerview.ItemAdapter;
import com.example.gowsik.working.recyclerview.Items;
import com.example.gowsik.working.recyclerview.RecycleViewListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private ItemAdapter adapter;
    private Items items;
    String title[]={"Map Working"};
    String classNames[]={"MapActivity"};
    List<Items> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(RecyclerView)findViewById(R.id.list);
        itemList=new ArrayList<>();
        for (int i=0;i<title.length;i++){
            Log.d("Class Lists :",title[i]+" : "+classNames[i]);
            itemList.add(new Items(title[i],classNames[i]));
        }
        adapter=new ItemAdapter(itemList, new RecycleViewListener() {
            @Override
            public void setOnRecycleViewListener(String title, String class_name) {
                String name="com.example.gowsik.working.activities."+class_name;
                try {
                    Class className=Class.forName(name);
                    startActivity(new Intent(MainActivity.this, className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            }
        });

        list.setLayoutManager(new LinearLayoutManager(this));
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(adapter);
    }
}
