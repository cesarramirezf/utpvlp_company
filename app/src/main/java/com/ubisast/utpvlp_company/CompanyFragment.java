package com.ubisast.utpvlp_company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class CompanyFragment extends Fragment {

    ImageView IvSeguridadVial, IvAccidente, IvTalentoHumano, IvSemaforos, IvLeyes, IvRecaudo;

    SeguridadVialFragment fragment_seguridad_vial = new SeguridadVialFragment();
    AccidenteFragment fragment_accidente = new AccidenteFragment();
    TalentoHumanoFragment fragment_talento_humano = new TalentoHumanoFragment();
    SemaforosFragment fragment_semaforos =  new SemaforosFragment();
    LeyesFragment fragment_leyes = new LeyesFragment();
    RecaudoFragment fragment_recaudo = new RecaudoFragment();

    public CompanyFragment() {
        // Required empty public constructor
    }


    public static CompanyFragment newInstance() {
        CompanyFragment fragment = new CompanyFragment();
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

        View view = inflater.inflate(R.layout.fragment_company, container, false);

        IvSeguridadVial = view.findViewById(R.id.seguridad_vial_iv);
        IvAccidente = view.findViewById(R.id.accidente_iv);
        IvTalentoHumano = view.findViewById(R.id.talento_humano_iv);
        IvSemaforos = view.findViewById(R.id.semaforo_iv);
        IvLeyes = view.findViewById(R.id.justicia_iv);
        IvRecaudo = view.findViewById(R.id.recaudo_iv);

        IvSeguridadVial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment(fragment_seguridad_vial); }
        });

        IvAccidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment(fragment_accidente);}
        });

        IvTalentoHumano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment(fragment_talento_humano); }
        });

        IvSemaforos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment(fragment_semaforos); }
        });

        IvLeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment(fragment_leyes); }
        });

        IvRecaudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadFragment(fragment_recaudo); }
        });

        return view;
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_info, fragment).addToBackStack(null);
        transaction.commit();
    }
}