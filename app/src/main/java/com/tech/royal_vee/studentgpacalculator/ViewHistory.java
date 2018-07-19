package com.tech.royal_vee.studentgpacalculator;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;
import com.tech.royal_vee.studentgpacalculator.Adapter.ViewResultHistoryAdapter;
import com.tech.royal_vee.studentgpacalculator.model.UserResultModel;

import java.util.ArrayList;
import java.util.List;

public class ViewHistory extends Fragment{

    private static final String TAG = "JournalEntryActivity";

    private RecyclerView recyclerView;
    private ViewResultHistoryAdapter mAdapter;

    private FirebaseFirestore firestoreDB;
    private ListenerRegistration firestoreListener;

    private FirebaseUser currentFirebaseUser;
    String currentUserID;

    // Creating FirebaseAuth object.
    FirebaseAuth firebaseAuth ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView  = inflater.inflate(R.layout.view_history, container, false);

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        try{
        currentUserID = currentFirebaseUser.getUid();
        }catch (Exception e){

        }

        recyclerView = rootView.findViewById(R.id.view_history);
        firestoreDB = FirebaseFirestore.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        loadNotesList();

        firestoreListener = firestoreDB.collection("users").document(currentUserID).collection("myResult")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.e(TAG, "Listen failed!", e);
                            return;
                        }

                        List<UserResultModel> notesList = new ArrayList<>();

                        for (DocumentSnapshot doc : documentSnapshots) {
                            UserResultModel note = doc.toObject(UserResultModel.class);
                            //note.setId(doc.getId());
                            notesList.add(note);
                        }

                        mAdapter = new ViewResultHistoryAdapter(notesList, getContext().getApplicationContext(), firestoreDB);
                        recyclerView.setAdapter(mAdapter);
                    }
                });
        return rootView;
    }

    private void loadNotesList() {
        firestoreDB.collection("users").document(currentUserID).collection("myResult")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<UserResultModel> notesList = new ArrayList<>();

                            for (DocumentSnapshot doc : task.getResult()) {
                                UserResultModel note = doc.toObject(UserResultModel.class);
                                //note.setId(doc.getId());
                                notesList.add(note);
                            }

                            mAdapter = new ViewResultHistoryAdapter(notesList, getContext().getApplicationContext(), firestoreDB);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
                            recyclerView.setLayoutManager(mLayoutManager);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                            recyclerView.setAdapter(mAdapter);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
