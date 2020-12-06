package com.sccreeper.pibotcontroller

//import android.widget.Snackbar

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.sccreeper.pibotcontroller.util.RequestUtil

//import khttp.post
//import khttp.responses.Response


class MainActivity : AppCompatActivity() {
    companion object {
        var botIP = "";
        var loginToken = "";
        var IPAddress = "";
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Define IP Address stuff
        val botStatus = findViewById<TextView>(R.id.botStatus)
        //val ipSubmitButton = findViewById<Button>(R.id.ipSubmitButton)
        val botIpAddress = findViewById<EditText>(R.id.botIpAddress)
// Control buttons


    }

}
