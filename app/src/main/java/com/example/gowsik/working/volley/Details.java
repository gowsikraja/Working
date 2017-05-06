package com.example.gowsik.working.volley;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by gowsik on 04-05-2017.
 */

public class Details {
    private String name,email,phone;


    public Details(String name,String email,String phone) {
        this.name=name;
        this.email=email;
        this.phone=phone;
    }
    public String getNames(){return this.name;}
    public String getEmail(){return this.email;}
    public String getphone(){return this.phone;}
}
