package com.example.fitnesstestapp.data.cloud.provide

import retrofit2.Retrofit

interface ProvideRetrofitBuilder {
    fun provideRetrofitBuilder():Retrofit.Builder
}