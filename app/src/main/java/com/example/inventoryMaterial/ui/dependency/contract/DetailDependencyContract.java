package com.example.inventoryMaterial.ui.dependency.contract;

import com.example.inventoryMaterial.ui.dependency.DetailDependency;

/**
 * Created by usuario on 23/11/17.
 */

public interface DetailDependencyContract {
    interface View{
        void setPresenter(DetailDependencyContract.Presenter presenter);
    }
    interface  Presenter{

    }
}
