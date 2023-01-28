package com.example.hindiletters.canvas


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import io.ak1.drawbox.DrawBox
import io.ak1.drawbox.rememberDrawController

@Composable
fun CanvasDraw(navController: NavController) {
    val controller = rememberDrawController()
Column() {
    DrawBox(drawController = controller, modifier = Modifier
        .fillMaxSize()
        .weight(1f, true))
    Row() {
        Button(onClick = { controller.unDo() }) {
            Text(text = "undo")
        }
        Button(onClick = { controller.reDo() }) {
            Text(text = "redo")
        }
        Button(onClick = { controller.setStrokeColor( Color.Blue) }) {
            Text(text = "color")
        }
        Button(onClick = { controller.reset() }) {
            Text(text = "reset")
        }
        Button(onClick = { controller.getDrawBoxBitmap()}) {
            Text(text = "result")
        }


    }


}

}