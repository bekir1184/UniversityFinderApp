package com.beko.universityfinderapp.api

import com.beko.universityfinderapp.model.University
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getUniCountry(
        @Query("country") country : String
    ):Call<MutableList<University>>

    @GET("search")
    fun getUniName(
        @Query("name") name : String
    ):Call<MutableList<University>>
}