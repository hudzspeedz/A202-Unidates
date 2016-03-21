package com.coventery.jack.unidatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        String Image = intent.getStringExtra("Image");
        ImageView fsimg = (ImageView) findViewById(R.id.IVFSI);
        fsimg.setScaleType(ImageView.ScaleType.CENTER);
        new GetXMLTask(fsimg).execute(Image);

    }

}
