package com.tech.royal_vee.studentgpacalculator.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.tech.royal_vee.studentgpacalculator.R;
import com.tech.royal_vee.studentgpacalculator.model.UserResultModel;

import java.util.List;

public class ViewResultHistoryAdapter extends RecyclerView.Adapter<ViewResultHistoryAdapter.ViewHolder> {

    private List<UserResultModel> notesList;
    private Context context;
    private FirebaseFirestore firestoreDB;

    public ViewResultHistoryAdapter(List<UserResultModel> notesList, Context context, FirebaseFirestore firestoreDB) {
        this.notesList = notesList;
        this.context = context;
        this.firestoreDB = firestoreDB;
    }

    @Override
    public ViewResultHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_history_note, parent, false);

        return new ViewResultHistoryAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewResultHistoryAdapter.ViewHolder holder, int position) {
        final int itemPosition = position;
        final UserResultModel note = notesList.get(itemPosition);

        holder.DGpa.setText(note.getDGpa());
        holder.ESemesterPoint.setText(note.getESemesterPoint());
        holder.ASemesterUnit.setText(note.getASemesterUnit());
        //holder.FTotalCourse.setText(note.getFTotalCourse());
        holder.BResultYear.setText(note.getBResultYear());
        holder.CResultLevel.setText(note.getCResultLevel());
        holder.GResultSemester.setText(note.getGResultSemester());


    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView DGpa, ESemesterPoint, ASemesterUnit, FTotalCourse, BResultYear, CResultLevel, GResultSemester;


        ViewHolder(View view) {
            super(view);
            DGpa = view.findViewById(R.id.gpa_point);
            ESemesterPoint = view.findViewById(R.id.semester_point);
            ASemesterUnit = view.findViewById(R.id.semester_unit);
           //FTotalCourse = view.findViewById(R.id.et_date);
            BResultYear = view.findViewById(R.id.year2);
            CResultLevel = view.findViewById(R.id.level2);

            GResultSemester = view.findViewById(R.id.semester2);



        }
    }

}
