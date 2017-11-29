package com.example.inventoryMaterial.ui.dependency.interactor;

import com.example.inventoryMaterial.data.db.repository.DependencyRepository;
import com.example.inventoryMaterial.pojo.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl  implements ListDependencyInteractor{
    private ListDependencyInteractor.OnLoadFinishedListener listener;
    public ListDependencyInteractorImpl(ListDependencyInteractorImpl.OnLoadFinishedListener listener){
        this.listener = listener;
    }



    public void getDependency(){
        DependencyRepository.getInstance().getDependencies();
    }

    @Override
    public void loadDependency() {
        //listener.onSuccess();
    }
}
