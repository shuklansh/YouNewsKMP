package com.example.younewskmp.domain

import com.example.younewskmp.ArticleScreenBaseViewModel
import com.example.younewskmp.data.dto.Article
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: ArticleScreenBaseViewModel() {
    private var _stfArticle:MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val articlesState: StateFlow<ArticleState> get() = _stfArticle

    init {
        getArticle()
    }

    private fun getArticle() {
        scope.launch {
            delay(5000L)
            _stfArticle.emit(ArticleState(listOf(
                Article("Article headline 1"),
                Article("Article headline 2"),
                Article("Article headline 3"),
                Article("Article headline 4"),
                Article("Article headline 5"),
                Article("Article headline 6"),
            ), false, null))
        }
    }
}