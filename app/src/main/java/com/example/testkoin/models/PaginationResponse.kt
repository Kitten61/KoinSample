package com.example.testkoin.models

data class PaginationResponse<T>(
    val data: List<T>,
    val t: Int = 10
)
