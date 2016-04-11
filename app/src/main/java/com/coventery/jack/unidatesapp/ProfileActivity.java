package com.coventery.jack.unidatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button myprofileb = (Button) findViewById(R.id.button2);
        myprofileb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SearchActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String age = intent.getStringExtra("Age");
        String uni = intent.getStringExtra("Uni");
        final String Image1 = intent.getStringExtra("Image1");
        final String Image2 = intent.getStringExtra("Image2");
        final String Image3 = intent.getStringExtra("Image3");


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
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image", Image1);
                startActivity(intent);
            }
        });
        IMAGE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ImageActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image", Image2);
                startActivity(intent);
            }
        });
        IMAGE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ImageActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image", Image3);
                startActivity(intent);
            }
        });

    }

}
