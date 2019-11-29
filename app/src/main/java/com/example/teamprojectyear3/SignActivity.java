package com.example.teamprojectyear3;





import android.app.ProgressDialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {

//defining view objects
private EditText editTextEmail;
private EditText editTextPassword;
private Button buttonSignup;


private TextView textViewSignup;

private ProgressDialog progressDialog;


//defining firebaseauth object
private FirebaseAuth mAuth;
private FirebaseUser mUser;




//Everything within onCreate executes when app is launched
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //Splash Screen
        //setTheme(R.style.AppTheme);

        //initializing firebase auth object
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        if(mUser != null){
        startActivity(new Intent(SignActivity.this, HomeActivity.class));
        }

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignup = (TextView) findViewById(R.id.textViewUserSignup);


        buttonSignup = (Button) findViewById(R.id.buttonSignup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
        }

//Method for registering user.
private void registerUser(){

//getting email and password from edit texts
final String email = editTextEmail.getText().toString().trim();
final String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
        Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
        return;
        }

        if(TextUtils.isEmpty(password)){
        Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
        return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering - Please Wait...");
        progressDialog.show();

        //creating a new user
        mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
        //checking if success
        if(task.isSuccessful()){
        mAuth.getCurrentUser().sendEmailVerification()
        .addOnCompleteListener(new OnCompleteListener<Void>() {
@Override
public void onComplete(@NonNull Task<Void> task) {
        if(mAuth.getCurrentUser().isEmailVerified()){
        Toast.makeText(SignActivity.this,"Registration Successful", Toast.LENGTH_LONG).show();
        startActivity(new Intent(SignActivity.this, LoginActivity.class));
        }else{
        Toast.makeText(SignActivity.this, "email is not registered", Toast.LENGTH_LONG).show();
        }
        }
        });
        }else{
        //display some message here
        Toast.makeText(SignActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
        }
        progressDialog.dismiss();
        }
        });

        }


@Override
public void onClick(View view) {
        //Signup button starts registerUser method
        if(view == buttonSignup){
        registerUser();

        }
        }


        }
