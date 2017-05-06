package com.example.gowsik.working.firebase;


import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gowsik.working.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FireViewFragment extends DialogFragment {

    TextView name, email, username;
    Button ok;
    MyDialogInterface myDialogInterface;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("details");

    public FireViewFragment(MyDialogInterface myDialogInterface) {
        this.myDialogInterface = myDialogInterface;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fire_view, container, false);
        name = (TextView) view.findViewById(R.id.dis_name);
        email = (TextView) view.findViewById(R.id.dis_email);
        username = (TextView) view.findViewById(R.id.dis_uname);
        ok = (Button) view.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialogInterface.setMyDialogInterface("hi", false);

            }
        });



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //String names=databaseReference.getRef();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String d_name= (String) dataSnapshot.child("fullname").getValue();
                String d_email= (String) dataSnapshot.child("email").getValue();
                String d_user= (String) dataSnapshot.child("username").getValue();
                name.setText(d_name);
                email.setText(d_email);
                username.setText(d_user);

                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
