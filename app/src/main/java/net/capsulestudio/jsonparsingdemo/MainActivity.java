package net.capsulestudio.jsonparsingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.capsulestudio.jsonparsingdemo.Api.ApiClient;
import net.capsulestudio.jsonparsingdemo.Api.ApiInterface;
import net.capsulestudio.jsonparsingdemo.Model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etUniversity = findViewById(R.id.et_university);

    }

    public void sendStudentToServer(View view) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String university = etUniversity.getText().toString();

         ApiInterface api = ApiClient.getApiInterface();
         Call<Result>  resultCall = api.addNewStudentInformation(name, email, phone, university);
         
         resultCall.enqueue(new Callback<Result>() {
             @Override
             public void onResponse(Call<Result> call, Response<Result> response) {
                 if (response.isSuccessful()){
                    String message = response.body().getMessage();

                     Toast.makeText(MainActivity.this, "Message :: "+message, Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<Result> call, Throwable t) {

                 Toast.makeText(MainActivity.this, "Request Failed !", Toast.LENGTH_SHORT).show();

             }
         });





    }

    public void checkStudentList(View view) {
        startActivity(new Intent(getApplicationContext(), StudentActivity.class));

    }
}
