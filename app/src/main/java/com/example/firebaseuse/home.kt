package com.example.firebaseuse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val signOut = findViewById<Button>(R.id.signOut)
        val auth = FirebaseAuth.getInstance()
        signOut.setOnClickListener{
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        val key = findViewById<TextView>(R.id.key)
        val valueText = findViewById<TextView>(R.id.value)
        val save = findViewById<Button>(R.id.save)
        val data = FirebaseDatabase.getInstance("https://fir-working-9c2ee-default-rtdb.asia-southeast1.firebasedatabase.app")
        save.setOnClickListener{

            data.reference.child(key.text.toString()).setValue(valueText.text.toString()).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "Data is saved succesfully", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "something went wrong", Toast.LENGTH_LONG).show()
                }
            }

        }
        val viewDataButton : Button = findViewById(R.id.viewData)
         viewDataButton.setOnClickListener{
             val intent = Intent(this , ListView::class.java)
             startActivity(intent)
         }

    }
}