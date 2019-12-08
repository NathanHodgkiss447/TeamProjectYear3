package com.example.teamprojectyear3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
//import android.widget.ArrayAdapter;
import android.widget.RadioButton;
//import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.lang.String;
import java.lang.*;
import java.lang.reflect.Array;


public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    private Button buttonella;
    public String Grad;
    public Button Button;
    RadioGroup radio1;

    public void onClick (View view) {

        if (view == buttonella) {
            //logging out the user

            //Intent i = new Intent();
// Set the component using a String
            if(Grad == "Grad") {
                startActivity(new Intent(SearchActivity.this, PHPActivity2.class));
               // Toast.makeText(getApplicationContext(), Grad, Toast.LENGTH_SHORT).show();
            }
            else if (Grad == "College"){
                startActivity(new Intent(SearchActivity.this, PHPActivity.class));
               // Toast.makeText(getApplicationContext(), Grad, Toast.LENGTH_SHORT).show();

            }

        }}




        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();
            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radio_college:
                    if (checked)
                         Grad = "College";
                    radio1.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_grad:
                    if (checked)
                        Grad = "Grad";
                    radio1.setVisibility(View.VISIBLE);
                    break;
            }



            }






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.GradArray, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);





        //Initialising views
        buttonella = findViewById(R.id.buttonella);
        ImageView imgF = findViewById(R.id.facebook);
        ImageView imgT = findViewById(R.id.twitter);
        ImageView imgI = findViewById(R.id.instagram);
        ImageView imgL = findViewById(R.id.linkedin);
         //radio1= findViewById(R.id.radio1);

        buttonella.setOnClickListener(this);

        //<> GradArray = (Array<>) findViewById(R)


















    //All dylan
































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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
