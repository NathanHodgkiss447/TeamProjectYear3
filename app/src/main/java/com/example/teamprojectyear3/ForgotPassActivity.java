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
        if(view == btnReset){
            String userEmail = emailReset.getText().toString();
            if(TextUtils.isEmpty(userEmail)){
                Toast.makeText(ForgotPassActivity.this, "Please enter your email", Toast.LENGTH_LONG).show();
            }
            else{
                fAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                        Toast.makeText(ForgotPassActivity.this, "Please check your email to reset your password", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ForgotPassActivity.this, LoginActivity.class));
                        }else{
                            String message = task.getException().getMessage();
                            Toast.makeText(ForgotPassActivity.this, "An error ocurred please try again" +message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }
}
