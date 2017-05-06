package com.example.gowsik.working.volley;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

/**
 * Created by gowsik on 03-05-2017.
 */

public class VolleySingleton {

    private static VolleySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingleton(Context context){
        this.context=context;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){

            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized VolleySingleton getmInstance(Context context){
        if (mInstance==null){
            mInstance=new VolleySingleton(context);
        }
        return mInstance;
    }

    public<T> void addRequest(Request<T> request){
        requestQueue.add(request);
    }

}