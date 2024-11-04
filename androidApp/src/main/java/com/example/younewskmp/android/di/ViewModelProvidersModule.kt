package com.example.younewskmp.android.di

import com.example.younewskmp.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelProvidersModule = module {
    viewModel { ArticlesViewModel(get()) }
}