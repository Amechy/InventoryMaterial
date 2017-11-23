package com.example.inventoryMaterial.ui.dependency.contract;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View{
        void setPresenter(ListDependencyContract.Presenter presenter);
    }
    interface  Presenter{


    }
}
