package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.apiinterface

import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.model.BinList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {

    @GET("/{id}")
    fun DoBinList(@Path("id") str: String?): Call<BinList?>?
}