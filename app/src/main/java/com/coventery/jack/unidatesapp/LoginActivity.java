package com.coventery.jack.unidatesapp;

import android.content.Intent;
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

    String[] Users;
    String[] Passes;
    String ActiveUser;
    String ActivePassword;
    int PassNID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String u = "jack";
        final String p = "jackspass";

        DatabaseHandler db = new DatabaseHandler(this);
        DataPrefill fill = new DataPrefill();

        Log.d("Insert", "Inserting ...");
        fill.Dataprefill(db);
        Log.d("inserted", "inserted");

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

                ActiveUser = "";

                Intent Launch = new Intent(LoginActivity.this, SearchActivity.class);
                Launch.setFlags(Launch.FLAG_ACTIVITY_CLEAR_TOP);

                EditText password = (EditText) findViewById(R.id.ETPassword);
                final String Password = password.getText().toString();

                if( checkUsername()) {

                    if (checkPassword(Password)) {
                        startActivity(Launch);
                        finish();
                    }
                }
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

    Boolean checkUsername(){

        EditText username = (EditText) findViewById(R.id.ETUsername);
        final String Username = username.getText().toString();

        Users = getResources().getStringArray(R.array.Users);

        for(int i = 0; i < Users.length; i++)
        {
            if(Username.equals(Users[i])) {
                ActiveUser = Users[i];
                PassNID = i;
                // Toast.makeText(getApplicationContext(), "username Found", Toast.LENGTH_SHORT).show();
                return (true);
            }
        }

        if(ActiveUser.equals(""))
        {
            //Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_SHORT).show();
            return(false);
        }
        return (false);
    }

    boolean checkPassword(String password){

        Passes = getResources().getStringArray(R.array.Passes);

        ActivePassword = Passes[PassNID];

        if(password.equals(ActivePassword))
        {
            //Toast.makeText(getApplicationContext(), "Correct password", Toast.LENGTH_SHORT).show();
            return(true);
        }
        else
        {
            //Toast.makeText(getApplicationContext(), "Incorrect password", Toast.LENGTH_SHORT).show();
            return(false);
        }



    }

}
