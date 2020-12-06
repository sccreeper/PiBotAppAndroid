package com.sccreeper.pibotcontroller

import android.widget.TableLayout
import android.widget.TableRow
import androidx.core.view.get

class Command {

    companion object {
        fun executeCommand(command: String, table: TableLayout) {

        }
    }

    private fun parseCommand(cmd: String, table: TableLayout) : String {
        var parsingID = false;
        var currentID = "";

        var finalCommand = cmd;

        for(i in 0..(cmd.length-1)) {
            if(cmd[i] == ']') {
                parsingID = false;

                var (rowPosH, rowPosV) = currentID.split(':').toTypedArray();

                finalCommand = finalCommand.replace(currentID,  )

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
