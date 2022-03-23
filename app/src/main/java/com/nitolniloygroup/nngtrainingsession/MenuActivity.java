package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
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

public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle = getIntent().getExtras();
        Employees emps = (Employees) bundle.getSerializable("employees");
        Log.i(TAG, "onCreate: " + emps.getLoginTraining().get(0).getUserName());

        TextView txtUserName = findViewById(R.id.txtUserName);
        txtUserName.setText("Emp Name: " + emps.getLoginTraining().get(0).getUserName());
        
        LinearLayout linProfile = findViewById(R.id.linProfile);
        linProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                intent.putExtra("emp_res", emps);
                startActivity(intent);
            }
        });

        LinearLayout linEmps = findViewById(R.id.linEmps);
        linEmps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, EmployeesActivity.class);
                intent.putExtra("emp_res", emps);
                startActivity(intent);
            }
        });
    }



}