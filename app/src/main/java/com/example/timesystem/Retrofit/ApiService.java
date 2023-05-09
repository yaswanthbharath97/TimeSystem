package com.example.timesystem.Retrofit;


import com.example.timesystem.Response.LoginResponse;



import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;


public interface ApiService {


    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );
}
