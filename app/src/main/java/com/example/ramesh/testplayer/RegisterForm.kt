package com.example.ramesh.testplayer

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * Created by Ramesh on 03-06-2017.
 */

class RegisterForm : AppCompatActivity {
    private val _id: Int = 0
    var userName: String? = null
    var password: String? = null
    private var viewusers: String? = null
    internal lateinit var confirmation: TextView
    internal lateinit var Username: EditText
    internal lateinit var Password: EditText
    internal lateinit var Register: Button
    internal lateinit var agree: CheckBox
    internal lateinit var dbHandler: MyDbHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_form)
        Username = findViewById(R.id.EditUSer) as EditText
        Password = findViewById(R.id.Password) as EditText
        Register = findViewById(R.id.Register_btn) as Button
        confirmation = findViewById(R.id.Confirmation) as TextView
        agree = findViewById(R.id.checkBox) as CheckBox
        dbHandler = MyDbHandler(this,"db", null, 1)
        Register.setOnClickListener {
            val test = RegisterForm(Username.text.toString(), Password.text.toString())
            dbHandler.addUser(test)
            confirmation.text = " Gracious " + Username.text.toString() + " is added successfully to the system"
        }
        Register.setOnLongClickListener {
            viewusers = dbHandler.viewusers()
            if (viewusers.equals(other = null))
                confirmation.text = "Hola no users in database"
            else
                confirmation.text = viewusers
            true
        }

    }

    constructor()

    constructor(userName: String, password: String) {
        this.userName = userName
        this.password = password
    }

    override fun onResume() {
        super.onResume()
    }
}
