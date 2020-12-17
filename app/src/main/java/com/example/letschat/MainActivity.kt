package com.example.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()        // remove actionBar from register activity

        var email:String = email_editText_register.text.toString()
        var password = password_editText_register.text.toString()
        var name = username_editText_register.text.toString()
        var registerButton = register_button_register

        registerButton.setOnClickListener {
            Log.d("MainActivity","Email is : $email")
            Log.d("MainActivity","Password is : $password")
            Log.d("MainActivity","Username is: $name")
            if(email.isEmpty() || password.isEmpty() || name.isEmpty()){
                Toast.makeText(this,"enter valid details",Toast.LENGTH_SHORT).show()

            }  // if email or password is empty just return clicklistener else app crashes
            else{
                performRegistration(email,password)
            }
        }

        already_have_account_textView_register.setOnClickListener {
            Log.d("MainActivity" , "Go to login activity")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private  fun performRegistration(email:String,  password:String){
        /* function to perform new user registration */

        //Firebase authentication to create user with email and password
        val auth = FirebaseAuth.getInstance()

        auth?.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(!it.isSuccessful)    return@addOnCompleteListener
                    // else if authentication is successful
                    else Log.d("Main","New user created with uid: ${it.result?.user?.uid}")
                }
                .addOnFailureListener {
                    Log.d("Main","User registration failed : ${it.message}")
                }
    }
}