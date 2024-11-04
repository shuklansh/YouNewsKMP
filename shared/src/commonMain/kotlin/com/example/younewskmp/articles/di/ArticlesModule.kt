package com.example.younewskmp.articles.di

import com.example.younewskmp.articles.ArticlesViewModel
import com.example.younewskmp.articles.data.network.ArticlesApiClient
import com.example.younewskmp.articles.domain.ArticlesUseCase
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesApiClient> { // single -> Singleton
        ArticlesApiClient(
            get()
        )
    }
    single<ArticlesUseCase> {
        ArticlesUseCase(
            get()
        )
    }
    single<ArticlesViewModel> { // only for ios viewModel
        ArticlesViewModel(get())
    }
}