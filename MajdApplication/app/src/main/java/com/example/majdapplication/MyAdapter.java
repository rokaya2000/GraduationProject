package com.example.majdapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<employee_class> employee_Adapter;
    Context context;

    public MyAdapter(ArrayList<employee_class> employee_Adapter, Context context) {
        this.employee_Adapter = employee_Adapter;
        this.context = context;
    }

    public MyAdapter(ArrayList<employee_class> employee) {
    }

    @Override
    public int getCount() {
        return employee_Adapter.size();
    }

    @Override
    public Object getItem(int i) {
        return employee_Adapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);

        }
            ImageView img_iv = v.findViewById(R.id.img_employee);
            TextView txt_id = v.findViewById(R.id.txt_Id);
            TextView txt_Name = v.findViewById(R.id.txt_Name);
            TextView txt_salary = v.findViewById(R.id.txt_Salary);

            employee_class employee_class1 = employee_Adapter.get(i);

            img_iv.setImageResource(employee_Adapter.get(i).getImg());
            txt_id.setText(employee_Adapter.get(i).getId()+"");
           txt_Name.setText(employee_Adapter.get(i).getName()+"");
           txt_salary.setText(employee_Adapter.get(i).getSalary()+"");


        return v;
    }
}
