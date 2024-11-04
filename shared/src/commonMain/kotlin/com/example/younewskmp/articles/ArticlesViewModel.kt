package com.example.younewskmp.articles

import com.example.younewskmp.articles.data.network.ArticlesApiClient
import com.example.younewskmp.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
): ArticlesBaseViewModel() {
    private var _stfArticle:MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val articlesState: StateFlow<ArticleState> get() = _stfArticle

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = useCase.getArticles()
            _stfArticle.emit(ArticleState(success = fetchedArticles))
        }
    }
}