package com.example.inventoryMaterial.ui.dependency;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.adapter.DependencyAdapterA;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements ListDependencyContract.View{

    public static final String TAG = "listdependency";

    ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;

    interface ListDependencyListener{
        void addNewDependency();
        void editDependency(int item);
    }

    public static ListDependency newInstance(Bundle arguments){

        ListDependency listDependency = new ListDependency();

        if (arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
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
        return rootView;
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapterA(getActivity()));
    }

    @Override
    public void setPresenter(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
