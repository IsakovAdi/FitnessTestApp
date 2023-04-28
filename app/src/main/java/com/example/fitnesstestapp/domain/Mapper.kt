package com.example.fitnesstestapp.domain

interface Mapper<From, To> {
    fun map(from: From): To
}