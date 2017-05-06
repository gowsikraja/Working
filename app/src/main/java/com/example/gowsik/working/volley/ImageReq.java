package com.example.gowsik.working.volley;


import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.gowsik.working.R;


public class ImageReq extends DialogFragment {

    ImageView imageView;
    String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_image_req, container, false);
        imageView=(ImageView) view.findViewById(R.id.imageView);
        url=getActivity().getResources().getString(R.string.server_url)+"image.jpg";
        ImageRequest imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                imageView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Somthing went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getmInstance(getActivity()).addRequest(imageRequest);
        return view;
    }


}
