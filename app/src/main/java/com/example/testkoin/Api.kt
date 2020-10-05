package com.example.testkoin

import com.example.testkoin.models.PaginationResponse
import com.example.testkoin.models.SomeModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("api/photos")
    fun getImagesAsync(): Deferred<Response<PaginationResponse<SomeModel>>>
}