package com.example.inventory;

import android.app.Application;

import com.example.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 25/10/17.
 */

public class InventoryApplication  extends Application{
    ArrayList<Dependency> dependencies;
    public InventoryApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
