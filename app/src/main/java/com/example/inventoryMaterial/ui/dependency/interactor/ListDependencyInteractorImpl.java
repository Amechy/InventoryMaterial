package com.example.inventoryMaterial.ui.dependency.interactor;

import com.example.inventoryMaterial.data.db.repository.DependencyRepository;
import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl  implements ListDependencyContract.Interactor{



    @Override
    public void loadDependency(OnLoadFinishedListener onLoadFinishedListener) {
        onLoadFinishedListener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void deleteDependency(Dependency dependency, OnLoadFinishedListener listener) {
        DependencyRepository.getInstance().deleteDependency(dependency);
    }
}
