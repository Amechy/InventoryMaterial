package com.example.inventoryMaterial.ui.dependency.presenter;

import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter{
    ListDependencyContract.View view;
    public ListPresenter(ListDependencyContract.View view){
        this.view = view;
    }

}
