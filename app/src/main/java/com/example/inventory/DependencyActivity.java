package com.example.inventory;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.inventory.pojo.Dependency;

public class DependencyActivity extends ListActivity {


    private ArrayAdapter<Dependency> dependecies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        dependecies= new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
                ((InventoryApplication)getApplicationContext()).getDependencies());
        getListView().setAdapter(dependecies);
    }
}
