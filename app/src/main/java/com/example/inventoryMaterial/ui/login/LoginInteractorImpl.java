package com.example.inventoryMaterial.ui.login;

import android.text.TextUtils;


import com.example.inventoryMaterial.ui.utils.CommonUtils;


/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl{

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListenner listenner) {
        //Realiza todas las  comrpobaciones

        if(TextUtils.isEmpty(user)) {
            listenner.OnUserEmptyError();
        }else if (TextUtils.isEmpty(password)) {
            listenner.OnPasswordEmptyError();
        }else if (!CommonUtils.isPasswordValid(password)) {
            listenner.OnPasswordError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)
            listenner.onSuccess();
        }

        //Y es correcto
    }




}
