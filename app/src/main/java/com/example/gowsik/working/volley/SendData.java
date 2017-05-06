package com.example.gowsik.working.volley;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.gowsik.working.R;

import java.util.HashMap;
import java.util.Map;

public class SendData extends DialogFragment {

    private EditText name,email,phone;
    private Button submit;
    String url;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_send_data, container, false);
        name=(EditText)view.findViewById(R.id.enter_name);
        email=(EditText)view.findViewById(R.id.enter_email);
        phone=(EditText)view.findViewById(R.id.enter_phone);
        submit=(Button) view.findViewById(R.id.send_data);
        url=getActivity().getResources().getString(R.string.server_url)+"SendData.php";
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s_name=name.getText().toString();
                final String s_email=email.getText().toString();
                final String s_phone=phone.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String, String>();
                        params.put("name",s_name);
                        params.put("email",s_email);
                        params.put("phone",s_phone);
                        return params;
                    }
                };
                VolleySingleton.getmInstance(getActivity()).addRequest(stringRequest);
            }
        });

        return view;
    }

}
