package com.example.teamprojectyear3;

/*

        Code From: https://www.youtube.com/watch?v=i_GuZ_6ZRJM&t=261s

 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SettingActivity extends AppCompatActivity {

    private Button submit;
    private EditText name;
    private EditText company;
    private EditText title;
    private EditText email;

    DatabaseReference databaseReference;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        databaseReference = FirebaseDatabase.getInstance().getReference("settings");

        //Initialising views

        ImageView imgF = (ImageView) findViewById(R.id.facebook);
        ImageView imgT = (ImageView) findViewById(R.id.twitter);
        ImageView imgI = (ImageView) findViewById(R.id.instagram);
        ImageView imgL = (ImageView) findViewById(R.id.linkedin);
        name = (EditText) findViewById(R.id.editTextName);
        company = (EditText) findViewById(R.id.editCompany);
        title = (EditText) findViewById(R.id.editTitle);
        email = (EditText) findViewById(R.id.editEmail);
        submit = (Button) findViewById(R.id.buttonSubmit);


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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSettings();
            }
        });


    }

    public void addSettings(){
        String settingsName = name.getText().toString();
        String settingsCompany = company.getText().toString();
        String settingsTitle = title.getText().toString();
        String settingsEmail = email.getText().toString();

        if(!TextUtils.isEmpty(settingsName) && !TextUtils.isEmpty(settingsCompany) && !TextUtils.isEmpty(settingsTitle) && !TextUtils.isEmpty(settingsEmail) ){

            String id = databaseReference.push().getKey();

            EmployerSettings employerSettings = new EmployerSettings(id, settingsName,
                    settingsCompany, settingsTitle, settingsEmail);

            databaseReference.child(id).setValue(employerSettings);
            name.setText("");
            company.setText("");
            title.setText("");
            email.setText("");

        } else{
            Toast.makeText(SettingActivity.this, "Please fulfill all information required"
                    , Toast.LENGTH_LONG).show();
        }


    }


}































    /*
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

     */

