package me.firdaus1453.getapiretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by firdaus1453 on 2/13/2019.
 */
object DataRepository {
    fun create(): PostServices{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        return retrofit.create(PostServices::class.java)
    }
}