package com.ubisast.utpvlp_company;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    int c = 0;
    private ImageView ivLogoToolbar;

    CompanyFragment fragment_company = new CompanyFragment();
    FlatPointFragment fragment_flat_point = new FlatPointFragment();
    MovilPointFragment fragment_movil_point = new MovilPointFragment();
    ContactUsFragment fragment_contact_us = new ContactUsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navi);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ivLogoToolbar = findViewById(R.id.iv_logo_toolbar);

        ivLogoToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                if (c == 8){
                    Toast.makeText(getApplicationContext(),"Desarrollado por Ing. César Ramírez Filomena", Toast.LENGTH_LONG).show();
                    c = 0;
                }
            }
        });

        loadFragment(fragment_company);

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.fragment_company:
                    loadFragment(fragment_company);
                    return true;
                case R.id.fragment_flat_point:
                    loadFragment(fragment_flat_point);
                    return true;
                case R.id.fragment_movil_point:
                    loadFragment(fragment_movil_point);
                    return true;
                case R.id.fragment_contact_us:
                    loadFragment(fragment_contact_us);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_info, fragment);
        transaction.commit();
    }
}