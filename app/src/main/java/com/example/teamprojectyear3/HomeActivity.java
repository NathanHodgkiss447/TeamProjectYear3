package com.example.teamprojectyear3;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btnRequirement;
    ImageView btnLearn;
    ImageView btnSetting;
    ImageView btnLogout;
    ImageView btnSearch;
    ImageView btnMatches;

    private TextView textViewUserEmail;
    EditText etName, etAge, etUserName;



    //firebase auth object
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
        /*
        FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    finish();
                    startActivity(new Intent(HomeActivity.this, MainActivity.class));
                }
            }
        };

 */
        //initializing firebase authentication object

        //firebaseAuth.addAuthStateListener(authStateListener);

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //if(firebaseAuth.currentuser().emailverified)
            finish();
            //starting login activity
            startActivity(new Intent(this, MainActivity.class));
        }




        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();


        //Initialising views
        btnMatches = (ImageView) findViewById(R.id.matches);
        btnRequirement = (ImageView) findViewById(R.id.requirement);
        btnSetting = (ImageView) findViewById(R.id.setting);
        btnLearn = (ImageView) findViewById(R.id.learn);
        btnLogout = (ImageView) findViewById(R.id.logout);
        btnSearch = (ImageView) findViewById(R.id.search);
        ImageView imgF = (ImageView)findViewById(R.id.facebook);
        ImageView imgT = (ImageView)findViewById(R.id.twitter);
        ImageView imgI = (ImageView)findViewById(R.id.instagram);
        ImageView imgL = (ImageView)findViewById(R.id.linkedin);

        //Displays currently logged in user
       /* textViewUserEmail.setInfo("Welcome "+user.getEmail());*/

        btnMatches.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnLearn.setOnClickListener(this);
        btnRequirement.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnRequirement.setOnClickListener(this);
        btnLogout.setOnClickListener(this);




        //Facebook launching on icon tap
        imgF.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://facebook.com"));
                startActivity(intent);
            }
        });

        //Twitter launching on icon tap
        imgT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://twitter.com"));
                startActivity(intent);
            }
        });


        //Linkedin launching on icon tap
        imgL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/?hl=en"));
                startActivity(intent);
            }
        });

        //Instagram launching on icon tap
        imgI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/?hl=en"));
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        //if logout is pressed
        if(v == btnLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity

            //starting login activity
            startActivity(new Intent(this, MainActivity.class));
        }


        switch (v.getId()) {
            case R.id.search:

                startActivity(new Intent(this, SearchActivity.class));





                break;

        }
        switch (v.getId()) {
            case R.id.matches:

                startActivity(new Intent(this, MatchesActivity.class));




                break;

        }
        switch (v.getId()) {
            case R.id.requirement:

                startActivity(new Intent(this, QualificationsActivity.class));




                break;

        }
        switch (v.getId()) {
            case R.id.learn:

                startActivity(new Intent(this, LearnActivity.class));




                break;

        }
        switch (v.getId()) {
            case R.id.setting:

                startActivity(new Intent(this, SettingActivity.class));




                break;

        }


    }
}
