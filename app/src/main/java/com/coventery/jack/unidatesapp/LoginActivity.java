package com.coventery.jack.unidatesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.coventery.jack.unidatesapp.app.DataPrefill;
import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.Users;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    int ActiveUser;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "Active-User" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        DatabaseHandler db = new DatabaseHandler(this);
        DataPrefill fill = new DataPrefill();

        if (db.getUserCount() == 0){
            Log.d("Insert", "Inserting ...");
            fill.Dataprefill(db);
            Log.d("inserted", "inserted");
        }

        db.close();

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Users> users = db.getAllUsers();

        for (Users cn : users) {
            String log = "Id: "+cn.get_id()+" ,fName: " + cn.get_Firstname() + " ,lname: " + cn.get_Surname();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }


            Button LoginButon = (Button) findViewById(R.id.BLogin);
        LoginButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Launch = new Intent(LoginActivity.this, SearchActivity.class);
                Launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                if (DBLOGIN()) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.clear();
                    editor.putInt("UserLoged", ActiveUser);
                    editor.apply();
                    Log.d("Active user in log", Integer.toString(sharedpreferences.getInt("UserLoged",-1)));
                    startActivity(Launch);
                    finish();
                }
            }
        });

        Button SignupBut = (Button) findViewById(R.id.BSignup);
        SignupBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup = new Intent(LoginActivity.this,SignupActivity.class);

                Signup.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Signup);
                finish();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    boolean DBLOGIN(){
        DatabaseHandler db = new DatabaseHandler(this);
        List<Users> users = db.getAllUsers();


        EditText username = (EditText) findViewById(R.id.ETUsername);
        final String Username = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.ETPassword);
        final String Password = password.getText().toString();

        for (int i = 0; i < db.getUserCount(); i++) {
            if (Username.equals(users.get(i).get_Username())){
                if (Password.equals(users.get(i).get_Password())){
                    this.ActiveUser = i;
                    return (true);

                }
            }

        }
        return (false);
    }
}
