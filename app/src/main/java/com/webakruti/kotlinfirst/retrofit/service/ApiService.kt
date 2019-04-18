package com.webakruti.kotlinfirst.retrofit.service

import com.webakruti.kotlinfirst.model.User
import com.webakruti.kotlinfirst.retrofit.ApiConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

/**
 * Created by DELL on 1/30/2019.
 */
interface ApiService {
    /*@GET(ApiConstants.userlist)
    abstract fun getAllPosts() : Observable<List<User>>*/

    /*@GET("posts/")
    fun getAllPosts(): Observable<List<User>>*/

    @GET("posts/")
    fun getUsers(): Call<List<User>>

}