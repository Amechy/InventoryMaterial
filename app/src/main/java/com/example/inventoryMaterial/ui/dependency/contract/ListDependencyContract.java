package com.example.inventoryMaterial.ui.dependency.contract;

import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.base.BasePresenter;
import com.example.inventoryMaterial.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void showDependency(List<Dependency> list);
    }
    interface  Presenter extends BasePresenter{


        void loadDependency();
        void deleteDependency(Dependency dependency);
    }
    interface Interactor{

        void loadDependency(OnLoadFinishedListener onLoadFinishedListener);
        void deleteDependency(Dependency dependency, OnLoadFinishedListener listener);

        interface OnLoadFinishedListener{
            void onSuccess(List<Dependency> list);
        }

    }
}
