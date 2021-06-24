package com.ubisast.utpvlp_company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LeyesFragment extends Fragment {

    private Button btnVolverLy;


    public LeyesFragment() {
        // Required empty public constructor
    }

    public static LeyesFragment newInstance() {
        LeyesFragment fragment = new LeyesFragment();
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

        View view = inflater.inflate(R.layout.fragment_leyes, container, false);

        btnVolverLy =(Button) view.findViewById(R.id.volver_ly_btn);

        btnVolverLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}