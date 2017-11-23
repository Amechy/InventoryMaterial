package com.example.inventoryMaterial.ui.dependency;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View{
    private static final String TAG = "addeditdependency";
    AddEditDependencyContract.Presenter presenter;

    public static AddEditDependency newInstance(Bundle arguments){
        AddEditDependency addEditDependency = new AddEditDependency();
        if (arguments != null){
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }


    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        presenter = this.presenter;
    }
}
