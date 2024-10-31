package com.example.younewskmp.domain

import com.example.younewskmp.ArticleScreenBaseViewModel
import com.example.younewskmp.data.dto.Article
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: ArticleScreenBaseViewModel() {
    private var _stfArticle = MutableStateFlow<ArticleState?>(ArticleState())
    val articleState = _stfArticle.asStateFlow()

    init {
        getArticle()
    }

    private fun getArticle() {
        scope.launch {
            _stfArticle.value = ArticleState(loading = true)
            delay(5000L)
            _stfArticle.value = ArticleState(listOf(Article()), false, null)
        }
    }
}