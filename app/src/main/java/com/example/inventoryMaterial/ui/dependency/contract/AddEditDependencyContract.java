package com.example.inventoryMaterial.ui.dependency.contract;

import com.example.inventoryMaterial.pojo.Dependency;
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


        void navigateToListDependency();

        void showDependencyExitsError();
    }

    interface  Presenter extends BasePresenter {


        void saveDependency(String name, String shortName, String description);
        void editDependency(Dependency dependency);
    }
    interface Interactor {
        void validateDependency(String name, String shortName, String description, Interactor.OnDependencyAddFinishedListenner listener);
        void addDependency(String name, String shortName, String description);
        void editDependency(Dependency dependency, OnDependencyAddFinishedListenner listenner);

        interface OnDependencyAddFinishedListenner{

            void OnNameEmptyError();
            void OnShortNameEmptyError();
            void OnDescriptionEmptyError();
            void OnDependencyDuplicated();
            void onSuccess();
        }
    }

}
