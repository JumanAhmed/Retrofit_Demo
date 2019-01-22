package net.capsulestudio.jsonparsingdemo.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StudentList {

    @SerializedName("students")
    private ArrayList<Student> studentArrayList;

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
}
