
package com.example.itallianoresturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.itallianoresturant.admin.Admin_Test;
import com.example.itallianoresturant.modul.AdminItem;
import com.example.itallianoresturant.modul.DetailsItem;
import com.example.itallianoresturant.modul.OrderCart;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class DetailsCategoryActivity extends AppCompatActivity {
private ImageView img;
private TextView name;
private TextView price;
private TextView description;
private TextView inc;
private TextView dec;
private EditText num;
private EditText extra;
private Button add;
SharedPreferences sp;
SharedPreferences.Editor editor;
String dimge, dname, ddesc, dextra;
double dprice;
String username;
String extras;
String imgUrl;
FirebaseFirestore db;
int count;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater ();
        menuInflater.inflate ( R.menu.categorymenu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int res_id=item.getItemId ();
        if(res_id==R.id.category_menu_shopping);{
            Intent intent=new Intent ( getBaseContext (),CartActivity.class );
            startActivity ( intent );
            Toast.makeText ( this , "success" , Toast.LENGTH_SHORT ).show ( );
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_category);

        img=findViewById ( R.id.details_img);
        name=findViewById ( R.id.details_catname);
        price=findViewById ( R.id.details_catprice);
        description=findViewById ( R.id.details_catdescribtion);
        extra=findViewById ( R.id.details_extra);
        add=findViewById ( R.id.details_btn_add);
        inc = findViewById ( R.id.item_increase_tv );
        dec = findViewById ( R.id.item_decrease_tv );
        num = findViewById ( R.id.item_count_et );
        db = FirebaseFirestore.getInstance ( );
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();

        username = sp.getString ( "name","no name" );
        inc.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                increaseNumber();
                num.setText ( String.valueOf ( count ) );
            }
        } );

        dec.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                decreaseNumber ();
                if (count <0 ){
                    count = 0;
                }
                num.setText ( String.valueOf ( count ) );
            }
        } );

        add.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                addToCart();
            }
        } );


        Intent intent = getIntent ( );
        AdminItem adminItem = intent.getParcelableExtra ( "details" );
        dname = adminItem.getName ();
        dprice = Double.parseDouble ( adminItem.getPrice ());
        ddesc = adminItem.getDescription ();
        getdata(adminItem);
    }

    private void addToCart() {
        extras = extra.getText ().toString ();
        OrderCart orderCart = new OrderCart ( 1 ,imgUrl,dname,username,extras,dprice,count,(count*dprice));
        db.collection ( "OrderCart" ).add ( orderCart ).addOnSuccessListener ( new OnSuccessListener<DocumentReference> ( ) {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText ( DetailsCategoryActivity.this , "Item Added" , Toast.LENGTH_SHORT ).show ( );

            }
        } ).addOnFailureListener ( new OnFailureListener ( ) {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText ( DetailsCategoryActivity.this , "Failed to add" , Toast.LENGTH_SHORT ).show ( );
            }
        } );
    }

    private void getdata(AdminItem item1) {
   /*     final DetailsItem details_item = new DetailsItem (1, dimge, dname, dprice, ddesc, dextra );

        details_item.getId ();
        details_item.getName ();
        details_item.getImage ();
        details_item.getPrice ();
        details_item.getDescribtion ();
        details_item.getExtra ();

        db.collection ( "sweet" )
                .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                        if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                            for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                DetailsItem details_item = q.toObject ( DetailsItem.class );
                            }
                        }
                    }
                } );


    */


        name.setText (item1.getName ());
        price.setText (item1.getPrice ());
        description.setText (item1.getDescription ());
        imgUrl = item1.getImg ();
        Glide
                .with(DetailsCategoryActivity.this)
                .load(imgUrl)
                .into(img);

        }


    public void decreaseNumber() {
        count-=1;
    }
    public void increaseNumber() {
        count+=1;
    }
}
