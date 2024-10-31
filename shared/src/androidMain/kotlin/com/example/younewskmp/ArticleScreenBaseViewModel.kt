package com.example.younewskmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope

@HiltViewModel
actual open class ArticleScreenBaseViewModel: ViewModel() {
    actual val scope: CoroutineScope
        get() = viewModelScope
}