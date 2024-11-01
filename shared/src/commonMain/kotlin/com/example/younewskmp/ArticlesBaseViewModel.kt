package com.example.younewskmp

import kotlinx.coroutines.CoroutineScope

expect open class ArticlesBaseViewModel() {
    val scope: CoroutineScope
}