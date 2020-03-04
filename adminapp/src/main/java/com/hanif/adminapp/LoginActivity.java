package com.hanif.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanif.adminapp.api.LoginAPI;
import com.hanif.adminapp.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String URL = "http://192.168.43.253:8000/api/v1/";

    EditText edtUsername;
    EditText edtPassword;
    Button btn_login;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_signin);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {

        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading...");
        progress.show();

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (view.getId() == R.id.btn_signin) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                    .build();

            LoginAPI api = retrofit.create(LoginAPI.class);
            Call<Result> call = api.signin(username, password);
            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    progress.dismiss();

                    String message = response.body().getMessage();
                    String value = response.body().getValue();
                    String idLevel = response.body().getIdLevel();

                    if (value.equals("0")) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    } else if (idLevel.equals("3")){
                        Toast.makeText(LoginActivity.this, "Anda bukan admin", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                }
            });
        }
    }
}
