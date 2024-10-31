package com.example.younewskmp.domain

import com.example.younewskmp.data.dto.Article

// cannot use sealed classes with KMP for now.. :/
data class ArticleState(
    val success: List<Article> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)