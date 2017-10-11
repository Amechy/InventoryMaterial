package com.example.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Vector;

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        gridDashBoard=(GridLayout)findViewById(R.id.gridDashBoard);

        //Definimos un array de int que contenemos las imagenes

        int[] images= {
                R.drawable.chair, R.drawable.closet,R.drawable.cpu,
                R.drawable.inventory, R.drawable.keyboard, R.drawable.monitor,
                R.drawable.mouse, R.drawable.printer, R.drawable.proyector,
                R.drawable.table,R.drawable.whiteboard};

        // Definir un array de ImageView o en este caso un Vector

        //No se utiliza en java android arrays de objetos, se utilizan vector o collecciones
        //ImageView[] imageViews = new ImageView[images.length];
        // No utilizamos la clase vector porque no trabajamos con hilos y no se requiere sincronización
        //Vector<ImageView> VectorImageViews = new Vector<ImageView>();

        //Al poner el tipo en ImageView, el arrayList se parametriza y hay un casting implicito.



        /* //Debemos
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

        ImageView imageView;
        int width=(int)getResources().getDimension(R.dimen.imgDashboardWidth);
        int height=(int)getResources().getDimension(R.dimen.imgDashboardHeight);


        for (int i = 0;i<images.length;i++)
        {
            imageView = new ImageView(this);


            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=width;
            params.height=height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);

            imageView.setImageResource(i);
            imageView.setLayoutParams(params);

            gridDashBoard.addView(imageView);
        }



    }
}
