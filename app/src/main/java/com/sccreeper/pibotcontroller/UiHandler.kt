//This file generates the UI which is given by the server.
package com.sccreeper.pibotcontroller

import android.R
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray


class UiHandler (view: View, uiTable: TableLayout) {
    val uiVuiew: View;
    val uiTable: TableLayout;

    init {
        this.uiVuiew = view;
        this.uiTable = uiTable;
    }

    fun genUI() {
        var UIJson: String;

        Fuel.post("http://" + MainActivity.IPAddress + "/m/get_ui")
            .jsonBody("{\"t\" : \"${MainActivity.loginToken}\" ")
            .response { request, response, result ->
                if (response.statusCode === 403) {
                    Snackbar.make(this.uiVuiew, "Access denied!", Snackbar.LENGTH_LONG).show()
                } else {
                    UIJson = String(response.data)

                    var UIObj = JSONArray(UIJson);

                    var row = TableRow(uiTable.context);

                    //Keep track of rows
                    var j = 0
                    //Keep track of position in row
                    var h = 0;

                    for (i in 0..(UIObj.length()-1)) {

                        //Switch statement to cycle through UI Elements
                        when(UIObj.getJSONObject(i).get("type")) {
                            "button" -> {
                                val button = Button(uiTable.context);
                                button.id = UIObj.getJSONObject(i).getJSONObject("data").getString("id").toInt();
                                button.text = UIObj.getJSONObject(i).getJSONObject("data").getString("text")
                                button.setOnClickListener {
                                    Command.executeCommand(UIObj.getJSONObject(i).getJSONObject("data").getString("command"))
                                }
                            }
                        }
                    }

                }

            }
    }

    //Use tablerow tag to find it
    private fun parseCommand(cmd: String, index: Int) : String {
        var parsingID = false;
        var currentID = "";

        var finalCommand = cmd;

        for(i in 0..(cmd.length-1)) {
            if(cmd[i] == ']') {
                parsingID = false;

                finalCommand = finalCommand.replace(currentID,  index.toString())

                currentID = ""
            } else if(parsingID) {
                currentID += cmd[i]
            } else if(cmd[i] == '[') {
                parsingID = true;
            }


        }

        return finalCommand
    }


}
