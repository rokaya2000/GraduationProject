package com.example.itallianoresturant.admin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itallianoresturant.R;
import com.example.itallianoresturant.RegisterActivity;
import com.example.itallianoresturant.UserActivity;
import com.example.itallianoresturant.modul.AdminItem;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Admin_Test extends AppCompatActivity {

    private static final String TAG = "Admin_Test";
    String category = "";
    ImageButton imageButton;
    EditText editTextName, editTextDesc, editTextPrice;
    Uri selectedImage = null;

    FirebaseFirestore db ;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin__test );

        db = FirebaseFirestore.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        imageButton = (ImageButton) findViewById ( R.id.img1 );
        editTextName = (EditText) findViewById ( R.id.name );
        editTextDesc = (EditText) findViewById ( R.id.description );
        editTextPrice = (EditText) findViewById ( R.id.price );


        RadioGroup group = (RadioGroup) findViewById ( R.id.group );
        group.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup , int i) {
                switch (i){
                    case R.id.sweet:
                    category = "sweet";
                    break;
                    case R.id.meals:
                        category = "meals";
                        break;
                    case R.id.juices:
                        category = "juices";
                        break;
                    case R.id.salad:
                        category = "salad";
                        break;
                    case R.id.sanswishes:
                        category = "sandwishes";
                        break;
                    case R.id.apatizer:
                        category = "apatizer";
                        break;
                }
            }
        } );


    }

    public void AddNewItem(View view) {

        String mcategory = category;
        String mname = editTextName.getText ().toString ();
        String mprice = editTextPrice.getText ().toString ();
        String mdesc = editTextDesc.getText ().toString ();

        if(mcategory.isEmpty () | mname.isEmpty () | mprice.isEmpty () | mdesc.isEmpty ()){
            Toast.makeText ( this , "Empty text" , Toast.LENGTH_SHORT ).show ( );
        } else if(selectedImage == null){
            Toast.makeText ( this , "Empty image" , Toast.LENGTH_SHORT ).show ( );
        } else {

        final String id = ""+ new Date (  );
        AdminItem item = new AdminItem (id,mcategory , mname, mdesc, mprice, ""+selectedImage  );

            db.collection(category).add(item).addOnSuccessListener(new OnSuccessListener<DocumentReference> () {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText ( Admin_Test.this , "success1" , Toast.LENGTH_SHORT ).show ( );
                            Log.d(TAG, "success 1 ");

                           StorageReference riversRef = mStorageRef.child("images/"+id);
                           riversRef.putFile(selectedImage)
                                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot> () {
                                        @Override
                                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                            Toast.makeText ( Admin_Test.this , "success22" , Toast.LENGTH_SHORT ).show ( );
                                            Log.d(TAG, "success22");
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener () {
                                        @Override
                                        public void onFailure(@NonNull Exception exception) {
                                            // Handle unsuccessful uploads
                                            // ...
                                        }
                                    });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener () {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
        }
    }

    public void uploadImage(View view) {

        startActivityForResult(new Intent (Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI), 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if(requestCode==1 && resultCode == Activity.RESULT_OK) {
            selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                imageButton.setImageBitmap ( bitmap );

            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}