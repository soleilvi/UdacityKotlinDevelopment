package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Soleil Vivero")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)  // instead of setContentView

        binding.myName = myName

        /*findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)  // "it" is the Button (view passed as argument)
        }*/
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {
        binding.apply {
            // nicknameText.text = binding.nicknameEdit.text  // sets the text from the input to the text view
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()                                // recreates the rest of the views with the correct data (reset button)
            nicknameEdit.visibility = View.GONE            // Removes the text from the input
            doneButton.visibility = View.GONE              // Changes button visibility to "gone"
            nicknameText.visibility = View.VISIBLE         // Changes its visibility from "gone" to "visible"
        }

        // Hide the keyboard after you press done
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}