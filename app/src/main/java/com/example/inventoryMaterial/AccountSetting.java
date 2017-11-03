package com.example.inventoryMaterial;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class AccountSetting extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_setting);
    }
}
