package com.example.abdullah.livewallpapers.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdullah.livewallpapers.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialyPopularFragment extends Fragment {


    private static DialyPopularFragment INSTANCE = null;

    public DialyPopularFragment() {
        // Required empty public constructor
    }

    public static DialyPopularFragment getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DialyPopularFragment();
        return INSTANCE;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialy_popular, container, false);
    }

}
