package com.tech.royal_vee.studentgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculationResult extends AppCompatActivity {

    TextView gpa, totalUnit, totalPoint, numofCourse;
    Button yesbtn, nobtn;

    String gppa;
    String sua ;
    String tsp ;
    String acc ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_result);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gpa = (TextView) findViewById(R.id.gpa_point);
        totalUnit = (TextView) findViewById(R.id.semester_unit);
        totalPoint = (TextView) findViewById(R.id.semester_point);
        numofCourse = (TextView) findViewById(R.id.number_Courses);
        yesbtn = (Button) findViewById(R.id.btn_yes);
        nobtn = (Button) findViewById(R.id.no_btn);

        //on calculate button click operation
        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte = new Intent(CalculationResult.this, Login.class);
               inte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                inte.putExtra("Gpa", gppa);
                inte.putExtra("TotalUnit", sua);
                inte.putExtra("TotalPoint", tsp);
                inte.putExtra("NumCourse", acc);
                startActivity(inte);

            }
        });

        nobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte = new Intent(CalculationResult.this, MainActivity.class);
                startActivity(inte);

            }
        });



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
    }
}
