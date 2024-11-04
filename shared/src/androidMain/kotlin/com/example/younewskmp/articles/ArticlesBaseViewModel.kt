package com.example.younewskmp.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class ArticlesBaseViewModel: ViewModel() {
    actual val scope: CoroutineScope
        get() = viewModelScope
}