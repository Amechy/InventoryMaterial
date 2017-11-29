package com.example.inventoryMaterial.ui.dependency;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.ui.base.BaseFragment;
import com.example.inventoryMaterial.ui.base.BasePresenter;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryMaterial.ui.dependency.interactor.AddEditInteractor;

public class AddEditDependency extends BaseFragment implements AddEditDependencyContract.View{

    public static final String TAG = "addeditdependency";


    private AddEditDependencyContract.Presenter presenter;

    private TextInputEditText tiEName;
    private TextInputEditText tiEShortName;
    private TextInputEditText tiEDescription;


    public static AddEditDependency newInstance(Bundle arguments){
        AddEditDependency addEditDependency = new AddEditDependency();
        if (arguments != null){
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency,container,false);



        tiEDescription = (TextInputEditText) rootView.findViewById(R.id.tieDescription);
        tiEDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tiEDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tiEShortName = (TextInputEditText) rootView.findViewById(R.id.tieShortName);
        tiEShortName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tiEShortName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tiEName = (TextInputEditText) rootView.findViewById(R.id.tieName);
        tiEName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tiEName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        // para buscar el floatingActionVutton seria buscandolo en getActivity.
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.floatingActionButtonSave);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateDependency(
                        tiEName.getText().toString(),
                        tiEShortName.getText().toString(),
                        tiEDescription.getText().toString());
            }
        });



        if(getArguments()!=null)//es editar
        {

        }

        return rootView;




    }







    @Override
    public void showListDependency() {
        showMessage("Dependency saved");
        getActivity().finish();
        startActivity(getActivity().getIntent());
    }

    @Override
    public void showErrorName() {
        tiEName.setError(getResources().getString(R.string.errorAddDependencyNameEmpty));
    }

    @Override
    public void showErrorShortName() {
        tiEShortName.setError(getResources().getString(R.string.errorAddDependencyShortnameEmpty));
    }

    @Override
    public void showErrorDescription() {
        tiEDescription.setError(getResources().getString(R.string.errorAddDependencyDescriptionEmpty));
    }

    @Override
    public void showDependencyExitsError() {
        showMessage(getResources().getString(R.string.errorAddDependencyDependencyDuplicate));
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter)presenter;
    }

    @Override
    public void setNameError() {
        tiEName.setError("Nombre Vacio");
    }

    @Override
    public void setShortNameError() {
        tiEShortName.setError("Nombre corto vacio");
    }

    @Override
    public void setDescError() {
        tiEDescription.setError("Descripcion vacia");
    }

    interface AddNewDependencyClickListener
    {
        void returnToDependencyList();
    }


}
