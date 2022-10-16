package com.sergio.labserviciosrest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var tvServicioRest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creamos el llamado
        val api = RetrofitClient.retrofit.create(MyAPI::class.java)
        val callGetPost = api.getPosts()
        //enqueue es que permite hacer el llamado y después nos da un callback cuando responde la api
        callGetPost.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body()
                if (posts != null) {
                    tvServicioRest = findViewById(R.id.tvServiciosRest)
                    tvServicioRest.text = posts.toString()
                    Log.d("REST", posts.toString())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t : Throwable) {
                Log.e("REST", t.message?: "")
            }
        }

        )

    }
}