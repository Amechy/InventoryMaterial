package com.example.inventory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.pojo.Dependency;
import com.example.inventory.pojo.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 */
// Solucion A NO OPTIMIZADA.
public class DependencyAdapterB extends ArrayAdapter<Dependency> {
    public DependencyAdapterB(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DependencyHolder dependencyHolder;


        View view = convertView;

        if (view == null) {


            //Obtener el servicio inflater desde el contexto
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Inflamos la vista.
            view = inflater.inflate(R.layout.item_dependency, null);

            //3 Asignamos los elementos de la vista. Cuidado,view.findIdView
            dependencyHolder = new DependencyHolder();
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvPrimary);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvSecondary);
            view.setTag(dependencyHolder);
        }
        else {
            dependencyHolder = (DependencyHolder) view.getTag();
        }




        //4. Mostramos los datos del ArrayList mediandte posicion
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortName.setText(getItem(position).getShortname());
        return view;
    }

    class DependencyHolder {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;
    }


}
