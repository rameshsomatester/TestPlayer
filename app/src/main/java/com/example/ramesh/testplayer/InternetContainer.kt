package com.example.ramesh.testplayer

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton

class InternetContainer : AppCompatActivity() {


    protected var uri = "http://www.google.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_container)
        val wv = findViewById(R.id.Wv) as WebView
        // /Loadurl();
        wv.setWebViewClient(WebViewClient())
        wv.settings.javaScriptEnabled = true
        wv.loadUrl(uri)
        val Maps_relative = findViewById(R.id.Map_relative) as ImageButton
        Maps_relative.setOnClickListener {
            //wv.setVisibility(View.GONE);
            val map = Intent(this@InternetContainer, MapsActivity::class.java)
            startActivity(map)
        }

    }

    override fun onBackPressed() {
        super.onCreate(null)
    }
}


