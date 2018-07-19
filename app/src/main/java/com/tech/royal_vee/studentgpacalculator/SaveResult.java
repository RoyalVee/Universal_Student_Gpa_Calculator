package com.tech.royal_vee.studentgpacalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tech.royal_vee.studentgpacalculator.model.UserResultModel;

import java.util.Map;

import java.util.HashMap;

public class SaveResult extends AppCompatActivity {
    TextView gpa, totalUnit, totalPoint, numofCourse;
    EditText resultYear, resultSemester, resultLevel;
    Button savebtn;

    // Creating FirebaseAuth object.
    FirebaseAuth firebaseAuth ;

   private  FirebaseUser currentFirebaseUser;
    String currentUserID;

    private  FirebaseFirestore firestoreDB;



    String resultYearHolder, resultLevelHolder, resultSemesterHolder, gppa, sua, tsp, acc;

    // Creating Boolean to hold EditText empty true false value.
    Boolean EditTextEmptyCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_result);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        currentUserID = currentFirebaseUser.getUid();

        gpa = (TextView) findViewById(R.id.gpa_point);
        totalUnit = (TextView) findViewById(R.id.semester_unit);
        totalPoint = (TextView) findViewById(R.id.semester_point);
        numofCourse = (TextView) findViewById(R.id.number_Courses);

        resultYear = (EditText) findViewById(R.id.resultYear);
        resultLevel = (EditText) findViewById(R.id.resultLevel);
        resultSemester = (EditText) findViewById(R.id.resultSemester);

        savebtn = (Button) findViewById(R.id.savebtn);

        firestoreDB = FirebaseFirestore.getInstance();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {


            gppa = bundle.getString("Gpa");
            sua = bundle.getString("TotalUnit");
            tsp = bundle.getString("TotalPoint");
            acc = bundle.getString("NumCourse");


            gpa.setText(bundle.getString("Gpa"));
            totalUnit.setText(bundle.getString("TotalUnit"));
            totalPoint.setText( bundle.getString("TotalPoint"));
            numofCourse.setText(bundle.getString("NumCourse"));
        }

        // Adding click listener to save Button.
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling method to check EditText is empty or no status.
                CheckEditTextIsEmptyOrNot();

                // If EditText is true then this block with execute.
                if(EditTextEmptyCheck){

                    try{
                        UserSaveFunction();

                        int page = 2;
                        Intent intent = new Intent(SaveResult.this, MainActivity.class);
                        intent.putExtra("One", page);
                        startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(SaveResult.this, "data base error", Toast.LENGTH_LONG).show();
                    }



                }
                // If EditText is false then this block with execute.
                else {

                    Toast.makeText(SaveResult.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    public void CheckEditTextIsEmptyOrNot(){


        resultYearHolder = resultYear.getText().toString().trim();


        resultLevelHolder = resultLevel.getText().toString().trim();

        resultSemesterHolder = resultSemester.getText().toString().trim();

        // Checking Both EditText is empty or not.
        if(TextUtils.isEmpty(resultLevelHolder) || TextUtils.isEmpty(resultSemesterHolder))
        {

            // If any of EditText is empty then set value as false.
            EditTextEmptyCheck = false;

        } else {

            // If any of EditText is empty then set value as true.
            EditTextEmptyCheck = true ;

        }

    }

    public void UserSaveFunction(){


        Map<String, Object> userResult = new UserResultModel(sua, tsp, acc, gppa, resultYearHolder, resultLevelHolder, resultSemesterHolder).toMap();

        firestoreDB.collection("users").document(currentUserID).collection("myResult")
                .add(userResult)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Result has been Saved to History", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Note could not be added!", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
