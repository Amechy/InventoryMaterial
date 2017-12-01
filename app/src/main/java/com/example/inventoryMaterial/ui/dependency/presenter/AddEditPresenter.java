package com.example.inventoryMaterial.ui.dependency.presenter;

import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.interactor.AddEditInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditDependencyContract.Presenter, AddEditInteractor.OnDependencyAddFinishedListenner {
    private AddEditDependencyContract.View view;
    private AddEditInteractor interactor;

    public AddEditPresenter (AddEditDependencyContract.View view)
    {
        this.view = view;
        interactor = new AddEditInteractorImpl();
    }



    @Override
    public void validateDependency(String name, String shortname, String desc) {
        interactor.validateDependency(name,shortname,desc, this);
    }

    @Override
    public void OnNameEmptyError() {
        view.showErrorName();
        view.setNameError();
    }

    @Override
    public void OnShortNameEmptyError() {
        view.showErrorShortName();
        view.setShortNameError();
    }

    @Override
    public void OnDescriptionEmptyError() {
        view.showErrorDescription();
        view.setDescError();

    }

    @Override
    public void OnDependencyDuplicated() {
         view.showDependencyExitsError();
    }


    @Override
    public void onSuccess() {
        view.showListDependency();
    }
}
