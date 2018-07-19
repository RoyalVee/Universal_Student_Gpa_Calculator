package com.tech.royal_vee.studentgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends Fragment {

    //button for gpa calculation
    Button calculate;

    //button for add course to list to be calculated
    Button addCourse;

    //edittext for school maximum point
    EditText schMaxPoint;

    //edittext for course code
    EditText courseCode;

    //edittext for course Unit
    EditText courseUnit;

    //edittext for grade obtained in the course
    EditText gradeObtain;

    //textview display for course code entered
    TextView cc1, cc2, cc3, cc4, cc5, cc6, cc7, cc8, cc9, cc10, cc11, cc12, cc13, cc14, cc15, cc16, cc17, cc18, cc19, cc20;

    //textview display for course unit entered
    TextView u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17, u18, u19, u20;

    //textview display for grade entered
    TextView g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20;


    //addCourseCount is for checking how many times the add button has been click
    int addCourseCount = 1;

    //for keeping input for course code
    String cCodeHolder;

    //for keeping input for course unit
    String cunitHolder;
    int cUnit; //unit in integer holder

    //for keeping input for grade obtained
    String cGradeHolder;

    //for keeping input for maximum school grade point
    String  maxPointHolder;
    int maxPointNum; //school maximum point integer holder

    //used for keeping and adding course unit for all courses
    double semsesterUnitadder = 0;

    boolean checker;

    int che = 0;

    //used for keep the multiplication of course unit and grade; also adding to previous calculation
    double unitMgrade = 0.0;

    double gpa = 0.0;

    double totalSemesterPoint = 0.0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.calculator, container, false);

        //Views and widgets initialization
        schMaxPoint = (EditText) rootView.findViewById(R.id.enterMGP);
        courseCode = (EditText) rootView.findViewById(R.id.course_code);
        courseUnit = (EditText) rootView.findViewById(R.id.course_unit);
        gradeObtain = (EditText) rootView.findViewById(R.id.grade_obtain);
        addCourse = (Button) rootView.findViewById(R.id.addbtn);
        calculate = (Button) rootView.findViewById(R.id.calculatebtn);




        cc1 = (TextView) rootView.findViewById(R.id.cc1);
        cc2 = (TextView) rootView.findViewById(R.id.cc2);
        cc3 = (TextView) rootView.findViewById(R.id.cc3);
        cc4 = (TextView) rootView.findViewById(R.id.cc4);
        cc5 = (TextView) rootView.findViewById(R.id.cc5);
        cc6 = (TextView) rootView.findViewById(R.id.cc6);
        cc7 = (TextView) rootView.findViewById(R.id.cc7);
        cc8 = (TextView) rootView.findViewById(R.id.cc8);
        cc9 = (TextView) rootView.findViewById(R.id.cc9);
        cc10 = (TextView) rootView.findViewById(R.id.cc10);
        cc11 = (TextView) rootView.findViewById(R.id.cc11);
        cc12 = (TextView) rootView.findViewById(R.id.cc12);
        cc13 = (TextView) rootView.findViewById(R.id.cc13);
        cc14 = (TextView) rootView.findViewById(R.id.cc14);
        cc15 = (TextView) rootView.findViewById(R.id.cc15);
        cc16 = (TextView) rootView.findViewById(R.id.cc16);
        cc17 = (TextView) rootView.findViewById(R.id.cc17);
        cc18 = (TextView) rootView.findViewById(R.id.cc18);
        cc19 = (TextView) rootView.findViewById(R.id.cc19);
        cc20 = (TextView) rootView.findViewById(R.id.cc20);


        u1 = (TextView) rootView.findViewById(R.id.u1);
        u2 = (TextView) rootView.findViewById(R.id.u2);
        u3 = (TextView) rootView.findViewById(R.id.u3);
        u4 = (TextView) rootView.findViewById(R.id.u4);
        u5 = (TextView) rootView.findViewById(R.id.u5);
        u6 = (TextView) rootView.findViewById(R.id.u6);
        u7 = (TextView) rootView.findViewById(R.id.u7);
        u8 = (TextView) rootView.findViewById(R.id.u8);
        u9 = (TextView) rootView.findViewById(R.id.u9);
        u10 = (TextView) rootView.findViewById(R.id.u10);
        u11 = (TextView) rootView.findViewById(R.id.u11);
        u12 = (TextView) rootView.findViewById(R.id.u12);
        u13 = (TextView) rootView.findViewById(R.id.u13);
        u14 = (TextView) rootView.findViewById(R.id.u14);
        u15 = (TextView) rootView.findViewById(R.id.u15);
        u16 = (TextView) rootView.findViewById(R.id.u16);
        u17 = (TextView) rootView.findViewById(R.id.u17);
        u18 = (TextView) rootView.findViewById(R.id.u18);
        u19 = (TextView) rootView.findViewById(R.id.u19);
        u20 = (TextView) rootView.findViewById(R.id.u20);


        g1 = (TextView) rootView.findViewById(R.id.g1);
        g2 = (TextView) rootView.findViewById(R.id.g2);
        g3 = (TextView) rootView.findViewById(R.id.g3);
        g4 = (TextView) rootView.findViewById(R.id.g4);
        g5 = (TextView) rootView.findViewById(R.id.g5);
        g6 = (TextView) rootView.findViewById(R.id.g6);
        g7 = (TextView) rootView.findViewById(R.id.g7);
        g8 = (TextView) rootView.findViewById(R.id.g8);
        g9 = (TextView) rootView.findViewById(R.id.g9);
        g10 = (TextView) rootView.findViewById(R.id.g10);
        g11 = (TextView) rootView.findViewById(R.id.g11);
        g12 = (TextView) rootView.findViewById(R.id.g12);
        g13 = (TextView) rootView.findViewById(R.id.g13);
        g14 = (TextView) rootView.findViewById(R.id.g14);
        g15 = (TextView) rootView.findViewById(R.id.g15);
        g16 = (TextView) rootView.findViewById(R.id.g16);
        g17 = (TextView) rootView.findViewById(R.id.g17);
        g18 = (TextView) rootView.findViewById(R.id.g18);
        g19 = (TextView) rootView.findViewById(R.id.g19);
        g20 = (TextView) rootView.findViewById(R.id.g20);


        //on add button click operation
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkEditTextEntry();

                    if(che == 1) {

                        try{
                        display();
                        }catch (Exception e){
                            Toast.makeText(Calculator.this.getActivity(), "Please enter all required information", Toast.LENGTH_LONG).show();
                        }

                }else {
                    Toast.makeText(Calculator.this.getActivity(), "Please enter all required information", Toast.LENGTH_LONG).show();
                }

            }
        });


        //on calculate button click operation
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gpaCalulationMain();

                String gppa = Double.toString(gpa);
                String sua = Double.toString(semsesterUnitadder);
                String tsp = Double.toString(totalSemesterPoint);
                String acc = Double.toString(addCourseCount - 1.0);

                Intent inte = new Intent(Calculator.this.getActivity(), CalculationResult.class);

                    inte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    inte.putExtra("Gpa", gppa);
                    inte.putExtra("TotalUnit", sua);
                    inte.putExtra("TotalPoint", tsp);
                    inte.putExtra("NumCourse", acc);
                Calculator.this.getActivity().startActivity(inte);

            }
        });

        return rootView;
    }




    public void checkEditTextEntry(){
        maxPointHolder = schMaxPoint.getText().toString().trim();
        cCodeHolder = courseCode.getText().toString().trim();
        cunitHolder = courseUnit.getText().toString().trim();
        cGradeHolder = gradeObtain.getText().toString().trim();

        if(!TextUtils.isEmpty(maxPointHolder) || !TextUtils.isEmpty(cCodeHolder) /*|| TextUtils.isEmpty(cunitHolder)|| TextUtils.isEmpty(cGradeHolder)*/)
        {
            checker = true;
            che = 1;
        }else {
            checker = false;
        }
    }


    public void setInputToText(TextView code, TextView unit, TextView grade){


        String ccCode = courseCode.getText().toString().trim();
       String ccunitstring = courseUnit.getText().toString().trim();
        String ccGrade = gradeObtain.getText().toString().trim();


        code.setText(ccCode);
        unit.setText(ccunitstring);
        grade.setText(ccGrade);
    }

    public void clearCourseDetailsInput(){
        courseCode.getText().clear();
        courseUnit.getText().clear();
        gradeObtain.getText().clear();
    }

    //this method multiple the course unit and grade and add it to the already saved value for 3.0 gpa scale
    public void unitGradeMultipler_3(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 3.0;
                break;
            case "A":
                g = 3.0;
                break;
            case "A-":
                g = 2.75;
            case "B+":
                g = 2.5;
                break;
            case "B":
                g = 2.25;
                break;
            case "B-":
                g = 2.0;
                break;
            case "C+":
                g = 1.75;
                break;
            case "C":
                g = 1.50;
                break;
            case "C-":
                g = 1.25;
                break;
            case "D+":
                g = 1.00;
                break;
            case "D":
                g = 0.75;
                break;
            case "D-":
                g = 0.5;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
                default:
                    Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }

        totalSemesterPoint = totalSemesterPoint + g;

        unitMgrade = unitMgrade + ( g *unitGet);

    }


    //this method multiple the course unit and grade and add it to the already saved value for 4.0 gpa scale
    public void unitGradeMultipler_4(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 4.0;
                break;
            case "A":
                g = 4.0;
                break;
            case "A-":
                g = 3.67;
            case "B+":
                g = 3.33;
                break;
            case "B":
                g = 3.0;
                break;
            case "B-":
                g = 2.67;
                break;
            case "C+":
                g = 2.33;
                break;
            case "C":
                g = 2.0;
                break;
            case "C-":
                g = 1.67;
                break;
            case "D+":
                g = 1.33;
                break;
            case "D":
                g = 1.00;
                break;
            case "D-":
                g = 0.67;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }

        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g * unitGet);

    }

    //this method multiple the course unit and grade and add it to the already saved value for 5.0 gpa scale
    public void unitGradeMultipler_5(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 5.0;
                break;
            case "A":
                g = 5.0;
                break;
            case "A-":
                g = 4.59;
            case "B+":
                g = 4.16;
                break;
            case "B":
                g =4.0;
                break;
            case "B-":
                g = 3.75;
                break;
            case "C+":
                g = 3.50;
                break;
            case "C":
                g = 3.0;
                break;
            case "C-":
                g = 2.75;
                break;
            case "D+":
                g = 2.50;
                break;
            case "D":
                g = 2.0;
                break;
            case "D-":
                g = 1.84;
                break;
            case "E":
                g = 1.0;
                break;
            case "F":
                g = 0.0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }

        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g *unitGet);

    }

    //this method multiple the course unit and grade and add it to the already saved value for 6.0 gpa scale
    public void unitGradeMultipler_6(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 6.0;
                break;
            case "A":
                g = 6.0;
                break;
            case "A-":
                g = 5.51;
            case "B+":
                g = 5.0;
                break;
            case "B":
                g = 4.50;
                break;
            case "B-":
                g = 4.01;
                break;
            case "C+":
                g = 3.50;
                break;
            case "C":
                g = 3.0;
                break;
            case "C-":
                g = 2.51;
                break;
            case "D+":
                g = 2.0;
                break;
            case "D":
                g = 1.50;
                break;
            case "D-":
                g = 1.01;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }
        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g *unitGet);

    }

    //this method multiple the course unit and grade and add it to the already saved value for 7.0 gpa scale
    public void unitGradeMultipler_7(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 7.0;
                break;
            case "A":
                g = 7.0;
                break;
            case "A-":
                g = 6.42;
            case "B+":
                g = 5.83;
                break;
            case "B":
                g = 5.25;
                break;
            case "B-":
                g = 4.67;
                break;
            case "C+":
                g = 4.08;
                break;
            case "C":
                g = 3.50;
                break;
            case "C-":
                g = 2.92;
                break;
            case "D+":
                g = 2.33;
                break;
            case "D":
                g = 1.75;
                break;
            case "D-":
                g = 1.17;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }
        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g *unitGet);

    }

    //this method multiple the course unit and grade and add it to the already saved value for 8.0 gpa scale
    public void unitGradeMultipler_8(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 8.0;
                break;
            case "A":
                g = 8.0;
                break;
            case "A-":
                g = 7.34;
            case "B+":
                g = 6.66;
                break;
            case "B":
                g = 6.00;
                break;
            case "B-":
                g = 5.34;
                break;
            case "C+":
                g = 4.66;
                break;
            case "C":
                g = 4.00;
                break;
            case "C-":
                g = 3.34;
                break;
            case "D+":
                g = 2.66;
                break;
            case "D":
                g = 2.0;
                break;
            case "D-":
                g = 1.34;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }
        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g *unitGet);

    }

    //this method multiple the course unit and grade and add it to the already saved value for 9.0 gpa scale
    public void unitGradeMultipler_9(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 9.0;
                break;
            case "A":
                g = 9.0;
                break;
            case "A-":
                g = 8.26;
            case "B+":
                g = 7.49;
                break;
            case "B":
                g = 6.75;
                break;
            case "B-":
                g = 6.01;
                break;
            case "C+":
                g = 5.24;
                break;
            case "C":
                g = 4.50;
                break;
            case "C-":
                g = 3.76;
                break;
            case "D+":
                g = 2.99;
                break;
            case "D":
                g = 2.25;
                break;
            case "D-":
                g =1.51;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }
        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g *unitGet);

    }

    //this method multiple the course unit and grade and add it to the already saved value for 10.0 gpa scale
    public void unitGradeMultipler_10(){


        double g = 0.0;
        double unitGet = Double.parseDouble(courseUnit.getText().toString().trim());
        String gradeGet = gradeObtain.getText().toString().trim();

        switch (gradeGet){
            case "A+":
                g = 10.0;
                break;
            case "A":
                g = 10.0;
                break;
            case "A-":
                g = 9.18;
            case "B+":
                g = 8.33;
                break;
            case "B":
                g = 7.50;
                break;
            case "B-":
                g = 6.68;
                break;
            case "C+":
                g = 5.83;
                break;
            case "C":
                g = 5.00;
                break;
            case "C-":
                g = 4.18;
                break;
            case "D+":
                g = 3.33;
                break;
            case "D":
                g = 2.50;
                break;
            case "D-":
                g = 1.68;
                break;
            case "E":
                g = 0;
                break;
            case "F":
                g = 0;
                break;
            default:
                Toast.makeText(Calculator.this.getActivity(), "Incorrect grade format entered", Toast.LENGTH_LONG).show();
        }
        totalSemesterPoint = totalSemesterPoint + g;
        unitMgrade = unitMgrade + ( g *unitGet);

    }


    public void calculateMeth(){
        maxPointNum = Integer.parseInt(schMaxPoint.getText().toString().trim());

        switch (maxPointNum){
            case 3:
                unitGradeMultipler_3();
                break;
            case 4:
                unitGradeMultipler_4();
                break;
            case 5:
                unitGradeMultipler_5();
                break;
            case 6:
                unitGradeMultipler_6();
                break;
            case 7:
                unitGradeMultipler_7();
                break;
            case 8:
                unitGradeMultipler_8();
                break;
            case 9:
                unitGradeMultipler_9();
                break;
            case 10:
                unitGradeMultipler_10();
                break;
                default:
                    Toast.makeText(Calculator.this.getActivity(), "Out of Bound Input for school maximum grade point", Toast.LENGTH_LONG).show();

        }

    }

    public void gpaCalulationMain(){
         gpa = unitMgrade / semsesterUnitadder ;

        String gpaString = Double.toString(gpa);
        Toast.makeText(Calculator.this.getActivity(), gpaString, Toast.LENGTH_LONG ).show();
    }

    public  void  display(){
        if (addCourseCount == 1) {
            setInputToText(cc1, u1, g1);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 2) {
            setInputToText(cc2, u2, g2);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 3) {
            setInputToText(cc3, u3, g3);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 4) {
            setInputToText(cc4, u4, g4);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 5) {
            setInputToText(cc5, u5, g5);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 6) {
            setInputToText(cc6, u6, g6);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 7) {
            setInputToText(cc7, u7, g7);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 8) {
            setInputToText(cc8, u8, g8);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 9) {
            setInputToText(cc9, u9, g9);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 10) {
            setInputToText(cc10, u10, g10);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 11) {
            setInputToText(cc11, u11, g11);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 12) {
            setInputToText(cc12, u12, g12);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 13) {
            setInputToText(cc13, u13, g13);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 14) {
            setInputToText(cc14, u14, g14);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 15) {
            setInputToText(cc15, u15, g15);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 16) {
            setInputToText(cc16, u16, g16);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 17) {
            setInputToText(cc17, u17, g17);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 18) {
            setInputToText(cc18, u18, g18);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 19) {
            setInputToText(cc19, u19, g19);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        } else if (addCourseCount == 20) {
            setInputToText(cc20, u20, g20);
            addCourseCount = addCourseCount + 1;
            cUnit = Integer.parseInt(courseUnit.getText().toString().trim());
            semsesterUnitadder = semsesterUnitadder + cUnit;
            calculateMeth();
            clearCourseDetailsInput();
        }

    }

}
