package com.webakruti.kotlinfirst.retrofit.service

/**
 * Created by DELL on 1/30/2019.
 */
class RestClient {
    private val apiService: ApiService? = null

    /*  RestClient() {
        apiService = new RetrofitUtil().getRetrofitBuilder().create(ApiService.class);
    }*/

    fun getApiService(BASEURL: String): ApiService {

        return RetrofitUtil().getRetrofitBuilder(BASEURL).create(ApiService::class.java)
    }
}