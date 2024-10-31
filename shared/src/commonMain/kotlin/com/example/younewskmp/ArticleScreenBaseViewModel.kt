package com.example.younewskmp

import kotlinx.coroutines.CoroutineScope

expect open class ArticleScreenBaseViewModel() {
// open -> not final (other classes are free to extend its behaviour
    val scope: CoroutineScope
}