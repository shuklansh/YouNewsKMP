package com.example.younewskmp.articles.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("status")
    val status: String?,
    @SerialName("totalResults")
    val results: Int?,
    @SerialName("articles")
    val articles: List<ArticlesRaw>?
)