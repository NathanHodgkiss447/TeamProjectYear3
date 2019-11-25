package com.example.teamprojectyear3;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SettingActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editName;
    private EditText editCompany;
    private EditText editTitle;
    private EditText editEmail;


    private static final String TAG = "SettingActivity";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        FirebaseFirestore db = FirebaseFirestore.getInstance();


        //Initialising views

        ImageView imgF = (ImageView) findViewById(R.id.facebook);
        ImageView imgT = (ImageView) findViewById(R.id.twitter);
        ImageView imgI = (ImageView) findViewById(R.id.instagram);
        ImageView imgL = (ImageView) findViewById(R.id.linkedin);
        editName = (EditText) findViewById(R.id.editTextName);
        editCompany = (EditText) findViewById(R.id.editCompany);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editEmail = (EditText) findViewById(R.id.editEmail);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);





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

    private void SubmitUser(){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

// Create a new user with a first, middle, and last name
        Map<String, Object> Employer = new HashMap<>();
        Employer.put("Name", editName);
        Employer.put("Company", editCompany);
        Employer.put("Title", editTitle);
        Employer.put("Email", editEmail);


// Add a new document with a generated ID
        db.collection("Employer" + editEmail)
                .add(Employer)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG,"DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public void submit(View view) {

        if (view == buttonSubmit) {
            SubmitUser();
        }
    }
}
