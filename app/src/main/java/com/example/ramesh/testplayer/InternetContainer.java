package com.example.ramesh.testplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

public class InternetContainer extends AppCompatActivity {


    protected String uri ="http://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_container);
        final WebView wv =(WebView) findViewById(R.id.Wv);
           // /Loadurl();
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(uri);
        ImageButton Maps_relative= (ImageButton) findViewById(R.id.Map_relative);
        Maps_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wv.setVisibility(View.GONE);
                Intent map = new Intent(InternetContainer.this, MapsActivity.class);
                startActivity(map);
            }
        });

    }
   @Override
    public void onBackPressed(){
       super.onCreate(null);
   }
}


