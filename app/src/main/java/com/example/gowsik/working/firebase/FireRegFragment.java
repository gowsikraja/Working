package com.example.gowsik.working.firebase;

import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gowsik.working.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FireRegFragment extends DialogFragment {

    EditText name,email,username,password;
    Button reg;
    MyDialogInterface myDialogInterface;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("details");

    public FireRegFragment(MyDialogInterface myDialogInterface) {
        this.myDialogInterface=myDialogInterface;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fire_reg,container,false);
        name=(EditText)view.findViewById(R.id.name);
        email=(EditText)view.findViewById(R.id.email);
        username=(EditText)view.findViewById(R.id.username);
        password=(EditText)view.findViewById(R.id.password);
        reg=(Button)view.findViewById(R.id.register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam=name.getText().toString();
                String ema=email.getText().toString();
                String unam=username.getText().toString();
                String pas=password.getText().toString();
                databaseReference.child("fullname").setValue(nam);
                databaseReference.child("email").setValue(ema);
                databaseReference.child("username").setValue(unam);
                databaseReference.child("password").setValue(pas);
                myDialogInterface.setMyDialogInterface("hi",true);
            }
        });

        return view;
    }
}
