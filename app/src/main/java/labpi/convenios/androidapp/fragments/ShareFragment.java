package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import labpi.convenios.androidapp.R;

/**
 * Created by izabela on 13/04/16.
 */
public class ShareFragment extends Fragment implements View.OnClickListener{

    public ShareFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_share, container, false);

        Button cancelButton = (Button) view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.cancel_button){
           getFragmentManager().popBackStack();
        }
    }
}
