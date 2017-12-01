package com.example.inventoryMaterial.ui.dependency.fragment;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.pojo.Dependency;
import com.example.inventoryMaterial.ui.base.BaseFragment;
import com.example.inventoryMaterial.ui.base.BasePresenter;
import com.example.inventoryMaterial.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryMaterial.ui.utils.AddEdit;

public class AddEditDependency extends BaseFragment implements AddEditDependencyContract.View{

    public static final String TAG = "addeditdependency";
    public static final String EDIT_KEY = "edit";


    private AddEditDependencyContract.Presenter presenter;
    private AddEditDependencyListener callback;
    private AddEdit mode;
    private FloatingActionButton fabDependency;


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


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            callback = (AddEditDependencyListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDepedencyListener");
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency,container,false);

        fabDependency = (FloatingActionButton)rootView.findViewById(R.id.floatingActionButtonSave);


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

        if (getArguments() != null){
            mode = new AddEdit(AddEdit.EDIT_MODE);
        }else{
            mode = new AddEdit();
        }

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mode.getMode() == AddEdit.ADD_MODE){
                    presenter.saveDependency(
                            tiEName.getText().toString(),
                            tiEShortName.getText().toString(),
                            tiEDescription.getText().toString()
                    );
                }else if(mode.getMode() == AddEdit.EDIT_MODE){
                    Dependency dependency = getArguments().getParcelable(EDIT_KEY);
                    dependency.setDescription(tiEDescription.getText().toString());
                    presenter.editDependency(dependency);
                }
            }
        });

        if (mode.getMode() == AddEdit.EDIT_MODE){
            Dependency dependency = getArguments().getParcelable(EDIT_KEY);

            tiEName.setText(dependency.getName());
            tiEName.setEnabled(false);

            tiEShortName.setText(dependency.getShortname());
            tiEShortName.setEnabled(false);

            tiEDescription.setText(dependency.getDescription());

        }
    }



    @Override
    public void navigateToListDependency(){
        callback.listDependency();
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


    interface AddEditDependencyListener{
        void listDependency();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
