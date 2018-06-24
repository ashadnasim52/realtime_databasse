package com.madebyasshad.realtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database=FirebaseDatabase.getInstance();

    DatabaseReference rootref=database.getReference();
    DatabaseReference game=rootref.child("game");
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


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setValue("Rock");
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setValue("Paper");

            }
        });
        scissior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setValue("Scisior");

            }
        });



//
//        rootref.child("user").child("1").child("email").setValue("coolo@gmail.com");
//        rootref.child("user").child("2").child("email").setValue("cooldfgdgdo@gmail.com");

        // Read from the database
        game.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("vlae", "Value is: " + value);
                txt.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("val", "Failed to read value.", error.toException());
            }
        });

    }
}
