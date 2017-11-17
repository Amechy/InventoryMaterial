package com.example.inventoryMaterial.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventoryMaterial.ui.login.LoginViewImplement;
import com.example.inventoryMaterial.R;

/**
 * @autor Alejandro Mechiné
 * @version 1.0
 * Esta Actividad es la primera que se inicia.
 */

public class SplashActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intent = new Intent(SplashActivity.this, LoginViewImplement.class);
        startActivity(intent);

        
    }
}
