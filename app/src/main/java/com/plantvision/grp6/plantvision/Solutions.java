package com.plantvision.grp6.plantvision;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Solutions extends AppCompatActivity {

   private FirebaseDatabase db;

    TextView a,b;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);

        //for testing connecion of firebase
       // Toast.makeText(Solutions.this,"Firebase connection Sucess!", Toast.LENGTH_LONG).show();

        a=(TextView)findViewById(R.id.solution_name);
        b=(TextView)findViewById(R.id.method);


        //add the bellow line inside a switch
        reff= FirebaseDatabase.getInstance().getReference().child("Solutions").child("2");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String dname = dataSnapshot.child("Diseas").getValue().toString();
                String solution = dataSnapshot.child("Solution").getValue().toString();

                a.setText(dname);
                b.setText(solution);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
