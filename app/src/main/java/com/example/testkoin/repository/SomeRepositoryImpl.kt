package com.example.testkoin.repository

import com.example.testkoin.Api
import com.example.testkoin.models.PaginationResponse
import com.example.testkoin.models.SomeModel
import kotlinx.coroutines.Deferred
import retrofit2.Response

class SomeRepositoryImpl(
    private val api: Api
) : SomeRepository {
    override suspend fun fetchSomeDataAsync(): Deferred<Response<PaginationResponse<SomeModel>>> =
        api.getImagesAsync()
}