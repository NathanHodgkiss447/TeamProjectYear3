package com.example.teamprojectyear3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    @Override void onCreate(Bundle savedInstantStance) {
        super.onCreate(savedInstantStance);
        setContentView(R.layout.activity_login);
    }

    //defining views
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewUserSignIn;
}
