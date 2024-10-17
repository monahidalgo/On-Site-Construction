package com.example.constructionsite

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.constructionsite.databinding.ActivityCreateAccountBinding
import com.example.constructionsite.databinding.ActivityCreateAccountBinding.inflate


class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        class LoginActivity : AppCompatActivity() {

            private lateinit var createAccountTextView: TextView

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_login)

                createAccountTextView = findViewById(R.id.create_account_text_view)

                createAccountTextView.setOnClickListener {
                    val intent = Intent(this, CreateAccountActivity::class.java)
                    startActivity(intent)
                }
            }
        }




        binding.backArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        // Removed avatarImageView click listener and related code
    }
}