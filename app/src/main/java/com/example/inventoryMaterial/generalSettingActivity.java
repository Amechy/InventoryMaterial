package com.example.inventoryMaterial;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class generalSettingActivity extends PreferenceActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_setting);
    }
}
