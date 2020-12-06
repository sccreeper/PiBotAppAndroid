package com.sccreeper.pibotcontroller.util

import android.view.View
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.google.android.material.snackbar.Snackbar

class RequestUtil {
    fun postRequestControl(path: String, body: String, ipAddress: String, statusDisplay: TextView, view: View) {
        if (ipAddress.matches(Regex("^\$"))) {
            val errorSnackbar =
                Snackbar.make(view, "Make sure you enter a  IP address!", Snackbar.LENGTH_LONG)
            errorSnackbar.show()
        } else {
            Fuel.post("http://" + ipAddress + ":5000" + path)
                .jsonBody(body)
                .response { request, response, result ->
                    statusDisplay.text = String(response.data)
                }

        }
    }
}