package com.example.younewskmp.articles.di

import com.example.younewskmp.di.networkModule

val sharedKoinModule = listOf( // add module per feature
    articlesModule,
    networkModule
)