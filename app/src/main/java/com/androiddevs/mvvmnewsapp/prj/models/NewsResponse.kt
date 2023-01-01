package com.androiddevs.mvvmnewsapp.prj.models

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)