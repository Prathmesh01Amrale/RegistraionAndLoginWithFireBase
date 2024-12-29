package com.example.registrationwithfirebase

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val name = intent.getStringExtra(LoginActivity.KEY2)
        val mail = intent.getStringExtra(LoginActivity.KEY1)
        val UserId = intent.getStringExtra(LoginActivity.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tVWelcome)
        val mailText = findViewById<TextView>(R.id.tvmail)
        val idText = findViewById<TextView>(R.id.tvUniqueId)
        welcomeText.text = "Welcome $name"
        mailText.text = "Mail : $mail"
        idText.text = "Mail : $UserId"


    }
}