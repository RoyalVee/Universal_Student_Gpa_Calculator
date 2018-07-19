package com.tech.royal_vee.studentgpacalculator.model;


import java.util.HashMap;
import java.util.Map;

public class UserResultModel {


    private String ASemesterUnit;
    private String BResultYear;
    private String CResultLevel;
    private String DGpa;
    private String ESemesterPoint;
    private String FTotalCourse;
    private String GResultSemester;

    public String getASemesterUnit() {
        return ASemesterUnit;
    }

    public void setASemesterUnit(String ASemesterUnit) {
        this.ASemesterUnit = ASemesterUnit;
    }

    public String getBResultYear() {
        return BResultYear;
    }

    public void setBResultYear(String BResultYear) {
        this.BResultYear = BResultYear;
    }

    public String getCResultLevel() {
        return CResultLevel;
    }

    public void setCResultLevel(String CResultLevel) {
        this.CResultLevel = CResultLevel;
    }

    public String getDGpa() {
        return DGpa;
    }

    public void setDGpa(String DGpa) {
        this.DGpa = DGpa;
    }

    public String getESemesterPoint() {
        return ESemesterPoint;
    }

    public void setESemesterPoint(String ESemesterPoint) {
        this.ESemesterPoint = ESemesterPoint;
    }

    public String getFTotalCourse() {
        return FTotalCourse;
    }

    public void setFTotalCourse(String FTotalCourse) {
        this.FTotalCourse = FTotalCourse;
    }

    public String getGResultSemester() {
        return GResultSemester;
    }

    public void setGResultSemester(String GResultSemester) {
        this.GResultSemester = GResultSemester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserResultModel(){

    }

    public UserResultModel( String ASemesterUnit, String ESemesterPoint, String FTotalCourse, String DGpa, String BResultYear, String CResultLevel, String GResultSemester) {
        this.ASemesterUnit = ASemesterUnit;
        this.ESemesterPoint = ESemesterPoint;
        this.FTotalCourse = FTotalCourse;
        this.DGpa = DGpa;
        this.BResultYear = BResultYear;
        this.CResultLevel = CResultLevel;
        this.GResultSemester = GResultSemester;

    }



    private String id;




    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("ASemesterUnit", this.ASemesterUnit );
        result.put("ESemesterPoint", this.ESemesterPoint);
        result.put("FTotalCourse", this.FTotalCourse);
        result.put("DGpa", this.DGpa);
        result.put("BResultYear",this.BResultYear);
        result.put("CResultLevel", this.CResultLevel);
        result.put("GResultSemester", this.GResultSemester);

        return result;
    }

    public Map<String, Object> toResultMode() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("SemesterUnit", this.ASemesterUnit );
        result.put("SemesterPoint", this.ESemesterPoint);
        result.put("TotalCourse", this.FTotalCourse);
        result.put("Gpa", this.DGpa);
        result.put("ResultYear",this.BResultYear);
        result.put("ResultLevel", this.CResultLevel);
        result.put("ResultSemester", this.GResultSemester);


        return result;
    }
}