package com.example.inventoryMaterial.ui.dependency.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.adapter.DependencyAdapter;
import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.base.BasePresenter;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryMaterial.ui.utils.CommonDialog;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements  ListDependencyContract.View{

    public static final String TAG = "listdependency";

    DependencyAdapter adapter;
    private ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;
    private FloatingActionButton fabDependency;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

    interface ListDependencyListener{
        void addNewDependency(Bundle bundle);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    public static ListDependency newInstance(Bundle arguments){

        ListDependency listDependency = new ListDependency();

        if (arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }

    public ListDependency() {

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_dependency,container, false);

        // Como se encuentra en mim fragment usamos rootview.
        fabDependency = (FloatingActionButton)rootView.findViewById(R.id.floatingActionButtonAdd);
        //Si el floating action button se encontrara en el xml de la activity,


        presenter.loadDependency();
        return rootView;
    }




    /**
     * Este metodo se asigna el adapter vacio sin datos.
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerForContextMenu(getListView());
        setListAdapter(adapter);

        fabDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewDependency(null);
            }
        });

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dependency dependency = (Dependency)parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(AddEditDependency.EDIT_KEY,dependency);

                callback.addNewDependency(bundle);
            }
        });


        Log.d(TAG,"ListDependency: OnViewCreated");
    }



   @Override
    public void showDependency(List<Dependency> list){
        adapter.clear();
        adapter.addAll(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones de lista de dependencia");
        getActivity().getMenuInflater().inflate(R.menu.menu_listdependency, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Dependency dependency = (Dependency) getListView().getItemAtPosition(info.position);
        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:
                Bundle bundle = new Bundle();
                bundle.putString(CommonDialog.MESSAGE, "Desea eliminar la dependencia");
                bundle.putString(CommonDialog.TITTLE, "Eliminar dependencia");
                bundle.putParcelable(CommonDialog.DEPENDENCY, dependency);
                Dialog dialog = CommonDialog.showConfirmDialog(bundle, getActivity(), presenter);
                dialog.show();
                break;
        }


        return super.onContextItemSelected(item);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //presenter.onDestroy();
        //adapter = null;
    }
}

