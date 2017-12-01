package com.example.inventoryMaterial.ui.dependency.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependency extends Fragment implements DetailDependencyContract.View{

    public static final String TAG = "detaildependency";
    DetailDependencyContract.Presenter presenter;

    interface DetailDependencyListener{
        void showDependencyDetails();
    }

    public static DetailDependency newInstance(Bundle arguments){
        DetailDependency detailDependency = new DetailDependency();
        if (arguments != null){
            detailDependency.setArguments(arguments);
        }
        return detailDependency;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_dependency,container,false);
        return rootView;

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setPresenter(DetailDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
