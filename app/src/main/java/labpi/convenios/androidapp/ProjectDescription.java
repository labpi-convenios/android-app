package labpi.convenios.androidapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import labpi.convenios.androidapp.R;

public class ProjectDescription extends Fragment {

    public ProjectDescription() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project_description, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        menu.findItem(R.id.buttons_overflow).setVisible(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment buttonsFragment = new ButtonsFragment();
        if(item.getItemId() == R.id.buttons_overflow){
            getFragmentManager().beginTransaction().replace(R.id.fragment_project_description, buttonsFragment).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
