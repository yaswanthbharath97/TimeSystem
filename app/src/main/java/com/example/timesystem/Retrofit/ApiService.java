package com.example.timesystem.Retrofit;


import com.example.timesystem.Model.User;
import com.example.timesystem.Response.LoginResponse;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("login")
    Call<LoginResponse> login(@Body User user);
}
