package com.example.timesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.timesystem.Response.LoginResponse;
import com.example.timesystem.Retrofit.ApiClient;
import com.example.timesystem.Retrofit.ApiService;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {

                    }
                });
            }
        });


    }


}