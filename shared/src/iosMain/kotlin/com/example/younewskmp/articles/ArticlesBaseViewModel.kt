package com.example.younewskmp.articles

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class ArticlesBaseViewModel {

    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        // since ios does not have lifecycle aware vm like Android ViewModel()
        // we need to call clear() explicitly
        scope.cancel()
    }
}