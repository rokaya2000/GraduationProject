package com.example.itallianoresturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itallianoresturant.modul.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class UserActivity extends AppCompatActivity {
     private EditText email;
    private EditText password;
     private Button login;
     private Button register;
    FirebaseFirestore db;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        email = findViewById(R.id.user_edt_email);
        password = findViewById(R.id.user_edt_password);
        login = findViewById(R.id.user_btn_login);
        register = findViewById(R.id.user_btn_register);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();
        db = FirebaseFirestore.getInstance();
//        sp = PreferenceManager.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                if (TextUtils.isEmpty(Email)){
                    email.setError("Error");
                }
                String Password = password.getText().toString();
                if (TextUtils.isEmpty(Email)){
                    password.setError("Error");
                }
                db.collection("Users")
                        .whereEqualTo("email",Email).whereEqualTo("password",Password)
                        .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots != null && queryDocumentSnapshots.size()>0){
                            User u = queryDocumentSnapshots.getDocuments().get(0).toObject(User.class);
                            editor.putString ( "name",u.getFirst_name () );
                            editor.apply ();
                            Intent intent = new Intent(getBaseContext(),CategoryActivity.class);
                            Toast.makeText(UserActivity.this, "success", Toast.LENGTH_SHORT).show();
                            startActivity(intent);

                        }else{
                            Toast.makeText(UserActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UserActivity.this, "Failure: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                }

        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),RegisterActivity.class);
                startActivity(intent);

            }
        });


      /* Intent intent = getIntent();
        String Email = intent.getStringExtra("Email");


        email.setText(Email);*/


    }
}
