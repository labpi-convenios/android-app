package labpi.convenios.androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import labpi.convenios.androidapp.fragments.ButtonsFragment;

public class ProjectDescriptionActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_description_activity);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar_project_description);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_project_description, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.buttons_overflow){
            ButtonsFragment buttonsFragment = new ButtonsFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.layout_project_description, buttonsFragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
