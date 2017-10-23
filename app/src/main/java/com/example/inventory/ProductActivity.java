package com.example.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ProductActivity extends AppCompatActivity {

    Spinner spnCategorias, spnSubCategorias, spnTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        spnCategorias = (Spinner) findViewById(R.id.spnCategorias);
        spnSubCategorias = (Spinner) findViewById(R.id.spnSubCategorias);
        spnTipo = (Spinner) findViewById(R.id.spnTipo);



        ArrayAdapter<CharSequence> adpCategoria = ArrayAdapter.createFromResource(this,
                R.array.categorias, android.R.layout.simple_spinner_item);

        adpCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategorias.setAdapter(adpCategoria);

        ArrayAdapter<CharSequence> adpSubCategoria = ArrayAdapter.createFromResource(this,
                R.array.tipoProducto, android.R.layout.simple_spinner_item);

        adpSubCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSubCategorias.setAdapter(adpSubCategoria);

        ArrayAdapter<CharSequence> adpTipo = ArrayAdapter.createFromResource(this,
                R.array.subCategorias, android.R.layout.simple_spinner_item);

        adpSubCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipo.setAdapter(adpTipo);
    }
}