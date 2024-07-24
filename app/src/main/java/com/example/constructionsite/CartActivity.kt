package com.example.constructionsite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Example usage of ConstructionItem
        val constructionItem = ConstructionItem(
            id = 1,
            name = "Cement",
            description = "High-quality cement for construction",
            quantity = 50,
            imageResourceId = R.drawable.site.toString()
        // Ensure this is a valid drawable resource ID
        )

        // Use constructionItem as needed
    }
}
