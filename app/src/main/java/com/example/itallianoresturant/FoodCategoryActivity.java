package com.example.itallianoresturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.ULocale;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.itallianoresturant.Adapters.CategoryAdapter;
import com.example.itallianoresturant.Adapters.FoodCategoryAdapter;
import com.example.itallianoresturant.Adapters.OnRecycleDetailsItemClickListener;
import com.example.itallianoresturant.Adapters.OnRecyclerViewItemClickListener;
import com.example.itallianoresturant.modul.AdminItem;
import com.example.itallianoresturant.modul.Category;
import com.example.itallianoresturant.modul.FoodCategory;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class FoodCategoryActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView food_category_image;
    private TextView food_category_tittle;
    private RecyclerView food_category_rv;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_food_category );

        food_category_rv = findViewById ( R.id.food_category_rv );
        db = FirebaseFirestore.getInstance ( );
        Intent intent = getIntent ( );
        int id = intent.getIntExtra ( "categor_id" , 0 );

        getData ( id );

    }

    private void getData(int id) {

      /*  db.collection("Food Category").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                    Toast.makeText ( FoodCategoryActivity.this , queryDocumentSnapshots.size ( ) + "" , Toast.LENGTH_SHORT ).show ( );
                    ArrayList<Category> categories = new ArrayList<> ( );
                    for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                        Category c = q.toObject ( Category.class );
                        categories.add ( c );
                    }
                    populateDataIntoRV ( categories );
                }
            }

            private void populateDataIntoRV(ArrayList<Category> categories) {
                CategoryAdapter c = new CategoryAdapter(getBaseContext(),categories, new OnRecyclerViewItemClickListener<Category>() {

                    @Override
                    public void ONItemClick(int id) {


                    }
                });
                food_category_rv.setAdapter(c);
                food_category_rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                food_category_rv.setHasFixedSize(true);
            }
        });*/



       Category cat_sweet = new Category ( 0 , "sweet" , R.drawable.sweets );
        Category cat_juice = new Category ( 1 , "juice" , R.drawable.drinks );
        Category cat_salad = new Category ( 2 , "salad" , R.drawable.salad );
        Category cat_sandwishes = new Category ( 3 , "sandwishes" , R.drawable.sandwishes );
        Category cat_meals = new Category ( 4 , "meals" , R.drawable.meals );
        Category cat_apatizer = new Category ( 5 , "apatizer" , R.drawable.appt );


       if (id == 0) {
            db.collection ( "sweet" )
                    .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                            if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                                List<AdminItem> adminItems = new ArrayList<> ( );
                                for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                    AdminItem adminItem = q.toObject ( AdminItem.class );
                                    adminItems.add ( adminItem );
                                }
                                populateDataIntoRV ( adminItems );
                            }
                        }
                    } );
        }else if (id == 1) {
            db.collection ( "juices" )
                    .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                            if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                                List<AdminItem> adminItems = new ArrayList<> ( );
                                for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                    AdminItem adminItem = q.toObject ( AdminItem.class );
                                    adminItems.add ( adminItem );
                                }
                                populateDataIntoRV ( adminItems );
                            }
                        }
                    } );
        } else if (id == 2) {
            db.collection ( "salad" )
                    .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                            if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                                List<AdminItem> adminItems = new ArrayList<> ( );
                                for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                    AdminItem adminItem = q.toObject ( AdminItem.class );
                                    adminItems.add ( adminItem );
                                }
                                populateDataIntoRV ( adminItems );
                            }
                        }
                    } );
        } else if (id == 3) {
            db.collection ( "sandwishes" )
                    .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                            if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                                List<AdminItem> adminItems = new ArrayList<> ( );
                                for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                    AdminItem adminItem = q.toObject ( AdminItem.class );
                                    adminItems.add ( adminItem );
                                }
                                populateDataIntoRV ( adminItems );
                            }
                        }
                    } );
        } else if (id == 4) {
            db.collection ( "meals" )
                    .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                            if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                                List<AdminItem> adminItems = new ArrayList<> ( );
                                for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                    AdminItem adminItem = q.toObject ( AdminItem.class );
                                    adminItems.add ( adminItem );
                                }
                                populateDataIntoRV ( adminItems );
                            }
                        }
                    } );
        } else if (id == 5) {
            db.collection ( "apatizer" )
                    .addSnapshotListener ( new EventListener<QuerySnapshot> ( ) {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots , @Nullable FirebaseFirestoreException e) {
                            if (queryDocumentSnapshots != null && queryDocumentSnapshots.size ( ) > 0) {
                                List<AdminItem> adminItems = new ArrayList<> ( );
                                for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                                    AdminItem adminItem = q.toObject ( AdminItem.class );
                                    adminItems.add ( adminItem );
                                }
                                populateDataIntoRV ( adminItems );
                            }
                        }
                    } );
        }

    }
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
   /*   db.collection("Food Category").addSnapshotListener(new EventListener<QuerySnapshot>() {
          @Override
         public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
              Toast.makeText(FoodCategoryActivity.this, queryDocumentSnapshots.size() + "", Toast.LENGTH_SHORT).show();
           ArrayList<Category> categories = new ArrayList<>();
               for (QueryDocumentSnapshot q : queryDocumentSnapshots){
                   Category c = q.toObject(Category.class);
                    categories.add(c);
             }
             CategoryAdapter c = new CategoryAdapter(getBaseContext(),categories, new OnRecyclerViewItemClickListener<Category>() {

                   @Override
                  public void ONItemClick(int id) {


                   }
              });
             food_category_rv.setAdapter(c);
            food_category_rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
             food_category_rv.setHasFixedSize(true);
        }
       });*/

    private void populateDataIntoRV(final List<AdminItem> adminItems) {
        FoodCategoryAdapter adapter = new FoodCategoryAdapter ( adminItems , this , new OnRecycleDetailsItemClickListener<AdminItem> ( ) {
            @Override
            public void ONDetalsItem(int id) {

               Intent intent = new Intent ( getBaseContext ( ) , DetailsCategoryActivity.class );
                // intent.putExtra ( "foodCategory_id" , id );
                intent.putExtra ( "details", adminItems.get ( id ) );
               startActivity ( intent );
            }
        } );

        food_category_rv.setAdapter ( adapter );
        food_category_rv.setLayoutManager ( new GridLayoutManager ( this,1 ) );
        food_category_rv.setHasFixedSize ( true );
    }

}