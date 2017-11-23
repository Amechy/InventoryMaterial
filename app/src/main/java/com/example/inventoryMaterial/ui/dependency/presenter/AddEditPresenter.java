package com.example.inventoryMaterial.ui.dependency.presenter;

import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditDependencyContract.Presenter {
    AddEditDependencyContract.View view;

    public AddEditPresenter (AddEditDependencyContract.View view)
    {
        this.view = view;
    }
}
