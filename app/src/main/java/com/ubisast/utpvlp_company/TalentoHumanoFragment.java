package com.ubisast.utpvlp_company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TalentoHumanoFragment extends Fragment {

    private Button btnVolverTh;

    public TalentoHumanoFragment() {
        // Required empty public constructor
    }

    public static TalentoHumanoFragment newInstance() {
        TalentoHumanoFragment fragment = new TalentoHumanoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_talento_humano, container, false);

        btnVolverTh =(Button) view.findViewById(R.id.volver_th_btn);

        btnVolverTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}