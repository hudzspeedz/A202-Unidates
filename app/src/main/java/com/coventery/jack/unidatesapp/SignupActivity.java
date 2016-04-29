/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 */
package com.coventery.jack.unidatesapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.Users;


public class SignupActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       final DatabaseHandler db = new DatabaseHandler(this);

        Button submit = (Button)findViewById(R.id.BEnterDetails);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText Username = (EditText) findViewById(R.id.ETSUUsername);
                EditText Password = (EditText) findViewById(R.id.ETSUPassword);
                EditText Firstname = (EditText) findViewById(R.id.ETSUFirstname);
                EditText Surname = (EditText) findViewById(R.id.ETSULastname);
                EditText Age = (EditText) findViewById(R.id.ETSUAge);
                EditText University = (EditText) findViewById(R.id.ETSUUNI);
                EditText Image1 = (EditText) findViewById(R.id.ETSUImg1);
                EditText Image2 = (EditText) findViewById(R.id.ETSUImg2);
                EditText Image3 = (EditText) findViewById(R.id.ETSUImg3);

                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String firstname = Firstname.getText().toString();
                String surname = Surname.getText().toString();
                String age = Age.getText().toString();
                String university = University.getText().toString();
                String img1 = Image1.getText().toString();
                String img2 = Image2.getText().toString();
                String img3 = Image3.getText().toString();

                db.addUser(new Users(username, password, firstname, surname, age, university,
                        img1,
                        img2,
                        img3));
            }
        });



    }

}