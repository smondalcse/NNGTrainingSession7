package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "DisplayActivity";
    TextView txtRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        SharedPreferences preferences = getSharedPreferences("com.nitolniloygroup.nngtrainingsession.user", MODE_PRIVATE);
        String empid = preferences.getString("empid", "No Empid found");
        int mobile = preferences.getInt("mobile", 0);
        long money = preferences.getLong("money", 0);

        Log.i(TAG, "onCreate: EmpID: " + empid + ", Mobile: " + String.valueOf(mobile) + ", Money: " + String.valueOf(money));

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("mobile", 10101);
        editor.apply();

        int newMobile = preferences.getInt("mobile", 0);
        Log.i(TAG, "onCreate: New Mobile No: " + String.valueOf(newMobile));

        editor.remove("money");
        editor.apply();

        long newMoney = preferences.getLong("money", 0);
        Log.i(TAG, "onCreate: newMoney: " + newMoney);

        editor.clear();
        editor.apply();

        String newEmpid = preferences.getString("empid", "No Empid found");
        Log.i(TAG, "onCreate: newEmpid: " + newEmpid);

        RatingBar rb = findViewById(R.id.rb);
        rb.setRating(3);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txtRating.setText("Rating: " + String.valueOf(rb.getRating()) + "/" + "5");
            }
        });

        txtRating = findViewById(R.id.txtRating);
        txtRating.setText("Rating: " + String.valueOf(rb.getRating()) + "/" + "5");

    }
}