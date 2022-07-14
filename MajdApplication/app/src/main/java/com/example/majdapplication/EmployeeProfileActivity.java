package com.example.majdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EmployeeProfileActivity extends AppCompatActivity {
private TextView employee_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);

        employee_id= findViewById(R.id.txt_Employee_Id);

       // Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        employee_id.setText("Employye Id :" +bundle.get("Employee_ID"));
    }
}
