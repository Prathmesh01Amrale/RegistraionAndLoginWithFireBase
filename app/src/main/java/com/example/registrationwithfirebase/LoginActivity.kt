package com.example.registrationwithfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    companion object {
        const val KEY1 = "com.example.registrationwithfirebase.LoginActivity.mail"
        const val KEY2 = "com.example.registrationwithfirebase.LoginActivity.name"
        const val KEY3 = "com.example.registrationwithfirebase.LoginActivity.id"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val ontosignup = findViewById<TextView>(R.id.ToSignUpPage)
        ontosignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val signInButton = findViewById<Button>(R.id.btnSignIn)
        val userName = findViewById<TextInputEditText>(R.id.userNameEditText)

        signInButton.setOnClickListener {
            val userNameString = userName.text.toString()
            if (userNameString.isNotEmpty()) {
                readData(userNameString)
            } else {
                Toast.makeText(this, "Please Enter username", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun readData(uniqueid: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueid).get().addOnSuccessListener {
            // we will check if user is present in database or not
            if (it.exists()) {
                //  welcome user to first page after sign in
                val email = it.child("email").value
                val name = it.child("name").value
                val userId = it.child("uniqueId").value

                // will pass above data to home screen

                val intentWelcome = Intent(this, HomeActivity::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, userId.toString())
                startActivity(intentWelcome)

            } else {
                // tell user your id is not there in the database
                Toast.makeText(this, "User dose not exits", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to connect to database", Toast.LENGTH_SHORT).show()
        }
    }
}