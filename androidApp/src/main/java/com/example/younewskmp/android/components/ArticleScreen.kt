package com.example.younewskmp.android.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.younewskmp.articles.ArticlesViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    articleViewModel: ArticlesViewModel = getViewModel<ArticlesViewModel>()
) {
    val articles by articleViewModel.articlesState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState(), enabled = true),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CenterAlignedTopAppBar(title = { Text("YouNews KMP") })
        when {
            (articles?.success.isNullOrEmpty()) -> {
                Text("no data")
            }
            (!articles?.success.isNullOrEmpty()) -> {
                with(articles!!.success) {
                    this.forEach {
                        Spacer(Modifier.height(12.dp))
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null
                            )
                            Text(it.name, style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp))
                            Text(it.content)
                            Text(it.author)
                        }
                        Spacer(Modifier.height(12.dp))
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