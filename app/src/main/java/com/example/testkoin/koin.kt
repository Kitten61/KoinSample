package com.example.testkoin

import com.example.testkoin.repository.SomeRepository
import com.example.testkoin.repository.SomeRepositoryImpl
import com.example.testkoin.ui.screens.main.MainPresenter
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val mainModule = module {
    factory { MainPresenter(get()) }
    single<SomeRepository> { SomeRepositoryImpl(get()) }
    single { provideRetrofit(get()) }
    single { provideOkHttpClient() }
    single { provideApi(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectionSpecs(
            listOf(
                ConnectionSpec.COMPATIBLE_TLS,
                ConnectionSpec.CLEARTEXT
            )
        )
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("http://gallery.dev.webant.ru/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

fun provideApi(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}