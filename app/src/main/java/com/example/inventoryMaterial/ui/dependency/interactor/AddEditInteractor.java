package com.example.inventoryMaterial.ui.dependency.interactor;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditInteractor {
    void validateDependency(String name, String shortName, String description, OnDependencyAddFinishedListenner listener);
    interface OnDependencyAddFinishedListenner{

        void OnNameEmptyError();
        void OnShortNameEmptyError();
        void OnDescriptionEmptyError();
        void OnDependencyDuplicated();
        void onSuccess();
    }
}
