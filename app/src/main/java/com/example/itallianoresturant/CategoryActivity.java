package com.example.itallianoresturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itallianoresturant.Adapters.CategoryAdapter;
import com.example.itallianoresturant.Adapters.OnRecyclerViewItemClickListener;
import com.example.itallianoresturant.modul.Category;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Nullable;

public class CategoryActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    private ImageView category_image;
    private TextView category_tittle;
    private RecyclerView category_rv;
    FirebaseFirestore db;
    DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        toolbar = findViewById ( R.id. toolbar);
        setSupportActionBar ( toolbar );

//        toolbar = findViewById(R.id.category_toolbar);

        category_tittle = findViewById(R.id.category_textview);
        category_rv = findViewById(R.id.category_rv);
        db = FirebaseFirestore.getInstance();

        getData();

    }
/*    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_bar, menu);

        MenuItem save = menu.findItem(R.id.item_menu_save);
        MenuItem edit = menu.findItem(R.id.item_menu_edit);
        MenuItem delete = menu.findItem(R.id.item_menu_delete);
        MenuItem cart = menu.findItem(R.id.item_menu_cart);
        MenuItem orders = menu.findItem(R.id.item_menu_orders);
        MenuItem codes = menu.findItem(R.id.item_menu_code);
        MenuItem info = menu.findItem(R.id.item_menu_info);

        info.setVisible(false);
        save.setVisible(false);
        edit.setVisible(false);
        delete.setVisible(false);
        cart.setVisible(false);
        orders.setVisible(false);
        codes.setVisible(false);

        return true;
    }*/
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categorymenu, menu);
        MenuItem shopping = menu.findItem(R.id.category_menu_shopping);
        MenuItem search = menu.findItem(R.id.category_menu_search);
        SearchView searchView = (SearchView) menu.findItem(R.id.category_menu_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }*/

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

    private void getData() {

     /*   db.collection("Category").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                Toast.makeText(CategoryActivity.this, queryDocumentSnapshots.size() + "", Toast.LENGTH_SHORT).show();
                ArrayList<Category> categories = new ArrayList<>();
                for (QueryDocumentSnapshot q : queryDocumentSnapshots){
                    Category c = q.toObject(Category.class);
                    categories.add(c);
                }
                populateDataIntoRV(categories);
            }
        });*/

       Category cat_sweet = new Category ( 0, "sweet", R.drawable.sweets );
        Category cat_juice = new Category ( 1, "juice", R.drawable.drinks );
        Category cat_salad = new Category ( 2, "salad", R.drawable.salad );
        Category cat_sandwishes = new Category ( 3, "sandwishes", R.drawable.sandwishes );
        Category cat_meals = new Category ( 4, "meals", R.drawable.meals );
       Category cat_apatizer = new Category ( 5, "apatizer", R.drawable.apttizer );

        ArrayList<Category> categories = new ArrayList<>();
        categories.add ( cat_sweet );
        categories.add ( cat_juice );
        categories.add ( cat_salad );
        categories.add ( cat_sandwishes );
        categories.add ( cat_meals );
        categories.add ( cat_apatizer );

        populateDataIntoRV(categories);

    }

    private void populateDataIntoRV(ArrayList<Category> categories) {
        CategoryAdapter adapter = new CategoryAdapter(getBaseContext(),categories, new OnRecyclerViewItemClickListener<Category>() {
            @Override
            public void ONItemClick(int id) {
                Intent intent = new Intent(getBaseContext(),FoodCategoryActivity.class);
                intent.putExtra ( "categor_id" ,id);
                startActivity ( intent );
            }
        });
        category_rv.setAdapter(adapter);
        category_rv.setLayoutManager(new GridLayoutManager(this,2));
        category_rv.setHasFixedSize(true);
    }
}