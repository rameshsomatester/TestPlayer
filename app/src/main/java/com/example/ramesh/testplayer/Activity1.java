package com.example.ramesh.testplayer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Browser;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.string.yes;
import static android.content.Intent.ACTION_CALL;

public class Activity1 extends AppCompatActivity {
    private TextView disappear;


    private Button onclick, OnclickInternet,onclickRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Disappear();
    }

    protected void onResume(Bundle savedInstanceState){
        super.onResume();
        setContentView(R.layout.activity_1);
        Disappear();
    }

    private void Disappear() {
        disappear = (TextView) findViewById(R.id.TV_ACT1);
        onclick = (Button) findViewById(R.id.Btn_1);
        OnclickInternet = (Button) findViewById(R.id.Btn_2);
        onclickRegister=(Button) findViewById(R.id.Register_btn_home);
        onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Activity1.this, MapsActivity.class);
                startActivity(map);
            }
        });
        OnclickInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internet = new Intent(Activity1.this, InternetContainer.class);
                startActivity(internet);
            }
        });
        onclickRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(Activity1.this, RegisterForm.class);
                startActivity(register);
            }
        });

    }
}

