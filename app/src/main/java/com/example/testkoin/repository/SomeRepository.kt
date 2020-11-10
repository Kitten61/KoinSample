package com.example.testkoin.repository

import com.example.testkoin.models.PaginationResponse
import com.example.testkoin.models.SomeModel
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface SomeRepository {

    suspend fun fetchSomeDataAsync(): Deferred<Response<PaginationResponse<SomeModel>>>
    suspend fun fetchSomeDataAsfync(): Deferred<Response<PaginationResponse<SomeModel>>>
    suspend fun fetchSomeDatfaAsync(): Deferred<Response<PaginationResponse<SomeModel>>>

}
