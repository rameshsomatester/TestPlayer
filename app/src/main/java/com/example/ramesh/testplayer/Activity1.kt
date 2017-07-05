package com.example.ramesh.testplayer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Browser
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

import android.R.string.yes
import android.content.Intent.ACTION_CALL

class Activity1 : AppCompatActivity() {
    private var disappear: TextView? = null


    private var onclick: Button? = null
    private var OnclickInternet: Button? = null
    private var onclickRegister: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        Disappear()
    }

    protected fun onResume(savedInstanceState: Bundle) {
        super.onResume()
        setContentView(R.layout.activity_1)
        Disappear()
    }

    private fun Disappear() {
        disappear = findViewById(R.id.TV_ACT1) as TextView
        onclick = findViewById(R.id.Btn_1) as Button
        OnclickInternet = findViewById(R.id.Btn_2) as Button
        onclickRegister = findViewById(R.id.Register_btn_home) as Button
        onclick!!.setOnClickListener {
            val map = Intent(this@Activity1, MapsActivity::class.java)
            startActivity(map)
        }
        OnclickInternet!!.setOnClickListener {
            val internet = Intent(this@Activity1, InternetContainer::class.java)
            startActivity(internet)
        }
        onclickRegister!!.setOnClickListener {
            val register = Intent(this@Activity1, RegisterForm::class.java)
            startActivity(register)
        }

    }
}

