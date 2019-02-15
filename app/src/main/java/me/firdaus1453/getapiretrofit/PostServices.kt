package me.firdaus1453.getapiretrofit

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by firdaus1453 on 2/13/2019.
 */
interface PostServices {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}