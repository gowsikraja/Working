package com.example.gowsik.working.recyclerview;

/**
 * Created by gowsik on 26-04-2017.
 */

public class Items {
    private String title, class_name;

    public Items(String title, String name) {
        this.title = title;
        this.class_name = name;
    }
    public String getTitle(){
        return this.title;
    }

    public String getClass_name(){
        return this.class_name;
    }

}
