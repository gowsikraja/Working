package com.example.gowsik.working.volley;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.gowsik.working.R;
import com.example.gowsik.working.recyclerview.ItemAdapter;
import com.example.gowsik.working.recyclerview.Items;
import com.example.gowsik.working.recyclerview.RecycleViewListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JsonArrayReq extends DialogFragment {

    private RecyclerView list;
    private ItemAdapter adapter;
    private Items items;
    private List<Items> itemList;
    private String name,email,phone,url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_json_array_req, container, false);
        list=(RecyclerView)view.findViewById(R.id.server_list);
        itemList=new ArrayList<>();
        url=getActivity().getResources().getString(R.string.server_url)+"JsonArrayReq.php";

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int coubnt=-0;
                while (coubnt<response.length()){
                    try {
                        JSONObject jsonObject=response.getJSONObject(coubnt);
                        itemList.add(new Items(jsonObject.getString("name"),(jsonObject.getString("email")+" : "+jsonObject.getString("phone"))));
                        coubnt++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new ItemAdapter(itemList, new RecycleViewListener() {
                    @Override
                    public void setOnRecycleViewListener(String title, String class_name) {
                        Toast.makeText(getActivity(),"clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                list.setLayoutManager(new LinearLayoutManager(getActivity()));
                list.setItemAnimator(new DefaultItemAnimator());
                list.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });

        VolleySingleton.getmInstance(getActivity()).addRequest(jsonArrayRequest);

        return view;
    }

}
