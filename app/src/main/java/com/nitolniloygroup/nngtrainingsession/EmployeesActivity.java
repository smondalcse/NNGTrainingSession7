package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nitolniloygroup.nngtrainingsession.model.Employees;
import com.nitolniloygroup.nngtrainingsession.model.LoginTraining;

import java.util.ArrayList;
import java.util.List;

public class EmployeesActivity extends AppCompatActivity {
    private static final String TAG = "EmployeesActivity";
    ListView listview;
    ArrayList<String> listNames;
    ArrayAdapter adapter;
    List<LoginTraining> listLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        listNames = new ArrayList<>();
        getEmployees();

        listview = findViewById(R.id.listview);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNames);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedEmpName = listNames.get(position);
                Toast.makeText(EmployeesActivity.this, selectedEmpName, Toast.LENGTH_SHORT).show();

                LoginTraining obj = listLogin.get(position);

            }
        });
    }

    private void getEmployees(){
        Log.i(TAG, "getEmployees: ");

        String URL_BASE = "https://cs.nitolmotors.com.bd/appportal/api/nmlandroidtraining/";
        String URL_METHOD = "employees";
        String URL_EMPLYOEES = URL_BASE + URL_METHOD;

        Log.i(TAG, "getEmployees: " + URL_EMPLYOEES);

        StringRequest request = new StringRequest(URL_EMPLYOEES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "onResponse: ");
                Log.i(TAG, "onResponse: " + response);

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                Employees employees = gson.fromJson(response, Employees.class);
                listLogin = employees.getLoginTraining();
                for (int i = 0; i < listLogin.size(); i++){
                    listNames.add(listLogin.get(i).getUserName());
                }

                adapter.notifyDataSetChanged();

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