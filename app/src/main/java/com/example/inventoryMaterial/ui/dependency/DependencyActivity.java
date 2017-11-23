package com.example.inventoryMaterial.ui.dependency;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.inventoryMaterial.ui.base.BaseActivity;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

/**
 * @author Alejandro mechiné
 */
public class DependencyActivity extends BaseActivity implements ListDependency.ListDependencyListener{

    private ListDependency listDependency;
    private ListDependencyContract.Presenter listPresenter;

    private Fragment addEditDependency;
    private AddEditDependencyContract.Presenter addEditPresenter;

    private Fragment detailDependency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        listDependency=(ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency != null){
            listDependency = (ListDependency) ListDependency.newInstance(null);
            fragmentTransaction.add(android.R.id.content,listDependency);
            fragmentTransaction.commit();
        }

        // se crea el presentador y se le pasa el constructor la vista correspondiente
        listPresenter = new ListPresenter(listDependency);

        // Si necesitamos se asigna el presnetador a su fragment
        listDependency.setPresenter(listPresenter);


    }


    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addEditDependency=(AddEditDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (addEditDependency != null){
            listDependency = (ListDependency) ListDependency.newInstance(null);
            fragmentTransaction.replace(android.R.id.content,listDependency);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        addEditPresenter = new AddEditPresenter(addEditDependency);

    }
}
