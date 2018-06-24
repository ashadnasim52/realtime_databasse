package com.madebyasshad.realtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database=FirebaseDatabase.getInstance();

    DatabaseReference rootref=database.getReference();
    TextView txt;
    Button rock,paper,scissior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.textView);
        rock=findViewById(R.id.rock);
        paper=findViewById(R.id.paper);
        scissior=findViewById(R.id.sicissor);


        rootref.child("user").child("1").child("email").setValue("coolo@gmail.com");
        rootref.child("user").child("2").child("email").setValue("cooldfgdgdo@gmail.com");

    }
}
