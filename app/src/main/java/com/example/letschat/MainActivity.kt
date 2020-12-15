package com.example.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = email_editText_register.text.toString()
        val password = password_editText_register.text.toString()

        val registerButton = register_button_register
        registerButton.setOnClickListener {
            Log.d("MainActivity","Email is : $email")
            Log.d("MainActivity","Password is : $password")
        }

        already_have_account_textView_register.setOnClickListener {
            Log.d("MainActivity" , "Go to login activity")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
    }
}