package com.example.teamprojectyear3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignUp;
    private EditText ediTextEmailR;
    private EditText editTextPasswordR;
    private TextView textViewUserSignUp;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //initialize views
        buttonSignUp =(Button)findViewById(R.id.buttonSignUp);
        ediTextEmailR = (EditText)findViewById(R.id.editTextEmailR);
        editTextPasswordR = (EditText)findViewById(R.id.editTextPasswordR);
        textViewUserSignUp = (TextView)findViewById(R.id.textViewUserSignUp);

        firebaseAuth = FirebaseAuth.getInstance();

    }
    private void registerUser(){
        String email = ediTextEmailR.getText().toString().trim();
        String password = editTextPasswordR.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter an email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
            return;
        }
        //if validation is ok
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //
                            Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            finish();
                        }else{
                            Toast.makeText(RegistrationActivity.this, "unable to register please try again", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignUp){
            registerUser();
        }
        if(view == textViewUserSignUp){
            //open registration activity
            startActivity(new Intent(this, RegistrationActivity.class));
        }

    }
}
