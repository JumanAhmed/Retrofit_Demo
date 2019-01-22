package net.capsulestudio.jsonparsingdemo.Api;

import net.capsulestudio.jsonparsingdemo.Model.Result;
import net.capsulestudio.jsonparsingdemo.Model.StudentList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("add_student_info.php")
    Call<Result> addNewStudentInformation(
            @Field("name") String Name,
            @Field("email") String Email,
            @Field("phone") String Phone,
            @Field("university") String University);


    @GET("get_student_info.php")
    Call<StudentList> getAllStudentInfo();

}

