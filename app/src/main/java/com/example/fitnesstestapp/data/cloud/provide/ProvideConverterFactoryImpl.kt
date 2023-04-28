package com.example.fitnesstestapp.data.cloud.provide

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class ProvideConverterFactoryImpl : ProvideConverterFactory {
    override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
}