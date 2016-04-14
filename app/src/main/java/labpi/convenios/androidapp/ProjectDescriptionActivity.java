package labpi.convenios.androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import labpi.convenios.androidapp.fragments.ButtonsFragment;
import labpi.convenios.model.Convenio;

public class ProjectDescriptionActivity extends AppCompatActivity{

    public static String DATA = "labpi.convenios.DATA";
    private Convenio project;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_description_activity);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar_project_description);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle args = getIntent().getExtras();
        this.project = (Convenio) args.getSerializable(DATA);
        setViewData();
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

    private void setViewData() {
        TextView yearProject = (TextView) this.findViewById(R.id.yearTextView);
        TextView nameProject = (TextView) this.findViewById(R.id.nameProjectTextView);
        TextView proposerProject = (TextView) this.findViewById(R.id.proposerTextView);
        TextView valueProject = (TextView) this.findViewById(R.id.valueTextView);
        TextView descriptionProject = (TextView) this.findViewById(R.id.descriptionTextView);

        yearProject.setText(this.project.getAno());
        nameProject.setText(this.project.getObjetivo());
        proposerProject.setText(this.project.getProponente());
        valueProject.setText(this.project.getValorGlobal());
        descriptionProject.setText(this.project.getMunicipio() + ": " +
                this.project.getOrgao() + ", " +
                this.project.getPrograma() + " - " +
                this.project.getJustificativa());

    }
}
