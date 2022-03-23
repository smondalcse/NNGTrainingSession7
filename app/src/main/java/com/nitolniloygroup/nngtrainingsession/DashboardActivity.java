package com.nitolniloygroup.nngtrainingsession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private static final String TAG = "DashboardActivity";

    TextView txtEmpID2, txtName2, txtMobile2, txtEmpID3, txtName3, txtMobile3, txtEmpID4, txtName4, txtMobile4,
            txtEmpID5, txtName5, txtMobile5;

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ActionBar toolsbar = getSupportActionBar();
        toolsbar.setTitle("Dashboard");
        toolsbar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
//        String empID = bundle.getString("empid", "No Employee ID found");
//        String name = bundle.getString("name", "No Employee name found");
//        int mobile = bundle.getInt("mobile", 0);

       // UserModel user = (UserModel) bundle.getSerializable("user");

        UsersModel usersModel = (UsersModel) bundle.getSerializable("users");

        List<UserModel> listUsers = usersModel.getUsers();

        UserModel u1 = listUsers.get(0);
        UserModel u2 = listUsers.get(1);
        UserModel u3 = listUsers.get(2);
        UserModel u4 = listUsers.get(3);
        UserModel u5 = listUsers.get(4);

        TextView txtEmpID = findViewById(R.id.txtEmpID);
        txtEmpID.setText(u1.getEmpID());

        TextView txtName = findViewById(R.id.txtName);
        txtName.setText(u1.getEmpName());

        TextView txtMobile = findViewById(R.id.txtMobile);
        txtMobile.setText(String.valueOf(u1.getEmpMobile()));

        txtEmpID2 = findViewById(R.id.txtEmpID2);
        txtName2 = findViewById(R.id.txtName2);
        txtMobile2 = findViewById(R.id.txtMobile2);
        txtEmpID2.setText(u2.getEmpID());
        txtName2.setText(u2.getEmpName());
        txtMobile2.setText(u2.getEmpMobile());

        txtEmpID3 = findViewById(R.id.txtEmpID3);
        txtName3 = findViewById(R.id.txtName3);
        txtMobile3 = findViewById(R.id.txtMobile3);
        txtEmpID3.setText(u3.getEmpID());
        txtName3.setText(u3.getEmpName());
        txtMobile3.setText(u3.getEmpMobile());


        txtEmpID4 = findViewById(R.id.txtEmpID4);
        txtName4 = findViewById(R.id.txtName4);
        txtMobile4 = findViewById(R.id.txtMobile4);
        txtEmpID4.setText(u4.getEmpID());
        txtName4.setText(u4.getEmpName());
        txtMobile4.setText(u4.getEmpMobile());

        txtEmpID5 = findViewById(R.id.txtEmpID5);
        txtName5 = findViewById(R.id.txtName5);
        txtMobile5 = findViewById(R.id.txtMobile5);
        txtEmpID5.setText(u5.getEmpID());
        txtName5.setText(u5.getEmpName());
        txtMobile5.setText(u5.getEmpMobile());

        String names[] = {u1.getEmpName(), u2.getEmpName(), u3.getEmpName(), u4.getEmpName(), u5.getEmpName(), "Nitol Niloy Group-506", "Nitol Niloy Group-507", "Nitol Niloy Group-508"};

        listview = findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String clickItemName = names[position];
                Toast.makeText(DashboardActivity.this, clickItemName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void listView() {
        Log.i(TAG, "listView: ");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}