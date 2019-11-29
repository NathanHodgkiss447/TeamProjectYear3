package com.example.teamprojectyear3;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.ArrayList;

public class MatchesActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter <String> adapter;
    requirements requirement;
    private Button Find;
    private EditText company;
    private String company1;
    private String company2;


       protected void onCreate (Bundle savedInstanceState){
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_matches);


           //Initialising views
           ImageView imgF = (ImageView) findViewById(R.id.facebook);
           ImageView imgT = (ImageView) findViewById(R.id.twitter);
           ImageView imgI = (ImageView) findViewById(R.id.instagram);
           ImageView imgL = (ImageView) findViewById(R.id.linkedin);
           company = (EditText) findViewById(R.id.editTextCompany);
           company1 = company.toString();
           Find = (Button) findViewById(R.id.find);

           //Find.setOnClickListener(this);


           requirement = new requirements();
           listView = (ListView) findViewById(R.id.listView);
           database = FirebaseDatabase.getInstance();
           ref = database.getReference("requirements");
           list = new ArrayList<>();
           adapter = new ArrayAdapter<String>(this, R.layout.requirement_info, R.id.requirementInfo, list);
           ref.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   for (DataSnapshot ds : dataSnapshot.getChildren()) {
                       requirement = ds.getValue(requirements.class);




                           list.add(requirement.getDegreeName().toString() + " // " + requirement.getArea().toString() + " //" + requirement.getDegreeLevel().toString());


                   }
                   listView.setAdapter(adapter);
               }

               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

               }
           });


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




/*
    @Override
    public void onClick(View view) {
        if(view == Find){
            find();

        }
    }

 */
}