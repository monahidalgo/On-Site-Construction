package com.example.constructionsite

data class ConstructionItem(
    val id: Int,
    val name: String,
    val description: String,
    val quantity: Int,
    val imageResourceId: String
) {
    val imageName: String
        get() = "Image_$id"
}

