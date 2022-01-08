package com.example.cryptocurrencyapp.domain.use_cases.get_coin

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.toCoin
import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.toCoinDetail
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import com.example.cryptocurrencyapp.domain.server_data_models.Coin
import com.example.cryptocurrencyapp.domain.server_data_models.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {

            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))

        }catch (e: HttpException){

            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){

            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))

        }
    }
}