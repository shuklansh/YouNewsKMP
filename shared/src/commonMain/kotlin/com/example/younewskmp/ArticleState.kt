package com.example.younewskmp

// cannot use sealed classes with KMP for now.. :/
data class ArticleState(
    val success: List<Article> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)