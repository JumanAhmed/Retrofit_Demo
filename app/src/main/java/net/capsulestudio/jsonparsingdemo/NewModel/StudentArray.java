package net.capsulestudio.jsonparsingdemo.NewModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentArray {


    @SerializedName("students")
    private List<Students> students;

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
