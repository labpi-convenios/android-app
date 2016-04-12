package labpi.convenios.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import labpi.convenios.androidapp.fragments.AboutFragment;
import labpi.convenios.androidapp.fragments.FavoritesFragment;
import labpi.convenios.androidapp.fragments.FeedFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FeedFragment.newInstance();
            case 1:
                return FavoritesFragment.newInstance();
            case 2:
                return AboutFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Ao redor";
            case 1:
                return "Favoritos";
            case 2:
                return "Sobre";
        }
        return null;
    }
}
