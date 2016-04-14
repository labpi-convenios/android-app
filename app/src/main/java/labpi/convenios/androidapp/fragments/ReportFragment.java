package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import labpi.convenios.androidapp.R;

/**
 * Created by izabela on 12/04/16.
 */
public class ReportFragment extends Fragment implements View.OnClickListener{

    public ReportFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        Button dontKnowButton = (Button) view.findViewById(R.id.dont_know);
        dontKnowButton.setOnClickListener(this);

        Button completedButton = (Button) view.findViewById(R.id.completed);
        completedButton.setOnClickListener(this);

        Button sendCommentButton = (Button) view.findViewById(R.id.sendComment);
        sendCommentButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.dont_know || v.getId() == R.id.completed || v.getId() == R.id.sendComment){

            Toast.makeText(getContext(), "Parabéns por contribuir com a fiscalização contra a corrupção", Toast.LENGTH_SHORT).show();
        }

    }
}
