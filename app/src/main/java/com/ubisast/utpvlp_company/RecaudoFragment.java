package com.ubisast.utpvlp_company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RecaudoFragment extends Fragment {

    private Button btnVolverRc;

    public RecaudoFragment() {
        // Required empty public constructor
    }

    public static RecaudoFragment newInstance(String param1, String param2) {
        RecaudoFragment fragment = new RecaudoFragment();
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
        View view = inflater.inflate(R.layout.fragment_recaudo, container, false);

        btnVolverRc = view.findViewById(R.id.volver_rc_btn);

        btnVolverRc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}