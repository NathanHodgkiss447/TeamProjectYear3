package com.example.teamprojectyear3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonella;
    public void onClick (View view) {
        //if logout is pressed
        if (view == buttonella) {
            //logging out the user

            //closing activity

            //starting login activity
            startActivity(new Intent(this, PHPActivity.class));
        }
    }
    //All dylan

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



            //Initialising views
            buttonella = (Button) findViewById(R.id.buttonella);
            ImageView imgF = (ImageView) findViewById(R.id.facebook);
            ImageView imgT = (ImageView) findViewById(R.id.twitter);
            ImageView imgI = (ImageView) findViewById(R.id.instagram);
            ImageView imgL = (ImageView) findViewById(R.id.linkedin);

            buttonella.setOnClickListener(this);

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

    }
