package com.example.inventory.adapter;


import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.SectorRepository;
import com.example.inventory.pojo.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder>{

    private ArrayList<Sector> sectors;
    //Array que almacenará sectores que se han modificado en la interfaz y aun no se han guardado en la base de datos
    //En nuestro caso, en el repository
    private ArrayList<Sector> sectorsModified;
    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;


    /**
     * este constructor dse llamara cuando sectorActivity venga de un cabio de configuración y
     * se haya salvado el estado dinámico
     * @param sectorsModified
     */
    public SectorAdapter(ArrayList<Sector> sectorsModified) {
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified=sectorsModified;
    }
    public SectorAdapter(){
        sectors = SectorRepository.getInstance().getSectors();
        sectorsModified = new ArrayList<>();
    }




    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =(View)inflater.inflate(R.layout.item_sector, null);
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }

    @Override
    public void onBindViewHolder(SectorViewHolder sectorViewHolder, int position) {
        sectorViewHolder.swtEnabled.setChecked(sectors.get(position).isEnabled());
        sectorViewHolder.txvName.setText(sectors.get(position).getName());
        sectorViewHolder.swtEnabled.setOnCheckedChangeListener(onSwitchCheckedChangeListener);
        if (sectors.get(position).isDefult()){
            sectorViewHolder.txvSectorDefault.setText(R.string.txvSectorDefault);
        }
    }



    /**
     * Se crearán tantos elementos SectorViewHolder como elementos haya en el ArrayList Definido
     * dentro de la clase
     * @return
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }
    public static class SectorViewHolder extends RecyclerView.ViewHolder{
        private Switch swtEnabled;
        private TextView txvName;
        private TextView txvSectorDefault;

        public SectorViewHolder(View itemView) {
            super(itemView);
            txvName = (TextView)itemView.findViewById(R.id.txvSectorName);
            swtEnabled = (Switch)itemView.findViewById(R.id.swtEnabled);
            txvSectorDefault =  (TextView)itemView.findViewById(R.id.txvSectorDefault);

        }



    }

    /**
     * Devuelve el Array de los sectores que el usuario ha modificado cuando
     * la activity estaba visible y que no se ha guardado en la base de datos
     * Hay qu eguardar el estado dinámico
     * @return
     */
    public ArrayList<Sector> getSectorsModified(){
        return sectorsModified;
    }

    class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        }
    }
}


