package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
        Button whatButton = (Button) view.findViewById(R.id.report_button);
        whatButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_button:

                break;
            case R.id.share_button:
                //Colocar aqui o que deve ser feito ao clicar no botao compartilhar
                break;
            case R.id.report_button:
                ReportFragment reportFragment = new ReportFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_project_description, reportFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            default:

        }

    }
}