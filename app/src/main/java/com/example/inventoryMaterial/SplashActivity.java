package com.example.inventoryMaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);

        
    }
}
