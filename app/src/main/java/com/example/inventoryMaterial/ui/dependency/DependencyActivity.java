package com.example.inventoryMaterial.ui.dependency;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.inventoryMaterial.ui.base.BaseActivity;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.DetailDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryMaterial.ui.dependency.fragment.AddEditDependency;
import com.example.inventoryMaterial.ui.dependency.fragment.DetailDependency;
import com.example.inventoryMaterial.ui.dependency.fragment.ListDependency;
import com.example.inventoryMaterial.ui.dependency.presenter.AddEditPresenter;
import com.example.inventoryMaterial.ui.dependency.presenter.ListPresenter;

/**
 * @author Alejandro mechiné
 */
public class DependencyActivity extends BaseActivity implements ListDependency.ListDependencyListener{
    private ListDependency listDependency;
    private ListDependencyContract.Presenter listPresenter;

    private AddEditDependency addEditDependency;
    private AddEditDependencyContract.Presenter addEditPresenter;

    private DetailDependency detailDependency;
    private DetailDependencyContract.Presenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        listDependency=(ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency == null){

            listDependency = (ListDependency) ListDependency.newInstance(null);
            fragmentTransaction.add(android.R.id.content,listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }

        // se crea el presentador y se le pasa el constructor la vista correspondiente
        listPresenter = new ListPresenter(listDependency);

        // Si necesitamos se asigna el presnetador a su fragment
        listDependency.setPresenter(listPresenter);


    }




    @Override
    public void addNewDependency(Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addEditDependency=(AddEditDependency) fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if (addEditDependency== null){
            addEditDependency = (AddEditDependency) addEditDependency.newInstance(null);
            fragmentTransaction.replace(android.R.id.content,addEditDependency, AddEditDependency.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        // se crea el presentador y se le pasa el constructor la vista correspondiente
        addEditPresenter = new AddEditPresenter(addEditDependency);

        //Asignamos el presenter a la vista.
        addEditDependency.setPresenter(addEditPresenter);
    }

   /* @Override
    public void editDependency(int item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addEditDependency = (AddEditDependency)fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if (addEditDependency == null)
        {
        }
    }

    @Override
    public void returnToDependencyList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }


    @Override
    public void showDependencyDetails() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        detailDependency = (DetailDependency)fragmentManager.findFragmentByTag(DetailDependency.TAG);
        if (detailDependency == null){

        }
    }
    */
}
