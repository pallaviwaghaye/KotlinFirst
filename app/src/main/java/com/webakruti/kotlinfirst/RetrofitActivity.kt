package com.webakruti.kotlinfirst

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.webakruti.kotlinfirst.R.id.recyclerView
import com.webakruti.kotlinfirst.adapter.RecyclerAdapter
import com.webakruti.kotlinfirst.adapter.UserAdapter
import com.webakruti.kotlinfirst.model.User
import com.webakruti.kotlinfirst.retrofit.ApiConstants
import com.webakruti.kotlinfirst.retrofit.service.ApiService
import com.webakruti.kotlinfirst.retrofit.service.RestClient
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    private var progressDialogForAPI: ProgressDialog? = null
    var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack) as ImageView
        imageViewBack.setOnClickListener {
            val intent1 = Intent(this@RetrofitActivity, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
       // var textViewNoData = findViewById<TextView>(R.id.textViewNoData)
        //getUsers()
        callUsersAPI()
        /*if (NetworkUtil.hasConnectivity(this@RetrofitActivity)) {
            callMyenquiryAPI()
        } else {
            //Toast.makeText(MyEnquiryActivity.this, R.string.no_internet_message, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder(this@RetrofitActivity)
                    .setMessage("No Internet !!")
                    .setPositiveButton("OK", null)
                    .show()
        }*/
    }

    //API parsing using direct retrofit (manual parsing)

   /* fun getUsers() {

        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants().BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var api = retrofit.create(ApiService::class.java)

        var call = api.getUsers()

        call.enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                var usres = response?.body()
               // var user = List<usres>
               // var length = user!!.size

                val layoutManager = LinearLayoutManager(this@RetrofitActivity, LinearLayoutManager.VERTICAL, false)
                recyclerView?.setLayoutManager(layoutManager)
                recyclerView?.setAdapter(UserAdapter(applicationContext, usres!!))
            }

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                Log.v("Error", t.toString())
            }
        })
    }*/


    private fun callUsersAPI() {

        progressDialogForAPI = ProgressDialog(this@RetrofitActivity)
        progressDialogForAPI!!.setCancelable(false)
        progressDialogForAPI!!.setIndeterminate(true)
        progressDialogForAPI!!.setMessage("Please wait...")
        progressDialogForAPI!!.show()


        val requestCallback = RestClient().getApiService(ApiConstants().BASE_URL).getUsers()
        requestCallback.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    var users = response?.body()

                    if (users != null) {

                        //handleStationPlatformData(details);
                        textViewNoData.setVisibility(View.GONE)
                        recyclerView!!.setVisibility(View.VISIBLE)

                        val layoutManager = LinearLayoutManager(this@RetrofitActivity, LinearLayoutManager.VERTICAL, false)
                        recyclerView?.setLayoutManager(layoutManager)
                        recyclerView?.setAdapter(UserAdapter(applicationContext, users!!))
                    } else {
                        textViewNoData.setVisibility(View.VISIBLE)
                        recyclerView?.setVisibility(View.GONE)
                    }

                } else {
                    // Response code is 401
                }

                if (progressDialogForAPI != null) {
                    progressDialogForAPI!!.cancel()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                if (t != null) {

                    if (progressDialogForAPI != null) {
                        progressDialogForAPI!!.cancel()
                    }
                    if (t.message != null)
                        Log.e("error", t.message)
                }

            }
        })


    }


}
