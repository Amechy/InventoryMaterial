package com.example.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.inventory.pojo.Dependency;
import com.example.inventory.adapter.DependencyAdapterA;

/**
 * @author Alejandro mechiné
 */
public class DependencyActivity extends ListActivity {


    private ArrayAdapter<Dependency> dependecies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        //Caso 1 adapter no personalizado
              /*dependecies= new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
                DependencyRepository.getInstance().getDependencies());*/

        //Caso 2 Adapter personalizado
        dependecies =  new DependencyAdapterA(this);
        getListView().setAdapter(dependecies);


    }
}
