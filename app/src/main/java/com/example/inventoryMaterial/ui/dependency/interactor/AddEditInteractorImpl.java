package com.example.inventoryMaterial.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventoryMaterial.data.db.repository.DependencyRepository;
import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.dependency.AddEditDependency;
import com.example.inventoryMaterial.ui.login.LoginInteractor;
import com.example.inventoryMaterial.ui.utils.CommonUtils;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditInteractorImpl implements AddEditInteractor{


    @Override
    public void validateDependency(String name, String shortName, String description, OnDependencyAddFinishedListenner listener) {

        if(TextUtils.isEmpty(name)) {
            listener.OnNameEmptyError();
        }else if (TextUtils.isEmpty(shortName)) {
            listener.OnShortNameEmptyError();
        }else if (TextUtils.isEmpty(description)) {
            listener.OnDescriptionEmptyError();
        }else if (true) {
            DependencyRepository.getInstance().addDependency(new Dependency(DependencyRepository.getInstance().getDependencies().size()+1,name,shortName,description));
            listener.onSuccess();

        }else{
            listener.OnDependencyDuplicated();
        }
    }
}
