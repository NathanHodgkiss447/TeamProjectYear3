package com.example.teamprojectyear3;

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

public class QualificationsActivity extends AppCompatActivity {

    private EditText degreeName;
    private EditText degreeType;
    private EditText degreeLevel;
    private EditText area;
    private Button submit;

    DatabaseReference databaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirements);

        databaseReference = FirebaseDatabase.getInstance().getReference("requirements");



        //Initialising views

        ImageView imgF = (ImageView)findViewById(R.id.facebook);
        ImageView imgT = (ImageView)findViewById(R.id.twitter);
        ImageView imgI = (ImageView)findViewById(R.id.instagram);
        ImageView imgL = (ImageView)findViewById(R.id.linkedin);

        degreeName = (EditText)findViewById(R.id.editDegreeName);
        degreeType = (EditText)findViewById(R.id.editDegreeType);
        degreeLevel = (EditText)findViewById(R.id.editDegreeLevel);
        area = (EditText)findViewById(R.id.editArea);
        submit = (Button)findViewById(R.id.buttonSubmit);



        //Send button to submit data
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRequirements();
            }
        });


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

    public void addRequirements(){
        String employerName = degreeName.getText().toString();
        String employerDegreeType = degreeType.getText().toString();
        String employerDegreeLevel = degreeLevel.getText().toString();
        String employerArea = area.getText().toString();


        if(!TextUtils.isEmpty(employerName) && !TextUtils.isEmpty(employerDegreeType) && !TextUtils.isEmpty(employerDegreeLevel) && !TextUtils.isEmpty(employerArea) ){

            String id = databaseReference.push().getKey();

            EmployerRequirements employerRequirements = new EmployerRequirements(id, degreeName,
                    degreeType, degreeLevel, area);

            databaseReference.child(id).setValue(employerRequirements);
            degreeName.setText("");
            degreeType.setText("");
            degreeLevel.setText("");
            area.setText("");
        }
        else{
            Toast.makeText(QualificationsActivity.this, "Please fulfill all information required"
                    , Toast.LENGTH_LONG).show();
        }


    }

}
