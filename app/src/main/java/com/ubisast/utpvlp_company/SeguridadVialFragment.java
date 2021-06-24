package com.ubisast.utpvlp_company;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SeguridadVialFragment extends Fragment {

  private  Button btnVolverSv;

    public SeguridadVialFragment() {
        // Required empty public constructor
    }

    public static SeguridadVialFragment newInstance(String param1, String param2) {
        SeguridadVialFragment fragment = new SeguridadVialFragment();
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

        View view = inflater.inflate(R.layout.fragment_seguridad_vial, container, false);

        btnVolverSv = (Button) view.findViewById(R.id.volver_sv_btn);

        btnVolverSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
