package me.firdaus1453.getapiretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postServices = DataRepository.create()
        postServices.getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                if (response.isSuccessful){
                    val data = response.body()

                    if (data != null) {
                        txtTitle.text = data.get(0).title
                        txtBody.text = data.get(0).body
                    }

                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
