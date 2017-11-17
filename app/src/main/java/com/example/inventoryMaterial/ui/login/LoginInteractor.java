package com.example.inventoryMaterial.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginInteractor {
    void validateCredentials(String user, String password);
    interface OnLoginFinishedListenner{

        void OnUserEmptyError();

        void OnPasswordEmptyError();

        void OnPasswordError();
        void onSuccess();
    }

}
