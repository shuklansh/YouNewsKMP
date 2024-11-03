package com.example.younewskmp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesApiClient(private val httpClient: HttpClient) {

    private val country = "in"
    private val category = "technology"
    private val apiKey = "YOUR API KEY"
    private val baseUrl = "https://newsapi.org/v2/"
    private val headlineBaseUrl = "${baseUrl}top-headlines?country=$country&category=$category&apiKey=$apiKey"
    private val everythingBaseUrl = "${baseUrl}everything?q=$category&apiKey=$apiKey"

    suspend fun fetchArticles(): List<ArticlesRaw> {
        val response: ArticleResponse = httpClient.get(everythingBaseUrl).body()
        return response.articles.orEmpty()
    }
}