package com.example.capyy
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class spalshactivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        //val hsw = intent.getStringExtra("highscore")
        val ip1=intent.getStringExtra("ip1")
        val ic1=intent.getStringExtra("ic1")
        val t1=intent.getStringExtra("name")
        val wordz=intent.getStringExtra("word")

        getmydata()
       supportActionBar?.hide()
       Handler().postDelayed({

            val intent = Intent(this, MainActivity1::class.java)


           intent.putExtra("ip1",ip1)
           intent.putExtra("name",t1)
           intent.putExtra("word",wordz)
           intent.putExtra("ic1",ic1)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        },5000)

    }
    private fun getmydata() {
        val tip = findViewById<TextView>(R.id.tip)


        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .build()
            .create(apiinterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<tips>{
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call:Call<tips>, response:Response<tips>){
              tip.text = "randomTip"
                if (response.isSuccessful) {
                    val tips = response.body()?.tips
                    if (tips != null && tips.isNotEmpty()) {
                        val randomTip = tips[Random.nextInt(tips.size)]
                        tip.text = randomTip
                        Log.d("STRING", randomTip)
                    }
                } else {
                    Log.d("Response Error", response.message())
                }
            }
            override fun onFailure(call: Call<tips>, t: Throwable) {

                Log.d("Failure", "ON FAILURE: ${t.message}")
            }
        })
    }


}


