package com.example.teamprojectyear3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class HomeSActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btnLogout;
    ImageView btnQualification;
    ImageView btnView;
    ImageView btnLearn;
    ImageView btnSettingSt;

    private TextView textViewUserEmail;
    EditText etName, etAge, etUserName;


    //firebase auth object
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);


        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();


        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }


        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();


        //Initialising views

        btnLogout = (ImageView) findViewById(R.id.logout);
        btnQualification = (ImageView) findViewById(R.id.qualification);
        btnView = (ImageView) findViewById(R.id.views);
        btnLearn = (ImageView) findViewById(R.id.learnS);
        btnSettingSt = (ImageView) findViewById(R.id.settingsSt);
        ImageView imgF = (ImageView) findViewById(R.id.facebook);
        ImageView imgT = (ImageView) findViewById(R.id.twitter);
        ImageView imgI = (ImageView) findViewById(R.id.instagram);
        ImageView imgL = (ImageView) findViewById(R.id.linkedin);

        //Displays currently logged in user
        /* textViewUserEmail.setText("Welcome "+user.getEmail());*/

        btnLogout.setOnClickListener(this);
        btnQualification.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnLearn.setOnClickListener(this);
        btnSettingSt.setOnClickListener(this);


        //Facebook launching on icon tap
        imgF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://facebook.com"));
                startActivity(intent);
            }
        });

        //Twitter launching on icon tap
        imgT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
        if (v == btnLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }


        switch (v.getId()) {

            case R.id.settingsSt:

                startActivity(new Intent(this, SettingActivity.class));

                break;

            case R.id.learnS:

                startActivity(new Intent(this, LearnActivity.class));

                break;

            case R.id.views:

                startActivity(new Intent(this, ViewActivity.class));

                break;

            case R.id.qualification:

                startActivity(new Intent(this, QualificationsActivity.class));


                break;


        }

    }

}




