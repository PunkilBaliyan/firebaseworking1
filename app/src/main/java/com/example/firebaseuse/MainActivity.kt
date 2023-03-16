package com.example.firebaseuse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginmain = findViewById<Button>(R.id.loginMain)
        val signUpMain = findViewById<Button>(R.id.signUpMain)
        val auth = FirebaseAuth.getInstance()

        if(auth.currentUser != null){
            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()
        }
        loginmain.setOnClickListener{
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }
        signUpMain.setOnClickListener{
            val intent = Intent(this, signInActivity::class.java)
            startActivity(intent)

        }


    }
}