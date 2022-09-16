package edu.qc.seclass.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import edu.qc.seclass.wordle.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tries = 0
        val button = findViewById<Button>(R.id.guessButton)
        val textView7 = findViewById<TextView>(R.id.myTextView7)
        val textView8 = findViewById<TextView>(R.id.myTextView8)
        val textView9 = findViewById<TextView>(R.id.myTextView9)
        val textView10 = findViewById<TextView>(R.id.myTextView10)
        val textView11 = findViewById<TextView>(R.id.myTextView11)
        val textView12 = findViewById<TextView>(R.id.myTextView12)
        val answerTextView = findViewById<TextView>(R.id.answerTextView)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val wordToGuess = getRandomFourLetterWord();

        answerTextView.visibility = View.GONE
        textView7.visibility = View.GONE
        textView8.visibility = View.GONE
        textView9.visibility = View.GONE
        textView10.visibility = View.GONE
        textView11.visibility = View.GONE
        textView12.visibility = View.GONE
        answerTextView.text = wordToGuess

        fun checkGuess(guess: String): String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                } else if (guess[i] in wordToGuess) {
                    result += "+"
                } else {
                    result += "X"
                }
            }
            return result
        }

        button.setOnClickListener {

            if (tries == 0) {
                // display their guess on assigned TextView
                val guess1: String = editText1.text.toString().uppercase()
                textView7.text = guess1
                //check guess with wordToGuess
                var result1 = checkGuess(guess1)
                textView8.text = result1
                textView7.visibility = View.VISIBLE
                textView8.visibility = View.VISIBLE
                tries++
            } else if (tries == 1) {
                val guess2: String = editText1.text.toString().uppercase()
                textView9.text = guess2
                var result2 = checkGuess(guess2)
                textView10.text = result2
                textView9.visibility = View.VISIBLE
                textView10.visibility = View.VISIBLE
                tries++
            } else if (tries == 2) {
                val guess3: String = editText1.text.toString().uppercase()
                textView11.text = guess3
                var result3 = checkGuess(guess3)
                textView12.text = result3
                textView11.visibility = View.VISIBLE
                textView12.visibility = View.VISIBLE
                tries++
            } else if (tries == 3) {
                answerTextView.visibility = View.VISIBLE
                Toast.makeText(it.context, "Sorry, you ran out of tries :P !", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }
}