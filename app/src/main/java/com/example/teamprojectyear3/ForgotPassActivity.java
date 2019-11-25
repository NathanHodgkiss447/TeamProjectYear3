package com.example.teamprojectyear3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
