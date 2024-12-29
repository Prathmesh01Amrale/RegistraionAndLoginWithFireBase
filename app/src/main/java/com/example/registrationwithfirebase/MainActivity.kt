package com.example.registrationwithfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ontonext = findViewById<TextView>(R.id.ToSignInPage)
        ontonext.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val signButton = findViewById<Button>(R.id.btnSignup)
        val etName = findViewById<EditText>(R.id.etName)
        val etMail = findViewById<EditText>(R.id.etMail)
        val userId = findViewById<EditText>(R.id.etUserName)
        val etPassword = findViewById<EditText>(R.id.etPassword)


        signButton.setOnClickListener {
            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val uniqueId = userId.text.toString()
            val password = etPassword.text.toString()

            val user = User(name, mail, password, uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {

//                etName.text?.clear()


                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

            }
        }

    }
}