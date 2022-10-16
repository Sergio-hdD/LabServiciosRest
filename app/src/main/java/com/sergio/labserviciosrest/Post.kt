package com.sergio.labserviciosrest

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) //Le decimos a moshi que genere un adaptador
data class Post(
    //Generamos las variables que deben coincidir con las que tenemos en el json que queremos recibir
    var id : Int?, //Continúa solo si el id no es nulo
    var title : String,
    var userId : Int,
    var body : String
)
