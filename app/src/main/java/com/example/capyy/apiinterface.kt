package com.example.capyy
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface apiinterface{
    @GET("tips")
    fun getData(): Call<tips>

   @POST("characters")
   fun getplayer(@Body requestModel: p): Call<players>

    @GET("scores")
    fun getscore(): Call<score>

    @GET("/word?length=3")
    fun getword(): Call<word>


}