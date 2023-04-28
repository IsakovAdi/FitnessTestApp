package com.example.fitnesstestapp.presentation.di

import com.example.fitnesstestapp.data.cloud.api.FitnessApi
import com.example.fitnesstestapp.data.cloud.provide.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideMakeService(
        retrofitBuilder: ProvideRetrofitBuilder,
    ): MakeService = MakeServiceImpl(retrofitBuilder = retrofitBuilder)

    @Provides
    fun provideMovieService(
        makeService: MakeService,
    ): FitnessApi = makeService.service(FitnessApi::class.java)


    @Provides
    fun provideProvideConverterFactory(): ProvideConverterFactory = ProvideConverterFactoryImpl()

    @Provides
    fun provideProvideInterceptorDebug(): ProvideInterceptor = ProvideInterceptorImpl.Debug()

    @Provides
    fun provideProvideOkHttpClientBuilder(
        provideInterceptor: ProvideInterceptor,
    ): ProvideOkHttpClientBuilder =
        ProvideOkHttpClientBuilderImpl(provideInterceptor = provideInterceptor)

    @Provides
    fun provideProvideRetrofitBuilder(
        provideConverterFactory: ProvideConverterFactory,
        provideOkHttpClientBuilder: ProvideOkHttpClientBuilder,
    ): ProvideRetrofitBuilder = ProvideRetrofitBuilderImpl(
        provideConverterFactory = provideConverterFactory,
        provideOkHttpClientBuilder = provideOkHttpClientBuilder
    )
}