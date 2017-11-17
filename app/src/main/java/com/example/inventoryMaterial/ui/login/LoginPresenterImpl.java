package com.example.inventoryMaterial.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListenner {
    private LoginView loginView;
    private LoginInteractorImpl loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String user, String password) {
        loginInteractor.validateCredentials(user, password, this);

        loginView.navigateToHome();
    }


    @Override
    public void OnUserEmptyError() {
        loginView.setUserEmptyError();
    }

    @Override
    public void OnPasswordEmptyError() {
        loginView.setPasswordEmptyError();
    }

    @Override
    public void OnPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }
    @Override
    public void onDestroy() {
        loginView = null;
        loginInteractor = null;
    }

}
