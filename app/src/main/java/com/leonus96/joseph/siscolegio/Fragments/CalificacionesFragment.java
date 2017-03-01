package com.leonus96.joseph.siscolegio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leonus96.joseph.siscolegio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalificacionesFragment extends Fragment {


    public CalificacionesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calificaciones, container, false);
        return view;
    }

}
