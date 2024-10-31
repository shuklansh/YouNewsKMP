package com.example.younewskmp.android.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.younewskmp.domain.ArticlesViewModel

@Composable
fun ArticleScreen(
    articleViewModel: ArticlesViewModel
) {
    val articles by articleViewModel.articleState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            (articles?.success.isNullOrEmpty()) -> {
                Text("no data")
            }
            (!articles?.success.isNullOrEmpty()) -> {
                with(articles!!.success) {
                    this.forEach {
                        Text(it.name)
                        Text(it.content)
                        Text(it.author)
                    }
                }
            }
            (articles?.loading == true) -> {
                CircularProgressIndicator()
            }
            (!articles?.error.isNullOrEmpty()) -> {
                Text("ERROR!")
            }
        }
    }
}