package labpi.convenios.androidapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import labpi.convenios.adapter.TabsAdapter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabsAdapter mTabsAdapter = new TabsAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) this.findViewById(R.id.container);
        viewPager.setAdapter(mTabsAdapter);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabs = (TabLayout) this.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        //Comentei essa linha abaixo porque ta visivel para ter como testar
        //menu.findItem(R.id.buttons_overflow).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.buttons_overflow){
            ProjectDescription projectDescription = new ProjectDescription();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, projectDescription);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
