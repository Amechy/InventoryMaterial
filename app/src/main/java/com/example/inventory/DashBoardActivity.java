package com.example.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

/**
 * Clase que se encarga de rellenar el gridLayout del dashboard y lanzar cada activity según la que se pulse.
 * @author Alejandro Mechiné
 *
 */


public class DashBoardActivity extends AppCompatActivity {
    private static int INVENTORY;
    private static int PRODUCT;
    private static int DEPENDENCY;
    private GridLayout gridDashBoard;
    private ClickListenerDashboard listenerDashboard;
    int[] images= {
            R.drawable.product, R.drawable.inventory,R.drawable.secciones, R.drawable.dependencias, R.drawable.preferencias
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        gridDashBoard=(GridLayout)findViewById(R.id.gridDashBoard);
        listenerDashboard = new ClickListenerDashboard();

        //Definimos un array de int que contenemos las imagenes inventory, product, dependencias,secciones,preferencias.


        /*int[] idImages= {
                R.id.imvProducto, R.id.imvInventory, R.id.imvSecciones, R.id.imvDependencias, R.id.imvPreferencias
        };
        */


        // Definir un array de ImageView o en este caso un Vector

        //No se utiliza en java android arrays de objetos, se utilizan vector o collecciones
        //ImageView[] imageViews = new ImageView[images.length];
        //No utilizamos la clase vector porque no trabajamos con hilos y no se requiere sincronización
        //Vector<ImageView> VectorImageViews = new Vector<ImageView>();

        //Al poner el tipo en ImageView, el arrayList se parametriza y hay un casting implicito.



        /*
        for (int i = 0;i<images.length;i++)
        {
            //Necesitamos el contexto para crear un objeto view
            if (arrayImageViews.get(i) instanceof ImageView)

            {
                arrayImageViews.add(new ImageView(this));

            }
            arrayImageViews.get(i).setImageResource();
        }
        */


        int width=(int)getResources().getDimension(R.dimen.imgDashboardWidth);
        int height=(int)getResources().getDimension(R.dimen.imgDashboardHeight);



        ImageView imageView;
        /**
         * Con este bucle vamos creando cada imagen y la vamos anadiendo al Gridlayout
         */
        for (int i = 0;i<images.length;i++)
        {
            imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            GenerateId(i,imageView);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=width;
            params.height=height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);

            //Aplicamos el params
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(listenerDashboard);
            imageView.setPadding(20,20,20,20);
            //Lo añadimos al GridLayout
            gridDashBoard.addView(imageView);
        }



    }

    /**
     * Método que genera un id único para cada imagen
     * @param i
     * @param iv
     */

    private void GenerateId(int i, ImageView iv) {
        switch(images[i]){
            case R.drawable.inventory:
                INVENTORY = View.generateViewId();
                iv.setId(INVENTORY);
                break;

            case R.drawable.product:
                PRODUCT = View.generateViewId();
                iv.setId(PRODUCT);
                break;
            case R.drawable.dependencias:
                DEPENDENCY = View.generateViewId();
                iv.setId(DEPENDENCY);
                break;

        }
    }


/**
 *  Con esta clase hacemos que al pulsar las imágenes, se abra la actividad correspondiente a cada una de ellas.
 */
   class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent;

            if (v.getId()==INVENTORY) {
                intent = new Intent(DashBoardActivity.this, InventoryActivity.class);
                startActivity(intent);
            }
            if (v.getId()==PRODUCT) {
                intent = new Intent(DashBoardActivity.this, ProductActivity.class);
                startActivity(intent);
            }
            if (v.getId()==DEPENDENCY) {
                intent = new Intent(DashBoardActivity.this, DependencyActivity.class);
                startActivity(intent);
            }
        }
    }

}
