package com.example.younewskmp.articles

import kotlinx.coroutines.CoroutineScope

expect open class ArticlesBaseViewModel() {
    val scope: CoroutineScope
}