package com.example.cryptocurrencyapp.domain.server_data_models

import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
