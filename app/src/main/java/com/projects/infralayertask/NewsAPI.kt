package com.projects.infralayertask


import retrofit2.Call
import retrofit2.http.GET

internal interface NewsAPI {
    @get:GET("/rss.xml")
    val news: Call<Responsee>
}