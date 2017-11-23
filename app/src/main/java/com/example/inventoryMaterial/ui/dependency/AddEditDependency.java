package com.example.inventoryMaterial.ui.dependency;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View{

    public static final String TAG = "addeditdependency";

    AddEditDependencyContract.Presenter presenter;

    public static AddEditDependency newInstance(Bundle arguments){
        AddEditDependency addEditDependency = new AddEditDependency();
        if (arguments != null){
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency,container,false);
        if (getArguments() != null)
        {

        }
        return rootView;
    }

    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
