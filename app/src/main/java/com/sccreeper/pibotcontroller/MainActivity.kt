package com.sccreeper.pibotcontroller

//import android.widget.Snackbar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sccreeper.pibotcontroller.util.RequestUtil

//import khttp.post
//import khttp.responses.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Define IP Address stuff
        val botStatus = findViewById<TextView>(R.id.botStatus)
        //val ipSubmitButton = findViewById<Button>(R.id.ipSubmitButton)
        val botIpAddress = findViewById<EditText>(R.id.botIpAddress)
// Control buttons
        val controlLEDOn = findViewById<Button>(R.id.controlHeadlightsOn)
        val controlLEDOff = findViewById<Button>(R.id.controlHeadlightsOff)

        controlLEDOn.setOnClickListener {
            RequestUtil().postRequestControl("/control/headlights/", "{ \"STATUS\" : \"on\" }", botIpAddress.text.toString(), botStatus, it )
        }

        controlLEDOff.setOnClickListener {
            RequestUtil().postRequestControl("/control/headlights/", "{ \"STATUS\" : \"off\" }", botIpAddress.text.toString(), botStatus, it )
        }

       findViewById<Button>(R.id.controlForwards).setOnClickListener {
           RequestUtil().postRequestControl("/control/motor/", "{ \"DIRECTION\" : \"forward\" }", botIpAddress.text.toString(), botStatus, it )
       }
        findViewById<Button>(R.id.controlBackwards).setOnClickListener {
            RequestUtil().postRequestControl("/control/motor/", "{ \"DIRECTION\" : \"backward\" }", botIpAddress.text.toString(), botStatus, it )
        }

        findViewById<Button>(R.id.controlLeft).setOnClickListener {
            RequestUtil().postRequestControl("/control/motor/", "{ \"DIRECTION\" : \"left\" }", botIpAddress.text.toString(), botStatus, it )
        }

        findViewById<Button>(R.id.controlRight).setOnClickListener {
            RequestUtil().postRequestControl("/control/motor/", "{ \"DIRECTION\" : \"right\" }", botIpAddress.text.toString(), botStatus, it )
        }

        findViewById<Button>(R.id.controlStop).setOnClickListener {
            RequestUtil().postRequestControl("/control/motor/", "{ \"DIRECTION\" : \"stop\" }", botIpAddress.text.toString(), botStatus, it )
        }


    }

}