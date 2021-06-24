package com.ubisast.utpvlp_company;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class MovilPointFragment extends Fragment {

    FirebaseFirestore db;
    Button btnRefresh;
    TextView todayDir1, todayDir2, nextDir1, nextDir2, todaySen1, todaySen2, nextSen1, nextSen2, titleNd, titleTd;
    String todayDir1_Text, todayDir2_Text, nextDir1_Text, nextDir2_Text, todaySen1_Text, todaySen2_Text,
            nextSen1_Text, nextSen2_Text, titleNd_Text, titleTd_Text;

    public MovilPointFragment() {
        // Required empty public constructor
    }

    public static FlatPointFragment newInstance() {
        FlatPointFragment fragment = new FlatPointFragment();
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

        View view = inflater.inflate(R.layout.fragment_movil_point, container, false);

        btnRefresh = view.findViewById(R.id.btn_refresh);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"Espera...", Toast.LENGTH_SHORT).show();
                loadData();
            }
        });

        titleTd = view.findViewById(R.id.title_td);
        todayDir1 = view.findViewById(R.id.today_dir_1);
        todaySen1 = view.findViewById(R.id.today_sen_1);
        todayDir2 = view.findViewById(R.id.today_dir_2);
        todaySen2 = view.findViewById(R.id.today_sen_2);

        titleNd = view.findViewById(R.id.title_nd);
        nextDir1 = view.findViewById(R.id.next_dir_1);
        nextSen1 = view.findViewById(R.id.next_sen_1);
        nextDir2 = view.findViewById(R.id.next_dir_2);
        nextSen2 = view.findViewById(R.id.next_sen_2);

        return view;
    }

    public void loadData(){

        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("ubi").document("xdias");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        Toast.makeText(getContext(),"Ubicación actualizada", Toast.LENGTH_SHORT).show();

                        todayDir1_Text = document.getString("ab_pos1");
                        todayDir1.setText(todayDir1_Text);
                        todaySen1_Text = document.getString("ac_sen1");
                        todaySen1.setText(todaySen1_Text);
                        todayDir2_Text = document.getString("ad_pos2");
                        todayDir2.setText(todayDir2_Text);
                        todaySen2_Text = document.getString("ae_sen2");
                        todaySen2.setText(todaySen2_Text);

                        titleTd_Text = document.getString("aa_today");
                        titleTd.setText(titleTd_Text);
                        titleNd_Text = document.getString("ba_next");
                        titleNd.setText(titleNd_Text);

                        nextDir1_Text = document.getString("bb_posN1");
                        nextDir1.setText(nextDir1_Text);
                        nextSen1_Text = document.getString("bc_senN1");
                        nextSen1.setText(nextSen1_Text);
                        nextDir2_Text = document.getString("bd_posN2");
                        nextDir2.setText(nextDir2_Text);
                        nextSen2_Text = document.getString("be_senN2");
                        nextSen2.setText(nextSen2_Text);

                    } else {
                        Log.d(TAG, "No hay ubicación");
                    }
                } else {
                    Log.d(TAG, "No se actualizó", task.getException());
                }
            }
        });

    }
}