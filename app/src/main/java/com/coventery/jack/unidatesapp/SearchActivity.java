package com.coventery.jack.unidatesapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


public class SearchActivity extends AppCompatActivity {

    String Fnames[];
    String Age[];
    String Uni[];
    String Urls[];



    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Fnames = getResources().getStringArray(R.array.firstname);
        Age = getResources().getStringArray(R.array.age);
        Uni= getResources().getStringArray(R.array.uni);
        Urls = getResources().getStringArray(R.array.urlimage);


        Log.d("befor array", "Los arayos");

        gridView = (GridView) findViewById(R.id.GVScontent);
        gridAdapter = new GridViewAdapter(SearchActivity.this,R.layout.searchgrid,Fnames,Age,Uni,Urls);
        gridView.setAdapter(gridAdapter);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image1", Urls[position]);
                intent.putExtra("Name", Fnames[position]);
                intent.putExtra("Age", Age[position]);
                intent.putExtra("Uni", Uni[position]);
                startActivity(intent);

            }
        });


     /*   Button myprofileb = (Button) findViewById(R.id.button3);
        myprofileb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this,ProfileActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Name", "Jack");
                intent.putExtra("Age","19");
                intent.putExtra("Uni","Coventry");
                startActivity(intent);
            }
        });*/


        }



    }


