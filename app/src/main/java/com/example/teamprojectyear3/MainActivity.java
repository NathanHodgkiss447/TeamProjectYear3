package com.example.teamprojectyear3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signIn;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views
        signIn = (Button) findViewById(R.id.signIn);
        signUp = (Button) findViewById(R.id.SignUp);
    }


    @Override
    public void onClick(View view){
        if(view == signIn){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(view == signUp){
            finish();
            startActivity(new Intent(this, RegistrationActivity.class));
        }
    }
}


