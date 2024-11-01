package com.example.younewskmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class ArticleScreenBaseViewModel: ViewModel() {
    actual val scope: CoroutineScope
        get() = viewModelScope
}