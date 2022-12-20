package com.Soni5.gauanwale.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Soni5.gauanwale.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class ProfileFragment extends Fragment
{


    public ProfileFragment() {
        // Required empty public constructor
    }

    FirebaseAuth auth;
    String authid = auth.getUid();
    FirebaseFirestore firebaseFirestore;
    TextView id , place;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);


        id = view.findViewById(R.id.nameid);
        place  = view.findViewById(R.id.placeid);

        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        DocumentReference reference;
        reference = firebaseFirestore.collection("Profile").document(authid);


        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if(task.isSuccessful())
                {
                    String ids = task.getResult().getString("Name");
                    String places = task.getResult().getString("Where");

                    id.setText(ids);
                    place.setText(places);


                }
            }
        });

    return  view;

    }
}