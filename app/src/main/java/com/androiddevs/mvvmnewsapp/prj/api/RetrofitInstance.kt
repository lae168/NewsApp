package com.androiddevs.mvvmnewsapp.prj.api

import com.androiddevs.mvvmnewsapp.prj.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{

//        lazy means initializing things that were put in scope
            private val retrofit by lazy {


            val logging = HttpLoggingInterceptor()

//       Sets the level and returns this
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

//with OkHttp, we can make HTTP request then get response from server...
// then with Gson lib convert response to object we need
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)

//               parse HTTP response into an obj in java that can be used in codes
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
}
//        api that will be able to use everywhere to make actual network requests
        val api by lazy{
            retrofit.create(NewsAPI::class.java)
        }
    }
}