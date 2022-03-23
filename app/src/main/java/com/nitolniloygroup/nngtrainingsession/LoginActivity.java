package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nitolniloygroup.nngtrainingsession.model.Employees;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar toolsbar = getSupportActionBar();
        toolsbar.hide();

        TextView txtCreateAcc = findViewById(R.id.txtCreateAcc);
        txtCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        EditText etEmpID = findViewById(R.id.etEmpID);
        EditText etPasswrod = findViewById(R.id.etPasswrod);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EmpID = etEmpID.getText().toString();
                String Pass = etPasswrod.getText().toString();
                login(EmpID, Pass);
            }
        });
    }

    private void login(String EmpID, String Pass){
        Log.i(TAG, "login: ");

        String URL_BASE = "https://cs.nitolmotors.com.bd/appportal/api/nmlandroidtraining/";
        String URL_METHOD = "login?";
        String URL_PARAMS = "EmpID=" + EmpID + "&Pass=" + Pass;
        String URL_LOGIN = URL_BASE + URL_METHOD + URL_PARAMS;

        Log.i(TAG, "login: " + URL_LOGIN);

        StringRequest request = new StringRequest(URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "onResponse: ");
                Log.i(TAG, "onResponse: " + response);

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                Employees employees = gson.fromJson(response, Employees.class);
                if (employees.getLoginTraining().size() > 0) {
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.putExtra("employees", employees);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onErrorResponse: " + error.getMessage());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }
}