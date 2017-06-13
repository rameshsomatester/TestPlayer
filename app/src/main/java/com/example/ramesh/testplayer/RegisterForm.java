package com.example.ramesh.testplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ramesh on 03-06-2017.
 */

public class RegisterForm extends AppCompatActivity {
    private int _id;
    private String UserName;
    private String password;
    private String viewusers;
    TextView confirmation;
    EditText Username,Password;
    Button Register;
    CheckBox agree;
    MyDbHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);
        Username = (EditText) findViewById(R.id.EditUSer);
        Password = (EditText) findViewById(R.id.Password);
        Register = (Button) findViewById(R.id.Register_btn);
        confirmation = (TextView) findViewById(R.id.Confirmation);
        agree = (CheckBox) findViewById(R.id.checkBox);
        dbHandler = new MyDbHandler(this, null, null, 1);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterForm test = new RegisterForm(Username.getText().toString(), Password.getText().toString());
                dbHandler.addUser(test);
                confirmation.setText(" Gracious " + Username.getText().toString() + " is added successfully to the system");
            }
        });
        Register.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                viewusers = dbHandler.viewusers();
                confirmation.setText(viewusers);
                return true;
            }

        });

    }
    public RegisterForm(){

    }

    public RegisterForm(String userName, String password) {
        UserName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
