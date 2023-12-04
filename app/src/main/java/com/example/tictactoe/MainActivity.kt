package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var buttonArray = emptyArray<Button>()
    private var playerOne = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newGame(getButtonArray())
    }

    private fun getButtonArray(): Array<Button> {
        val btnTopLeft = findViewById<Button>(R.id.btnTopLeft)
        val btnTopMid = findViewById<Button>(R.id.btnTopMid)
        val btnTopRight = findViewById<Button>(R.id.btnTopRight)
        val btnMidLeft = findViewById<Button>(R.id.btnMidLeft)
        val btnMiddle = findViewById<Button>(R.id.btnMiddle)
        val btnMidRight = findViewById<Button>(R.id.btnMidRight)
        val btnBotLeft = findViewById<Button>(R.id.btnBotLeft)
        val btnBotMid = findViewById<Button>(R.id.btnBotMid)
        val btnBotRight = findViewById<Button>(R.id.btnBotRight)

        buttonArray = arrayOf(
            btnTopLeft, btnTopMid, btnTopRight,
            btnMidLeft, btnMiddle, btnMidRight,
            btnBotLeft, btnBotMid, btnBotRight
        )

        return buttonArray
    }

    private fun newGame(buttonArray : Array<Button>) {
        val status = findViewById<TextView>(R.id.tvDisplay)
        for(button in buttonArray) {
            button.setText("")
        }
        status.text = "Player X's turn!"

        playerOne = true
    }

    fun resetGame(view : View) {
        newGame(getButtonArray())
    }

    fun ticTacToeClick(view : View) {
        val btnClicked = view as Button
        fillBtn(btnClicked)
    }

    fun fillBtn(btnClicked : Button) {
        val status = findViewById<TextView>(R.id.tvDisplay)
        if(btnClicked.text.equals("")) {
            if(playerOne) {
                btnClicked.text = "X"
                status.text = "Player O's turn!"
                playerOne = false
            }
            else {
                btnClicked.text = "O"
                status.text = "Player X's turn!"
                playerOne = true
            }
        }
    }


    fun horizontalWin() {

    }

    fun verticalWin() {

    }

    fun diagonalWin() {

    }
}