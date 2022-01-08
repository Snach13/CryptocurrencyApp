package com.example.cryptocurrencyapp.domain.repository

import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}