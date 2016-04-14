package labpi.convenios.androidapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import labpi.convenios.androidapp.R;

public class IntroFragment extends Fragment {

    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String PAGE_NUMBER = "page";

    private int pageNumber;

    public static IntroFragment newInstance(int page) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageNumber = getArguments().getInt(PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutResId;
        switch (pageNumber) {
            case 0:
                layoutResId = R.layout.intro_background;
                break;
            default:
                layoutResId = R.layout.intro_second_background;
        }

        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);
        view.setTag(pageNumber);
        return view;
    }
}