package com.example.letschat

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = email_editText_login.text.toString()
        val password = password_editText_login.text.toString()
//        Firebase.auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
//            if(it.isSuccessful){
//                Toast.makeText(this,"Login successful ",Toast.LENGTH_SHORT).show()
//            }else Log.d("Login","Invalid details ${it.result}")
//        }
    }
}

