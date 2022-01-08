package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.server_data_models.Coin
import com.example.cryptocurrencyapp.domain.server_data_models.CoinDetail

data class CoinDetailState(

    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""

)
