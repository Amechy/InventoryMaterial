package com.example.inventoryMaterial.ui.dependency.contract;

import com.example.inventoryMaterial.ui.base.BasePresenter;
import com.example.inventoryMaterial.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract{

    interface View  extends BaseView{
        void setNameError();
        void setShortNameError();
        void setDescError();
        void showListDependency();
        void showErrorName();
        void showErrorShortName();
        void showErrorDescription();
        void showDependencyExitsError();
    }

    interface  Presenter extends BasePresenter {
        void validateDependency(String name, String shortname, String desc);
    }
}
