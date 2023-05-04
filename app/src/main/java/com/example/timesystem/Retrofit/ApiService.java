package com.example.timesystem.Retrofit;

import com.example.timesystem.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService
 {
     @GET
     Call<List<User>>getuser();
}
