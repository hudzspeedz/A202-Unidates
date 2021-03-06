package com.coventery.jack.unidatesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.Users;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    String DBFN[] = new String[20];
    String DBLN[] = new String[20];
    String DBage[] = new String[20];
    String DBUni[] = new String[20];
    String DBurl[] = new String[20];
    String DBurl2[] = new String[20];
    String DBurl3[] = new String[20];
    int ActiveUser;
    public static final String MyPREFERENCES = "Active-User" ;

    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        this.ActiveUser = sharedpreferences.getInt("UserLoged", -1 );
        Log.d("Active user in serch", Integer.toString(sharedpreferences.getInt("UserLoged", -1 )));



        Log.d("getting database handl", "");
        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<Users> users = db.getAllUsers();


        Log.d("getting database names", "");

        String test = " age 1 "+ users.get(1).get_Age() + " age 2 " + users.get(2).get_Age() +" age 3 "+ users.get(3).get_Age();
        Log.d("Test ages", test);
        for (Users cn : users) {
            String log = "Id: "+cn.get_id()+" ,fName: " + cn.get_Firstname() + " ,lname: " + cn.get_Surname() + " ,age: " + cn.get_Age();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        for(int i = 0; i < db.getUserCount();i ++)
        {
            DBFN[i] = users.get(i).get_Firstname();
            DBLN[i]= users.get(i).get_Surname();
            DBage[i]= users.get(i).get_Age();
            DBUni[i] = users.get(i).get_University();
            DBurl[i] = users.get(i).get_Url1();
            DBurl2[i] = users.get(i).get_Url2();
            DBurl3[i] = users.get(i).get_Url3();
        }

        Log.d("befor array", "Los arayos");

        gridView = (GridView) findViewById(R.id.GVScontent);
        gridAdapter = new GridViewAdapter(SearchActivity.this,R.layout.searchgrid,DBFN,DBage,DBUni,DBurl,db);
        gridView.setAdapter(gridAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Image1", DBurl[position]);
                intent.putExtra("Image2", DBurl2[position]);
                intent.putExtra("Image3", DBurl3[position]);
                intent.putExtra("Name", DBFN[position]);
                intent.putExtra("Age", DBage[position]);
                intent.putExtra("Uni", DBUni[position]);
                intent.putExtra("Lastname", DBLN[position]);

                startActivity(intent);

            }
        });


      Button myprofileb = (Button) findViewById(R.id.button3);
        myprofileb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);

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
                Intent intent = new Intent(SearchActivity.this,MatchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        }




    }


