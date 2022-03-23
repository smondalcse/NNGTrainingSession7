package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nitolniloygroup.nngtrainingsession.R;
import com.nitolniloygroup.nngtrainingsession.model.Employees;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar toolsbar = getSupportActionBar();
        toolsbar.setTitle("Register");
        toolsbar.setDisplayHomeAsUpEnabled(true);

        EditText etEmpID = findViewById(R.id.etEmpID);
        EditText etUserName = findViewById(R.id.etUserName);
        EditText etPasswrod = findViewById(R.id.etPasswrod);
        EditText etDept = findViewById(R.id.etDept);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etMobile = findViewById(R.id.etMobile);

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String empID = etEmpID.getText().toString();
                String userName = etUserName.getText().toString();
                String pass = etPasswrod.getText().toString();
                String dept = etDept.getText().toString();
                String email = etEmail.getText().toString();
                String mobile = etMobile.getText().toString();

                register(empID, pass, userName, dept, mobile, email);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void register(String EmpID, String Pass, String UserName, String Dept, String Mobile, String Email){
        Log.i(TAG, "register: ");

        String URL_BASE = "https://cs.nitolmotors.com.bd/appportal/api/nmlandroidtraining/";
        String URL_METHOD = "register?";
        String URL_PARAMS = "EmpID=" + EmpID + "&UserName=" + UserName + "&Password=" + Pass + "&Dept="+ Dept + "&Email=" + Email + "&Mobile=" + Mobile;
        String URL_REGISTER = URL_BASE + URL_METHOD + URL_PARAMS;

        Log.i(TAG, "register: " + URL_REGISTER);

        StringRequest request = new StringRequest(URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "onResponse: ");
                Log.i(TAG, "onResponse: " + response);

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                Employees employees = gson.fromJson(response, Employees.class);

                Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                intent.putExtra("employees", employees);
                startActivity(intent);

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