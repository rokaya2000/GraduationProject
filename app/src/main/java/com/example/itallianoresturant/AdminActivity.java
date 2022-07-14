package com.example.itallianoresturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itallianoresturant.admin.Admin_Test;
import com.example.itallianoresturant.modul.AdminItem;
import com.example.itallianoresturant.modul.AdminLogin;
import com.example.itallianoresturant.modul.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class AdminActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin );

        email = findViewById ( R.id.admin_edt_email );
        password = findViewById ( R.id.admin_edt_password );
        login = findViewById ( R.id.admin_btn_login );
        db = FirebaseFirestore.getInstance ( );

        login.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String Email = email.getText ( ).toString ( );
                if (TextUtils.isEmpty ( Email )) {
                    email.setError ( "Error" );
                }
                String Password = password.getText ( ).toString ( );
                if (TextUtils.isEmpty ( Email )) {
                    password.setError ( "Error" );
                }
                db.collection ( "Admins" )
                        .whereEqualTo ( "email" , Email ).whereEqualTo ( "password" , Password )
                        .get ( ).addOnSuccessListener ( new OnSuccessListener<QuerySnapshot> ( ) {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                            AdminLogin admin = queryDocumentSnapshots.getDocuments ( ).get ( 0 ).toObject ( AdminLogin.class );
                            Intent intent = new Intent ( getBaseContext ( ) , Admin_Test.class );
                            Toast.makeText ( AdminActivity.this , "success" , Toast.LENGTH_SHORT ).show ( );
                            startActivity ( intent );

                        } else {

                            Toast.makeText ( AdminActivity.this , "User Not Found" , Toast.LENGTH_SHORT ).show ( );
                        }

                    }
                } )
                        .addOnFailureListener ( new OnFailureListener ( ) {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText ( AdminActivity.this , "Failure: " + e.getMessage ( ) , Toast.LENGTH_SHORT ).show ( );
                            }
                        } );
            }
        } );
    }
}
