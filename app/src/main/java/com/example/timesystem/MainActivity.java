package com.example.timesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

import com.example.timesystem.Model.User;
import com.example.timesystem.Response.LoginResponse;
import com.example.timesystem.Retrofit.ApiClient;
import com.example.timesystem.Retrofit.ApiService;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    TextInputLayout user, pass;
    Button loginbtn;
    ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.usernameLogin);
        pass=findViewById(R.id.passwordLogin);
        loginbtn=findViewById(R.id.loginButton);
        apiService= ApiClient.getClient().create(ApiService.class);


        loginbtn.setOnClickListener(v -> {
            String username= Objects.requireNonNull(user.getEditText()).getText().toString();
            String password= Objects.requireNonNull(pass.getEditText()).getText().toString();
            Call<LoginResponse>loginResponseCall=apiService.login(username,password);
            loginResponseCall.enqueue(new Callback<LoginResponse>()
            {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    if(response.isSuccessful())
                    {
                        LoginResponse loginResponse=response.body();
                        assert loginResponse != null;
                         User user= loginResponse.getUser();
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t)
                {

                }
            });
        });


    }


}