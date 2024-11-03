package com.example.younewskmp

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel(): ArticlesBaseViewModel() {
    private var _stfArticle:MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val articlesState: StateFlow<ArticleState> get() = _stfArticle

    private val useCase: ArticlesUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val service = ArticlesApiClient(httpClient)

        useCase = ArticlesUseCase(service)

        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = useCase.getArticles()
            _stfArticle.emit(ArticleState(success = fetchedArticles))
        }
    }
}