package com.example.fitnesstestapp.data.cloud.provide

import retrofit2.Converter

interface ProvideConverterFactory {
    fun converterFactory():Converter.Factory
}