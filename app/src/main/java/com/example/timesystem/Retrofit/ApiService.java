package com.example.timesystem.Retrofit;

import com.example.timesystem.Model.User;
import com.example.timesystem.Response.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET
    Call<List<User>> getuser();

    @GET
    Call<LoginResponse> login(@Query("username")String username,
                              @Query("password")String password);
}
