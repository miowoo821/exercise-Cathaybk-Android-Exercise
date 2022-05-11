package com.tpower.cathaybk.net

import android.os.Build
import com.tpower.cathaybk.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/* Created on 2022/5/10 */

object RetrofitManager {

    val service: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        getRetrofit().create(ApiService::class.java)
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .addInterceptor(addQueryParameterInterceptor())
            .addInterceptor(addHeaderInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                // Provide your custom parameter here
//                .addQueryParameter("udid", "d2807c895f0348a180148c9dfa6f2feeac0781b5")
//                .addQueryParameter("deviceModel", Build.MODEL)
                .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }


    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                // Provide your custom header here
                .header("token", "")
                .method(originalRequest.method(), originalRequest.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

}