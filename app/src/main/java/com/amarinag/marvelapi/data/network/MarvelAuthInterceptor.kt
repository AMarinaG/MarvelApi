package com.amarinag.marvelapi.data.network

import com.amarinag.marvelapi.BuildConfig
import com.amarinag.marvelapi.utils.generateHash
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelAuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val ts = Date().time
        val hash = generateHash(ts, BuildConfig.MARVEL_PRIVATE_KEY, BuildConfig.MARVEL_PUBLIC_KEY)

        val url =
            originalUrl.newBuilder()
                .addQueryParameter("apikey", BuildConfig.MARVEL_PUBLIC_KEY)
                .addQueryParameter("ts", ts.toString())
                .addQueryParameter("hash", hash)
                .build()
        val request = originalRequest.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}