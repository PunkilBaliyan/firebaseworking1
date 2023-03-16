package com.example.firebaseuse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val loginEmail = findViewById<EditText>(R.id.loginEmail)
        val loginPassword = findViewById<EditText>(R.id.loginPassword)
        val buttonLogin = findViewById<Button>(R.id.button2)
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        fun pass():String{
            return loginPassword.text.toString()
        }
        buttonLogin.setOnClickListener{
            val emailText = loginEmail.text.toString()
            val passwordText = loginPassword.text.toString()


            if(TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)){
                Toast.makeText(this, "Credentials can't be empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener{
                 if(it.isSuccessful){
                     val intent = Intent(this, home::class.java)
                     startActivity(intent)
                     finish()
                 }else{
                     Toast.makeText(this, it.exception?.message, Toast.LENGTH_LONG).show()
                 }
            }
        }
    }
}