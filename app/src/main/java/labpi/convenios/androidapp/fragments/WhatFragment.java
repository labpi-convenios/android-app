package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import labpi.convenios.androidapp.R;

/**
 * Created by izabela on 13/04/16.
 */
public class WhatFragment extends Fragment implements View.OnClickListener{

    RadioButton whyOption;
    RadioButton provesOption;
    TextView alertMessage;
    String WHY_MESSAGE = "Ao confirmar será enviada uma solicitação de esclarimento do porquê dessa proposta ao órgão responsável";
    String PROVES_MESSAGE = "Ao confirmar será enviada uma solicitação de informações sobre a conclusão da proposta";

    public WhatFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_what, container, false);

        alertMessage = (TextView) view.findViewById(R.id.alertTextView);
        alertMessage.setVisibility(View.INVISIBLE);

        whyOption = (RadioButton) view.findViewById(R.id.whyOption);
        whyOption.setOnClickListener(this);

        provesOption = (RadioButton) view.findViewById(R.id.provesButton);
        provesOption.setOnClickListener(this);

        Button confirmButton = (Button) view.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);

        Button cancelButton = (Button) view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.whyOption:
            alertMessage.setText(WHY_MESSAGE);
            alertMessage.setVisibility(View.VISIBLE);
            break;
            case R.id.provesButton:
                alertMessage.setText(PROVES_MESSAGE);
                alertMessage.setVisibility(View.VISIBLE);
                break;
            case R.id.confirmButton:
                Toast.makeText(getContext(), "Sua solicitação foi enviada com sucesso!", Toast.LENGTH_LONG).show();
                getFragmentManager().popBackStack();
                getFragmentManager().popBackStack();
                break;
            case R.id.cancelButton:
                getFragmentManager().popBackStack();
                getFragmentManager().popBackStack();
                break;
            default:
        }


    }
}
