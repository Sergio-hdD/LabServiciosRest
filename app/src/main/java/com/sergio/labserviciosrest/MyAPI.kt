package com.sergio.labserviciosrest

import retrofit2.Call
import retrofit2.http.GET

interface MyAPI { //Acá se definen los métodos que se van a implementar

    @GET("/posts") //Completa la url para ecceder según como está definido en el lugar de dónde traemos los datos
    fun getPosts() : Call<List<Post>> //Call espera la respuesta

}