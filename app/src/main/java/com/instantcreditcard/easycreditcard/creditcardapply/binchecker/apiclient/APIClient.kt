package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.apiclient

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object APIClient {

    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl("https://lookup.binlist.net")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
}