package com.example.gowsik.working.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gowsik.working.R;
import com.example.gowsik.working.firebase.FireRegFragment;
import com.example.gowsik.working.firebase.FireViewFragment;
import com.example.gowsik.working.firebase.MyDialogInterface;

public class FirebaseActivity extends AppCompatActivity {

    Button enter,view;
    FragmentManager fragmentManager;
    MyDialogInterface myDialogInterface;
    FireViewFragment fireRegFragment;
    FireRegFragment fireViewFragment;
//    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        enter=(Button)findViewById(R.id.enter);
        view=(Button)findViewById(R.id.view);
        fragmentManager=getFragmentManager();
//        firebaseDatabase=FirebaseDatabase.getInstance();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fragmentManager.findFragmentByTag("registration");
                if (fragment!=null){
                    fragmentManager.beginTransaction().remove(fragment);
                }
                fireViewFragment=new FireRegFragment(myDialogInterface);
                fireViewFragment.show(fragmentManager,"registration");
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fragmentManager.findFragmentByTag("view_details");

                fireRegFragment=new FireViewFragment(myDialogInterface);
                if (fragment!=null){
                    fragmentManager.beginTransaction().remove(fragment);
                }

                fireRegFragment.show(fragmentManager,"view_details");
            }
        });
        myDialogInterface=new MyDialogInterface() {
            @Override
            public void setMyDialogInterface(String recive, boolean isRegiter) {
                Log.d("Interface","Calling");
                if (!isRegiter) {
                    fireRegFragment.dismiss();
                }else fireViewFragment.dismiss();
            }
        };
    }


}
