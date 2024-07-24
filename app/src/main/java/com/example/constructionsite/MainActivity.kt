package com.example.constructionsite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val usernameEditText = findViewById<EditText>(R.id.username_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)
        val loginButton = findViewById<Button>(R.id.login_button)

        // Set up click listener for login button
        loginButton.setOnClickListener {
            // Get user input
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate user input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter a Username and password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Perform login
            if (username == "admin" && password == "password") { // Replace with your own login logic
                val intent = Intent(this, ConstructionItemListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_LONG).show()
            }
        }
    }
}