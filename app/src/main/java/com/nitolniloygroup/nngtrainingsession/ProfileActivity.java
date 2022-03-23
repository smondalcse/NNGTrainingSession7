package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.nitolniloygroup.nngtrainingsession.model.Employees;
import com.nitolniloygroup.nngtrainingsession.model.LoginTraining;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar toolsbar = getSupportActionBar();
        toolsbar.setTitle("Profile");
        toolsbar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        Employees emps = (Employees) bundle.getSerializable("emp_res");

        List<LoginTraining> listEmp = emps.getLoginTraining();
        LoginTraining loginInfo = listEmp.get(0);

        TextView txtEmpID = findViewById(R.id.txtEmpID);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtMobile = findViewById(R.id.txtMobile);
        TextView txtEmail = findViewById(R.id.txtEmail);
        TextView txtDept = findViewById(R.id.txtDept);

        txtEmpID.setText(loginInfo.getEmpID());
        txtName.setText(loginInfo.getUserName());
        txtMobile.setText(loginInfo.getMobile());
        txtEmail.setText(loginInfo.getEmail());
        txtDept.setText(loginInfo.getDept());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    
}