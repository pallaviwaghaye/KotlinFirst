package com.webakruti.kotlinfirst.retrofit.service

import com.webakruti.kotlinfirst.retrofit.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by DELL on 1/30/2019.
 */
class RetrofitUtil {
   // ((YourActivity)getActivity).foo();
    val BASE_URL = ApiConstants().BASE_URL
    //val BASE_URL = ApiConstants.BASE_URL
    val READ_TIMEOUT: Long = 1
    val CONNECT_TIMEOUT: Long = 1

   //get okHttpclient object after adding headers

    fun getClient(BASE_URL: String): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        // Add the interceptor to OkHttpClient
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(logging)
        builder.readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MINUTES)

        return builder.build()
    }

     //get retrofit object

    fun getRetrofitBuilder(BASE_URL: String): Retrofit {


        return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(BASE_URL))
                .build()
    }

}