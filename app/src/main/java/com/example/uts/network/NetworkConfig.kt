package com.example.uts.network

import com.example.uts.Model.ResponseMatkul
import com.example.uts.Model.ResponseMatkulItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class NetworkConfig {
    // set interceptor
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost/slim-uts/public/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Matkul::class.java)
}
interface Matkul {
    @GET("matkul")
    fun getMatkul(): Call<List<ResponseMatkulItem>>

    @POST("/api/progmob/matkul/create")
    fun addMatkul(@Body req : ResponseMatkulItem) : Call<ResponseMatkul>
}