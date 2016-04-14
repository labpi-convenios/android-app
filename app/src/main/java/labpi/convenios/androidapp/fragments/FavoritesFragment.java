package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import labpi.convenios.adapter.CardListAdapter;
import labpi.convenios.androidapp.R;
import labpi.convenios.data.mock.FakeDatabase;
import labpi.convenios.model.Convenio;

public class FavoritesFragment extends Fragment {

    public FavoritesFragment() {
    }

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorites, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Convenio> data = FakeDatabase.dataFromFile(this.getContext(), "mock_favorites.csv");
        recyclerView.setAdapter(new CardListAdapter(this.getContext(), data));

        return rootView;
    }
}
