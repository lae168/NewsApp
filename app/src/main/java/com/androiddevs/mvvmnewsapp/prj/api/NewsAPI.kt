package com.androiddevs.mvvmnewsapp.prj.api

import com.androiddevs.mvvmnewsapp.prj.models.NewsResponse
import com.androiddevs.mvvmnewsapp.prj.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String,
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        countryCode:String,
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsResponse>
}