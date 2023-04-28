package com.example.fitnesstestapp.data.cloud.provide

interface MakeService {
    fun <T> service(clasz: Class<T>): T
}