package com.example.cryptocurrencyapp.data.remote

import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coin/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto
}