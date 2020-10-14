package com.example.getpostflex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.getpostflex.Models.Flex
import com.example.getpostflex.Models.UrlImageModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener{
            sendNetworkRequest()
            post()
        }
    }

    fun sendNetworkRequest(){
        val builder = Retrofit.Builder().baseUrl("http://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build();
        val apiInterface: ApiInterface = retrofit.create<ApiInterface>(ApiInterface::class.java)
        val call: retrofit2.Call<UrlImageModel> = apiInterface.getFile();
        call.enqueue(object: Callback<UrlImageModel> {

            override fun onFailure(call: retrofit2.Call<UrlImageModel>, t: Throwable){
                Log.i("Flex", t.message.toString())
            }

            override fun onResponse(
                call: retrofit2.Call<UrlImageModel>,
                response: Response<UrlImageModel>)
            {
                Log.i("Test", response.body()!!.file!![0].file!!)
            }


        })


    }
    fun post() {
        val buld = Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = buld.build()
        var interf = retrofit.create<ApiInterface>(ApiInterface::class.java)
        val call: retrofit2.Call<Flex> = interf.getPost("TEST","FLEX",228)
        call.enqueue(object : retrofit2.Callback<Flex> {
            override fun onFailure(call: Call<Flex>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Flex>, response: Response<Flex>) {
                showResponse(response.body().toString());
                Log.i("TAG", "post submitted to API." + response.body().toString());
            }
        })
    }

    private fun showResponse(toString: String) {
        textView.text = toString
    }
}