package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity2";

    TextView txtSum;
    EditText etNum1, etNum2;
    Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtSum = findViewById(R.id.txtSum);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        etNum2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i(TAG, "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i(TAG, "onTextChanged: ");
                String input1 = etNum1.getText().toString();
                String input2 = etNum2.getText().toString();
                int sum = Integer.parseInt(input1) + Integer.parseInt(input2);
                txtSum.setText("Sum: " + String.valueOf(sum));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "afterTextChanged: ");
            }
        });

        btnSum = findViewById(R.id.btnSum);
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String input1 = etNum1.getText().toString();
//                String input2 = etNum2.getText().toString();
//
//                int sum = Integer.parseInt(input1) + Integer.parseInt(input2);
//                txtSum.setText("Sum: " + String.valueOf(sum));
//            }
//        });

    }
}