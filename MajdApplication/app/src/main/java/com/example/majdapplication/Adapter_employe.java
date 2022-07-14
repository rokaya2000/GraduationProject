package com.example.majdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Adapter_employe extends AppCompatActivity {
private ListView listview_lv;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_employe);

        listview_lv =  findViewById(R.id.lv);

        final ArrayList<employee_class> employee = new ArrayList<>();
        employee.add(new employee_class("a","Majd",R.drawable.img_user,1200));
        employee.add(new employee_class("b","Amal",R.drawable.img_user,1300));
        employee.add(new employee_class("c","Ahmed",R.drawable.img_user,1400));
        employee.add(new employee_class("d","Mahmoud",R.drawable.img_user,1500));

        final MyAdapter adapter1 = new MyAdapter(employee, this);
        listview_lv.setAdapter(adapter1);



        listview_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getBaseContext(),EmployeeProfileActivity.class);
                intent.putExtra("Employee_ID",employee.get(i).getId()+"");
                startActivity(intent);
            }
        });


    }
}
