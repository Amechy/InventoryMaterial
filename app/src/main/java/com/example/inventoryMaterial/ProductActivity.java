package com.example.inventoryMaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * Clase que gestiona los datos de la interfaz de producto.
 * @autor Alejandro Mechiné
 *
 */
public class ProductActivity extends AppCompatActivity {

    Spinner spnCategorias, spnSubCategorias, spnTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        spnCategorias = (Spinner) findViewById(R.id.spnCategorias);
        spnSubCategorias = (Spinner) findViewById(R.id.spnSubCategorias);
        spnTipo = (Spinner) findViewById(R.id.spnTipo);


        /**
         * Para los spinner, necesitamos un ArrayAdapter para que nos infle los datos del array en la vista.
         */
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