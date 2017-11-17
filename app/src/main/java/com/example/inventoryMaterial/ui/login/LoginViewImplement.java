package com.example.inventoryMaterial.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.inventoryMaterial.DashBoardActivity;
import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.ui.base.BaseActivity;

/**
 * @author Alejandro Mechiné
 * @version 1.0
 *
 */
public class LoginViewImplement extends BaseActivity implements LoginView {

    //private TextView txvSignUp;
    private Button btnSignIn;
    private EditText etxUser;
    private EditText etxPassword;
    LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        etxUser = (EditText) findViewById(R.id.etxUser);
        etxPassword = (EditText)findViewById(R.id.etxPassword);
        loginPresenter = new LoginPresenterImpl(this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loginPresenter.validateCredentials("Amechy", "1234");
                loginPresenter.validateCredentials(etxUser.getText().toString(),etxPassword.getText().toString());
            }
        });


    }
    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginViewImplement.this, DashBoardActivity.class);
        startActivity(intent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPasswordLength);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
