 package com.saiproject.firebase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = db.getReferenceFromUrl("https://fir-1-f8eb2.firebaseio.com/");

        final EditText edtBoxerID = findViewById(R.id.edtBoxerID);
        final EditText edtBoxerName = findViewById(R.id.edtBoxerName);
        final EditText edtPunchPower = findViewById(R.id.edtPunchPower);
        final EditText edtPunchSpeed = findViewById(R.id.edtSpeed);

        Button btnSendDataToServer = findViewById(R.id.btnSendData);

        btnSendDataToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.child(edtBoxerID.getText().toString()).child("Name").setValue(edtBoxerName.getText().toString()); // Create a child of object under Boxer iD child with key
                myRef.child(edtBoxerID.getText().toString()).child("Punch Power").setValue(edtPunchPower.getText().toString()); // Create a child of object under Boxer iD child with key
                myRef.child(edtBoxerID.getText().toString()).child("Punch Speed").setValue(edtPunchSpeed.getText().toString()); // Create a child of object under Boxer iD child with key
            }
        });

    }
}
