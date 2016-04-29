package com.coventery.jack.unidatesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.MatchHandler;
import com.coventery.jack.unidatesapp.app.Matches;
import com.coventery.jack.unidatesapp.app.Users;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "Active-User" ;
    int ActiveUser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        Intent intent = getIntent();

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        this.ActiveUser = sharedpreferences.getInt("UserLoged", -1 );
        Log.d("Active usr in profile", Integer.toString(ActiveUser));



        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<Users> users = db.getAllUsers();

        final MatchHandler matchHandler = new MatchHandler(this, users.get(ActiveUser).get_Firstname() + users.get(ActiveUser).get_Surname());



        Button myprofileb = (Button) findViewById(R.id.button3);
        myprofileb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Name", users.get(ActiveUser).get_Firstname());
                intent.putExtra("Age", users.get(ActiveUser).get_Age());
                intent.putExtra("Uni", users.get(ActiveUser).get_University());
                intent.putExtra("Image1", users.get(ActiveUser).get_Url1());
                intent.putExtra("Image2", users.get(ActiveUser).get_Url2());
                intent.putExtra("Image3", users.get(ActiveUser).get_Url3());
                startActivity(intent);
            }
        });

        Button matchbut = (Button) findViewById(R.id.button);
        matchbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,MatchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        Button Search = (Button) findViewById(R.id.button2);
        Search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SearchActivity.class);
                intent.putExtra("ActiveUser", ActiveUser);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });





       final String name = intent.getStringExtra("Name");
       final String age = intent.getStringExtra("Age");
       final String uni = intent.getStringExtra("Uni");
        final String Image1 = intent.getStringExtra("Image1");
        final String Image2 = intent.getStringExtra("Image2");
        final String Image3 = intent.getStringExtra("Image3");


        Button MatchButton = (Button) findViewById(R.id.MatchB);
        MatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                matchHandler.addMatch(new Matches(name,name,age,uni,Image1,Image2,Image3));

            }
        });

        TextView NAME = (TextView) findViewById(R.id.PTVname);
        TextView AGE = (TextView) findViewById(R.id.PTVage);
        TextView UNI = (TextView) findViewById(R.id.PTVuni);
        final ImageView IMAGE1 = (ImageView) findViewById(R.id.PIV1);
        IMAGE1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        final ImageView IMAGE2 = (ImageView) findViewById(R.id.PIV2);
        IMAGE2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        final ImageView IMAGE3 = (ImageView) findViewById(R.id.PIV3);
        IMAGE3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        NAME.setText(name);
        AGE.setText(age);
        UNI.setText(uni);
        new GetXMLTask(IMAGE1).execute(Image1);
        new GetXMLTask(IMAGE2).execute(Image2);
        new GetXMLTask(IMAGE3).execute(Image3);

        IMAGE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ImageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image", Image1);
                startActivity(intent);
            }
        });
        IMAGE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ImageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image", Image2);
                startActivity(intent);
            }
        });
        IMAGE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ImageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image", Image3);
                startActivity(intent);
            }
        });

    }

}
