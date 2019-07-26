package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instead of finding ViewById Android now creates a binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //We can now access through binding object
        binding.doneButton.setOnClickListener {
            addNickname(it)// The done button, which was passed as an argument
        }
    }
    private fun addNickname(view: View) {
        //We no longer need variables, we access via binding object
        binding.apply{
            nicknameText.text = nicknameEdit.text
            invalidateAll() //Invalidate all binding expressions so they get recreated with correct data
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE //corresponds to view variable
            nicknameText.visibility = View.VISIBLE
        }

        //Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
