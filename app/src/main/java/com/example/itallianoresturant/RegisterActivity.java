package com.example.itallianoresturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.itallianoresturant.modul.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    private ImageView profile;
    private EditText firstName;
    private EditText lastName;
    private EditText password;
    private EditText re_password;
    private EditText email;
    private EditText phone;
    private Button register;
    private Toolbar toolbar;
    FirebaseFirestore db;
    String FirstName,LastName, Phone, Email, Password, Re_Password;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        toolbar = findViewById(R.menu.categorymenu);
        setSupportActionBar(toolbar);
        profile = findViewById(R.id.register_profile_image);
        firstName = findViewById(R.id.registar_edt_firstname);
        password = findViewById(R.id.registar_edt_password);
        lastName = findViewById(R.id.registar_edt_lastname);
        re_password = findViewById(R.id.registar_edt_repassword);
        email = findViewById(R.id.registar_edt_email);
        phone = findViewById(R.id.registar_edt_phone);
        register = findViewById(R.id.register_btn_register);
        db = FirebaseFirestore.getInstance();

      /*  profile.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                return false;
            }
        })*/


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             AddData();


            }
        });
    }

    private void AddData() {

         FirstName = firstName.getText().toString();
        if (TextUtils.isEmpty(FirstName)){
            firstName.setError("Error");
        }
        LastName = lastName.getText().toString();
        if (TextUtils.isEmpty(LastName)){
            lastName.setError("Error");
        }
         Password = password.getText().toString();
        if (TextUtils.isEmpty(FirstName)){
            password.setError("Error");
        }
         Re_Password = re_password.getText().toString();
        if (TextUtils.isEmpty(LastName)){
            re_password.setError("Error");
        }

         Email = email.getText().toString();
        if (TextUtils.isEmpty(Email)){
            email.setError("Error");
        }
         Phone = phone.getText().toString();
        int ph = Integer.parseInt(Phone);
        if (TextUtils.isEmpty(Phone)){
            phone.setError("Error");
        }
        if (Password.equals(Re_Password)){
            User user = new User(1,FirstName,LastName, ph, Email, Password, Re_Password);
            db.collection("Users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override

                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),UserActivity.class);
                    startActivity(intent);


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this, "Failure: "+e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });


        }
        else {
            Toast.makeText ( this , "password not equal re_password" , Toast.LENGTH_SHORT ).show ( );
        }

    }
}