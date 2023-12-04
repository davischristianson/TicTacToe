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
    private var count = 0

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
            button.setEnabled(true)
        }
        count = 0
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
        horizontalWin()
        verticalWin()
        diagonalWin()
        if(horizontalWin()) {
            for(button in buttonArray) {
                button.setEnabled(false)
            }
        }
        if(verticalWin()) {
            for(button in buttonArray) {
                button.setEnabled(false)
            }
        }
        if(diagonalWin()) {
            for(button in buttonArray) {
                button.setEnabled(false)
            }
        }



        count++
        if(!horizontalWin() && !verticalWin() && !diagonalWin() && count >= 9) {
            status.setText("It's a Tie!")
        }
    }


    fun horizontalWin(): Boolean {
        val status = findViewById<TextView>(R.id.tvDisplay)
        getButtonArray()
        // If X gets a win
        if (buttonArray[0].text == "X"
            && buttonArray[1].text == "X"
            && buttonArray[2].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        if (buttonArray[3].text == "X"
            && buttonArray[4].text == "X"
            && buttonArray[5].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        if (buttonArray[6].text == "X"
            && buttonArray[7].text == "X"
            && buttonArray[8].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        // If O gets a win
        if (buttonArray[0].text == "O"
            && buttonArray[1].text == "O"
            && buttonArray[2].text == "O") {
            status.text = "Player O Wins!"
            return true
        }
        if (buttonArray[3].text == "O"
            && buttonArray[4].text == "O"
            && buttonArray[5].text == "O") {
            status.text = "Player O Wins!"
            return true
        }
        if (buttonArray[6].text == "O"
            && buttonArray[7].text == "O"
            && buttonArray[8].text == "O") {
            status.text = "Player O Wins!"
            return true
        }
        return false
    }

    fun verticalWin(): Boolean {
        val status = findViewById<TextView>(R.id.tvDisplay)
        getButtonArray()
        // If X gets a win
        if (buttonArray[0].text == "X"
            && buttonArray[3].text == "X"
            && buttonArray[6].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        if (buttonArray[1].text == "X"
            && buttonArray[4].text == "X"
            && buttonArray[7].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        if (buttonArray[2].text == "X"
            && buttonArray[5].text == "X"
            && buttonArray[8].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        // If O gets a win
        if (buttonArray[0].text == "O"
            && buttonArray[3].text == "O"
            && buttonArray[6].text == "O") {
            status.text = "Player O Wins!"
            return true
        }
        if (buttonArray[1].text == "O"
            && buttonArray[4].text == "O"
            && buttonArray[7].text == "O") {
            status.text = "Player O Wins!"
            return true
        }
        if (buttonArray[2].text == "O"
            && buttonArray[5].text == "O"
            && buttonArray[8].text == "O") {
            status.text = "Player O Wins!"
            return true
        }

        return false
    }

    fun diagonalWin(): Boolean {
        val status = findViewById<TextView>(R.id.tvDisplay)
        getButtonArray()
        // If X gets a win
        if (buttonArray[0].text == "X"
            && buttonArray[4].text == "X"
            && buttonArray[8].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        if (buttonArray[2].text == "X"
            && buttonArray[4].text == "X"
            && buttonArray[6].text == "X") {
            status.text = "Player X Wins!"
            return true
        }
        // If O gets a win
        if (buttonArray[0].text == "O"
            && buttonArray[4].text == "O"
            && buttonArray[8].text == "O") {
            status.text = "Player O Wins!"
            return true
        }
        if (buttonArray[2].text == "O"
            && buttonArray[4].text == "O"
            && buttonArray[6].text == "O") {
            status.text = "Player O Wins!"
            return true
        }

        return false
    }
}