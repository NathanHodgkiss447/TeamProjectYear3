package com.example.teamprojectyear3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    Completed by Alex Plunkett x17331006
    the login system for this app was based on the following tutorials
    https://www.youtube.com/watch?v=KFULmVXpO-A
    https://www.youtube.com/watch?v=V0ZrnL-i77Q&t

     */
    //defining views
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView SignIn;
    private TextView forgotPassView;

    //DECLARE FIREBASE AUTH
    private FirebaseAuth firebaseAuth;

    //declare progress dialog
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize firebase
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() !=null){
            //start profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }

        //initialize views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        SignIn = (TextView) findViewById(R.id.SignIn);
        forgotPassView = (TextView) findViewById(R.id.forgotPassView);

        progressDialog = new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
        SignIn.setOnClickListener(this);
        forgotPassView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPassActivity.class));
            }
        });
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please Enter a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        //if email and password are  not empty
        //display a progress dialog

        progressDialog.setMessage("Logging in user");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //task is successful
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this, "An error occured please try again", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignIn) {
            userLogin();

        }
        if (view == SignIn) {
            startActivity(new Intent(this, SignActivity.class));
        }
    }
}
