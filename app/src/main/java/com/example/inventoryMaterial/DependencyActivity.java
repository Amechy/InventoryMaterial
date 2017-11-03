package com.example.inventoryMaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.inventoryMaterial.adapter.DependencyAdapterB;
import com.example.inventoryMaterial.pojo.Dependency;

/**
 * @author Alejandro mechiné
 */
public class DependencyActivity extends AppCompatActivity {

    ListView listView;
    private ArrayAdapter<Dependency> dependecies;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar)findViewById(R.id.toolbar3);
        setContentView(R.layout.activity_dependency);
        //Caso 1 adapter no personalizado
              /*dependecies= new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
                DependencyRepository.getInstance().getDependencies());*/

        //Caso 2 Adapter personalizado
        listView = (ListView) findViewById(android.R.id.list);
        setSupportActionBar(toolbar);

        dependecies =  new DependencyAdapterB(this);
        listView.setAdapter(dependecies);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorDependency);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButtonAdd);
        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DependencyActivity.this,AddDependencyActivity.class));

            }
        });




    }
}
