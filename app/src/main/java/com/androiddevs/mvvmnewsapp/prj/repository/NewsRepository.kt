package com.androiddevs.mvvmnewsapp.prj.repository

import com.androiddevs.mvvmnewsapp.prj.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.prj.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.prj.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String,pageNumber : Int)=
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery :String ,pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun insert(article:Article)  = db.getArticleDao().insert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticles(article)

}