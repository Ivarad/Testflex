package com.example.getpostflex

import com.example.getpostflex.Models.Flex
import com.example.getpostflex.Models.UrlImageModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import javax.security.auth.callback.Callback

interface ApiInterface {
    @GET("top-headlines?country=us&apiKey=bc62f7ad76fb4ac6b5f4542b18ad8507")
    fun getFile(): Call<UrlImageModel>


    @POST("/posts")
    @FormUrlEncoded
    fun getPost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Int
    ): Call<Flex>
}
