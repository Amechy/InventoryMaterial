package com.example.inventoryMaterial.ui.dependency.presenter;

import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryMaterial.ui.dependency.interactor.ListDependencyInteractorImpl;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter, ListDependencyInteractor.OnLoadFinishedListener{
    ListDependencyContract.View view;
    private ListDependencyInteractorImpl listDependencyInteractorImpl;

    public ListPresenter(ListDependencyContract.View view){
        this.view = view;
        this.listDependencyInteractorImpl = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependency() {
        listDependencyInteractorImpl.loadDependency();
    }

    @Override
    public void onSuccess(List<Dependency> list) {

    }


}
