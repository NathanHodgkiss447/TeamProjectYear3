package com.example.teamprojectyear3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.ArrayAdapter;
import android.widget.RadioButton;
//import android.widget.Spinner;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.String;
import java.lang.*;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button buttonella;
    public String Grad;
    public Button Button;
   // RadioGroup radio1;
  private String text;
    Spinner spinner;
    public String GradInfo;





    public void onClick(View view) {

        if (view == buttonella) {
            //logging out the user

            //Intent i = new Intent();
// Set the component using a String
            if (Grad == "Grad") {
               // startActivity(new Intent(SearchActivity.this, PHPActivity2.class));
                // Toast.makeText(getApplicationContext(), Grad, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, PHPActivity2.class);
                intent.putExtra("EXTRA_SESSION_ID", GradInfo);
                startActivity(intent);

            } else if (Grad == "College") {
                startActivity(new Intent(SearchActivity.this, PHPActivity.class));
                // Toast.makeText(getApplicationContext(), Grad, Toast.LENGTH_SHORT).show();

            }

        }
    }


    public void onRadioButtonClicked(View view) {

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_college:
                if (checked)
                    Grad = "College";

                spinner.setVisibility(View.GONE);
                break;
            case R.id.radio_grad:
                if (checked)
                    Grad = "Grad";

                spinner.setVisibility(View.VISIBLE);
                break;
        }


    }




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.GradArray,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Initialising views
        buttonella = findViewById(R.id.buttonella);
        ImageView imgF = findViewById(R.id.facebook);
        ImageView imgT = findViewById(R.id.twitter);
        ImageView imgI = findViewById(R.id.instagram);
        ImageView imgL = findViewById(R.id.linkedin);
         //radio1= findViewById(R.id.radio1);

        buttonella.setOnClickListener(this);

        //<> GradArray = (Array<>) findViewById(R)







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


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        //An item was selected
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        TextView mEdit = (TextView) findViewById(R.id.mEdit);
        spinner.setOnItemSelectedListener(this);
          GradInfo = parent.getItemAtPosition(pos).toString();

        mEdit.setText(GradInfo);
        Log.i("MyToe", GradInfo);





        // Log.i("MyLAG", "This" + GradInfo);



    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
