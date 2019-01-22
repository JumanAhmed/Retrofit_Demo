package net.capsulestudio.jsonparsingdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import net.capsulestudio.jsonparsingdemo.Adapter.StudentAdapter;
import net.capsulestudio.jsonparsingdemo.Api.ApiClient;
import net.capsulestudio.jsonparsingdemo.Api.ApiInterface;
import net.capsulestudio.jsonparsingdemo.Model.Student;
import net.capsulestudio.jsonparsingdemo.Model.StudentList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentActivity extends AppCompatActivity {

    private ListView listView;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> studentData;


    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

         studentData = new ArrayList<>();
         progressDialog = new ProgressDialog(this);
         progressDialog.setMessage("Loading......");


         listView = findViewById(R.id.list_view);

        studentAdapter = new StudentAdapter(this, R.layout.student_raw, studentData);
        listView.setAdapter(studentAdapter);

        retriveStudentData();

    }

    private void retriveStudentData() {
        progressDialog.show();

        ApiInterface api = ApiClient.getApiInterface();
         Call<StudentList> studentCall = api.getAllStudentInfo();

         studentCall.enqueue(new Callback<StudentList>() {
             @Override
             public void onResponse(Call<StudentList> call, Response<StudentList> response) {

                 if (response.isSuccessful()){
                     progressDialog.dismiss();

                   ArrayList<Student> studentsList =  response.body().getStudentArrayList();

                   studentData.clear();
                   studentData.addAll(studentsList);
                   studentAdapter.notifyDataSetChanged();


                 }else {
                     progressDialog.dismiss();
                     Toast.makeText(StudentActivity.this, "Something Wrong !", Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<StudentList> call, Throwable t) {
                 progressDialog.dismiss();
                 Toast.makeText(StudentActivity.this, "Request Failed !", Toast.LENGTH_SHORT).show();
             }
         });

    }

}
