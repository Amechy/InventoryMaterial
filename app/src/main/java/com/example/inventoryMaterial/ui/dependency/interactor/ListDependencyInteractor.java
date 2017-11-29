package com.example.inventoryMaterial.ui.dependency.interactor;

import com.example.inventoryMaterial.pojo.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {
    interface OnLoadFinishedListener{
        void onSuccess(List<Dependency> list);
    }
    void loadDependency();
}
