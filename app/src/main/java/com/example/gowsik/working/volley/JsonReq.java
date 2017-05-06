package com.example.gowsik.working.volley;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.example.gowsik.working.R;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonReq extends DialogFragment {

    TextView name,email,phone;
    String url;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_json_req, container, false);
        name=(TextView)view.findViewById(R.id.j_name);
        email=(TextView)view.findViewById(R.id.j_email);
        phone=(TextView)view.findViewById(R.id.j_phone);
        url=getActivity().getResources().getString(R.string.server_url)+"JsonReq.php";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, (String)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    name.setText(response.getString("name"));
                    email.setText(response.getString("email"));
                    phone.setText(response.getString("phone"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Somthing went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getmInstance(getActivity()).addRequest(jsonObjectRequest);



        return view;
    }

}
