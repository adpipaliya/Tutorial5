package com.example.tutorial_5;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText fname, lname, email, pswd;
    String firstname, lastname, Email, password;
    Switch switch1;
    RadioGroup radioGroup;
    Spinner dropdownmenu, spinner;
    CheckBox checkBox;
    Button btnreg;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        pswd = (EditText) findViewById(R.id.pswd);
        switch1 = (Switch) findViewById(R.id.switch1);
        spinner = (Spinner) findViewById(R.id.spinner);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        btnreg = (Button) findViewById(R.id.btnreg);


        dropdownmenu = (Spinner) findViewById(R.id.spinner);

        List<String> list = new ArrayList<>();
        list.add("Surat");
        list.add("Rajkot");
        list.add("Vadodara");
        list.add("Junagadh");
        list.add("Ahmedabad");
        list.add("Bharuch");
        list.add("Navasari");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownmenu.setAdapter(adapter);

        dropdownmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String itemvalue = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "selected " + itemvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }


public void register(){
    initialize();
    if (!Validate()){
        Toast.makeText(this, "User Registration Failed", Toast.LENGTH_SHORT).show();
    }
    else {
        onRegisterSuccess();
    }

}

public void onRegisterSuccess(){
    Toast.makeText(this, "User Registration Successfull", Toast.LENGTH_SHORT).show();
    fname.setText("");
    lname.setText("");
    email.setText("");
    pswd.setText("");
}

public boolean Validate() {

    boolean val = true;

    if (firstname.isEmpty()){
        fname.setError("Firstname Can't be blank");
        fname.requestFocus();
        val=false;
    }

    if (lastname.isEmpty()){
        lname.setError("Lastname Can't be blank");
        lname.requestFocus();
        val=false;
    }

    if (Email.isEmpty()){
        email.setError("Email can't be blank");
        email.requestFocus();
        val=false;
    }

    if (password.isEmpty()){
        pswd.setError("Password can't be blank");
        pswd.requestFocus();
        val=false;
    }

    if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
        email.setError("Please Enter Valid Email Address");
        email.requestFocus();
        val=false;
    }

    if (password.length()<4){
        pswd.setError("Password can't be less than 4 characters");
        pswd.requestFocus();
        val=false;
    }

    int id = radioGroup.getCheckedRadioButtonId();
    radioButton=findViewById(id);

    if (val==true){
        Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
        intent.putExtra("fname",fname.getText().toString());
        intent.putExtra("lname",lname.getText().toString());
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("pswd",pswd.getText().toString());
        intent.putExtra("switch1",(switch1.isChecked())?"IT":"CE");
        intent.putExtra("radioButton",radioButton.getText().toString());
        intent.putExtra("City",spinner.getSelectedItem().toString());
        intent.putExtra("checkBox",(checkBox.isChecked())?"Active":"Inactive");

        startActivity(intent);

    }

    return val;


}

    public void initialize() {
        firstname = fname.getText().toString().trim();
        lastname = lname.getText().toString().trim();
        Email = email.getText().toString().trim();
        password = pswd.getText().toString().trim();
    }
}




