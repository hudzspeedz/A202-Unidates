package com.coventery.jack.unidatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.Users;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    String Fnames[];
    String Age[];
    String Uni[];
    String Urls[];
    String DBFN[] = new String[20];
    String DBurl[] = new String[20];

    private GridView gridView;
    private GridViewAdapter gridAdapter;
    private ArrayAdapter gridAdapterdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Log.d("getting database handl", "");
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Users> users = db.getAllUsers();

        Log.d("getting resorces names", "");
        Fnames = getResources().getStringArray(R.array.firstname);
        Age = getResources().getStringArray(R.array.age);
        Uni= getResources().getStringArray(R.array.uni);
        Urls = getResources().getStringArray(R.array.urlimage);


        Log.d("getting database names", "");

        String test = " age 1 "+ users.get(1).get_Age() + " age 2 " + users.get(2).get_Age() +" age 3 "+ users.get(3).get_Age();
        Log.d("Test ages", test);
        for (Users cn : users) {
            String log = "Id: "+cn.get_id()+" ,fName: " + cn.get_Firstname() + " ,lname: " + cn.get_Surname() + " ,age: " + cn.get_Age();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        for(int i = 0; i < 9 ;i ++)
        {
            DBFN[i] = users.get(i).get_Firstname();
            DBurl[i] = users.get(i).get_Url1();
        }

        Log.d("befor array", "Los arayos");

        gridView = (GridView) findViewById(R.id.GVScontent);
        gridAdapter = new GridViewAdapter(SearchActivity.this,R.layout.searchgrid,DBFN,Age,Uni,DBurl);
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


