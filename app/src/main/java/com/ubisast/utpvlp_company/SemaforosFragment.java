package com.ubisast.utpvlp_company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SemaforosFragment extends Fragment {

    private Button btnVolverSm;

    public SemaforosFragment() {
        // Required empty public constructor
    }

    public static SemaforosFragment newInstance() {
        SemaforosFragment fragment = new SemaforosFragment();
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

        View view = inflater.inflate(R.layout.fragment_semaforos, container, false);

        btnVolverSm =(Button) view.findViewById(R.id.volver_sm_btn);

        btnVolverSm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}