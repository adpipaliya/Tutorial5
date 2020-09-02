package com.example.tutorial_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView fname,lname,email,pswd,switch1,city,gender,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        pswd = findViewById(R.id.pswd);
        switch1 = findViewById(R.id.switch1);
        city = findViewById(R.id.city);
        gender = findViewById(R.id.gender);
        status = findViewById(R.id.status);

        Intent intent = getIntent();
        fname.setText("First Name:"+intent.getStringExtra("fname"));
        lname.setText("Last Name:"+intent.getStringExtra("lname"));
        email.setText("Email:"+intent.getStringExtra("email"));
        pswd.setText("Password:"+intent.getStringExtra("pswd"));
        switch1.setText("Branch:"+intent.getStringExtra("switch1"));
        city.setText("City:"+intent.getStringExtra("City"));
        gender.setText("Gender:"+intent.getStringExtra("radioButton"));
        status.setText("Status:"+intent.getStringExtra("checkBox"));
    }
}