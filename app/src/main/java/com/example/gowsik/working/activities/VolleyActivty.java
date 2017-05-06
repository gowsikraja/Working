package com.example.gowsik.working.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.gowsik.working.R;
import com.example.gowsik.working.volley.ImageReq;
import com.example.gowsik.working.volley.JsonArrayReq;
import com.example.gowsik.working.volley.JsonReq;
import com.example.gowsik.working.volley.SendData;
import com.example.gowsik.working.volley.VolleySingleton;

import login.process.LoginMainActivity;

public class VolleyActivty extends AppCompatActivity {

    Button simple_string, image_req;
    String url;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_activty);
        simple_string = (Button) findViewById(R.id.simple_string);
        image_req = (Button) findViewById(R.id.image_req);
        url = getResources().getString(R.string.server_url) + "SimpleString.php";
        fragmentManager = getFragmentManager();

//        Cache cache=new DiskBasedCache(getCacheDir(),1024*1024);
//        Network network=new BasicNetwork(new HurlStack());


        simple_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Can't catch server", Toast.LENGTH_SHORT).show();
                    }
                });

                VolleySingleton.getmInstance(getApplicationContext()).addRequest(stringRequest);

            }
        });
        image_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = fragmentManager.findFragmentByTag("image_req");

                ImageReq imageReq = new ImageReq();
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment);
                }
                imageReq.show(fragmentManager, "image_req");
            }
        });

        findViewById(R.id.json_req).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = fragmentManager.findFragmentByTag("json_req");
                JsonReq jsonReq = new JsonReq();
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment);
                }
                jsonReq.show(fragmentManager, "json_req");
            }
        });

        findViewById(R.id.json_array_req).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = fragmentManager.findFragmentByTag("json_array");
                JsonArrayReq jsonArrayReq = new JsonArrayReq();
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment);
                }
                jsonArrayReq.show(fragmentManager, "json_array");
            }
        });
        findViewById(R.id.send_json_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = fragmentManager.findFragmentByTag("send_data");
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment);
                }
                SendData sendData = new SendData();
                sendData.show(fragmentManager, "send_data");
            }
        });
        findViewById(R.id.login_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VolleyActivty.this,LoginMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
