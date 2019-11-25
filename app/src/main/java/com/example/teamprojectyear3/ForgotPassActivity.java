package com.example.teamprojectyear3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnReset;
    private EditText emailReset;

    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        fAuth = FirebaseAuth.getInstance();

        btnReset = (Button)findViewById(R.id.btnReset);
        emailReset = (EditText)findViewById(R.id.emailReset);

        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
