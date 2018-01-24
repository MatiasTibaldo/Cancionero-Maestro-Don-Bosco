package com.example.matiastibaldo.cancioneromaestrodonbosco.CInterfaces;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matiastibaldo.cancioneromaestrodonbosco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcercaDe extends Fragment {


    public AcercaDe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);
    }

}
