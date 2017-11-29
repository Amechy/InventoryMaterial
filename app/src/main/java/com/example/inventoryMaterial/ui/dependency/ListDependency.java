package com.example.inventoryMaterial.ui.dependency;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.adapter.DependencyAdapterA;
import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.base.BasePresenter;
import com.example.inventoryMaterial.ui.base.BaseView;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements  ListDependencyContract.View, AddEditDependency.AddNewDependencyClickListener{

    public static final String TAG = "listdependency";

    DependencyAdapterA adapter;
    private ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }
    interface ListDependencyListener{
        void addNewDependency();

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

    public static Fragment newInstance(Bundle arguments){

        ListDependency listDependency = new ListDependency();

        if (arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapterA(getActivity());
        setRetainInstance(true);
    }

    public ListDependency() {

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_dependency,container, false);

        // Como se encuentra en mim fragment usamos rootview.
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.floatingActionButtonAdd);
        //Si el floating action button se encontrara en el xml de la activity,

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                callback.addNewDependency();
            }

        });
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

        setListAdapter(adapter);


        Log.d(TAG,"ListDependency: OnViewCreated");
    }


    @Override
    public void returnToDependencyList() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
    }







   @Override
    public void showDependency(List<Dependency> list){
        adapter.clear();
        adapter.addAll(list);
    }

}
