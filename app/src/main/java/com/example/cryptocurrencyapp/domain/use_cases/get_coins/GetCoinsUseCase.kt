package com.example.cryptocurrencyapp.domain.use_cases.get_coins

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.data_trasnfer_object.toCoin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import com.example.cryptocurrencyapp.domain.server_data_models.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e: HttpException){

            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){

            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))

        }
    }
}