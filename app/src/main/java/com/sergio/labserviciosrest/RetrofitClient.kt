package com.sergio.labserviciosrest

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient { //El tipo object hace que se genere una sola instancia es como el patrón singleton

    private val baseUrl = "https://jsonplaceholder.typicode.com"

    private val moshi = Moshi.Builder() //Hago un builder de moshi
        .addLast(KotlinJsonAdapterFactory()) //Agregamos un adapter, pero pedimos que se fabrique a partir de la clase "KotlinJsonAdapterFactory()"
        .build() //Que se construya

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}