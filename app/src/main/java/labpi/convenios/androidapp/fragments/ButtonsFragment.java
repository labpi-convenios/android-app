package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import labpi.convenios.androidapp.R;

public class ButtonsFragment extends Fragment implements View.OnClickListener{

    public ButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        addButtonsListeners(view);

        return view;
    }

    public void addButtonsListeners(View view){

        Button reportButton = (Button) view.findViewById(R.id.report_button);
        reportButton.setOnClickListener(this);

        Button cancelButton = (Button) view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(this);

        Button shareButton = (Button) view.findViewById(R.id.share_button);
        shareButton.setOnClickListener(this);

        Button whatButton = (Button) view.findViewById(R.id.what_button);
        whatButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_button:
                getFragmentManager().popBackStack();
                break;
            case R.id.share_button:
                ShareFragment shareFragment = new ShareFragment();
                getFragmentManager().popBackStack();
                getFragmentManager().beginTransaction().add(R.id.layout_project_description, shareFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.report_button:
                ReportFragment reportFragment = new ReportFragment();
                getFragmentManager().beginTransaction().replace(R.id.layout_project_description, reportFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.what_button:
                WhatFragment whatFragment = new WhatFragment();
                getFragmentManager().beginTransaction().replace(R.id.layout_project_description, whatFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.follow_button:
                //Colocar aqui o que deve ser feito ao clicar no botao compartilhar
                break;
            default:

        }

    }
}
