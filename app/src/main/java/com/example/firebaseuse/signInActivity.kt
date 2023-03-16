package com.example.firebaseuse


import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class signInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.editTextTextPassword)
        val confirmPassword: EditText = findViewById(R.id.editTextTextPassword2)
        val signUP: Button = findViewById(R.id.button)

        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        signUP.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            val confirmPasswordText = confirmPassword.text.toString()

            if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(
                    confirmPasswordText
                )
            ) {
                Toast.makeText(this, "Credentials can't be empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (passwordText.length < 6) {
                Toast.makeText(this, "Password length should be greater than 6", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            if (passwordText != confirmPasswordText) {
                Toast.makeText(
                    this,
                    "New password and confirm password should be same",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener { login ->
                    if (login.isSuccessful) {
                        Toast.makeText(this, "Registerd succesfully!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            this,
                            "something went wrong! " + login.exception?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

        }
    }
}